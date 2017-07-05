package il.ac.wis.cs.playgo.playtoolkit;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;

import il.ac.wis.cs.s2a.runtime.lib.MSDMethod;
import il.ac.wis.cs.s2a.runtime.lib.MSDMethodSet;

/**
 * 
 * @author Michal Gordon
 * This view is a utility to add an Explain Play Out view to an application
 * The idea is to have a succint explanation of the play out scenario
 * To use, add:
 * 		ExplayOutViewUtil.getInstance().updateSelection(MSDm, monitoringEnabled, executingEnabled, coldViolation, hotViolation);
	In the MSDCoordinatorAspect afterImpl after a method is selected
	To add the view use your GUI to add 
			ExplayOutViewUtil.getInstance().addTreeView(mainPanel);
 */
public class ExplayOutViewUtil
{
	private String explay = "";
	private String prevExplay = "";
	private boolean needToClear = false;
	private boolean contNeedClearing = false;
	private MSDMethodSet blockedSet = new MSDMethodSet();
	private MSDMethodSet executedSet = new MSDMethodSet();
	private MSDMethod rootMethod = null;
	private MSDMethodSet contBlockedSet = new MSDMethodSet();
	private MSDMethodSet contExecutedSet = new MSDMethodSet();
	
	static ExplayOutViewUtil instance = null;
	
	private JTextPane display;
	private JTree tree;
	JTree contTree;
	private DefaultMutableTreeNode treeRoot;
	boolean contMessages = false;
	
	private int WIDTH = 400;
	private int HEIGHT = 500;
	
	private String ICON_FORBID = "images" + File.separatorChar + "stopsign.png"; 
	private String ICON_EVENT = "images" + File.separatorChar + "greenarrow.png"; 
	HashMap<String, ImageIcon>  iconImages;
	
	private ExplayOutViewUtil()
	{
		iconImages = new HashMap<String , ImageIcon>();
		try{
		File f  = new File(ICON_FORBID);
		BufferedImage tempIcon = null;
		if(f.exists())
		{
			tempIcon = ImageIO.read(f);
			iconImages.put(ICON_FORBID, new ImageIcon(tempIcon.getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			
		}
		f  = new File(ICON_EVENT);
		if(f.exists())
			tempIcon = ImageIO.read(f);
			iconImages.put(ICON_EVENT, new ImageIcon(tempIcon.getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		catch(IOException e){}
	}
	
	public static ExplayOutViewUtil getInstance()
	{
		if(instance == null)
			instance = new ExplayOutViewUtil();
		return instance;
	}
	
	public String getString()
	{
		return explay;
	}
	
	public void updateSelection(MSDMethod envMethod, MSDMethod selectedMethod, 
			MSDMethodSet monitoringEnabled, MSDMethodSet executingEnabled, 
			MSDMethodSet coldViolation, MSDMethodSet hotViolation)
	{
		
		//if no view - no need to update
		if(tree == null)
			return;
		
		contMessages = false;
		
		if(envMethod != null) {
			if(envMethod.messageIdStr.equals("env:Clock:tick")) {
				contMessages = true;
				
			}
		}

		//null means the end of a step, we should clear explayon the next time
		if(selectedMethod == null) {
			
			if(contMessages == false) {
				needToClear = true;
			
				return; // return only if 
			}
			else //cont messages and no selected method
			{
				contExecutedSet.clear();
				contBlockedSet.clear();
				
			}
			
		}
		else if(selectedMethod.LSCName != null)
		{	
			if(needToClear) {
				explay = "";
				executedSet.clear();
				blockedSet.clear();
				rootMethod = null;

				needToClear = false;

			}

			if(contMessages){
				
				//add message
				boolean contAdded = contExecutedSet.add(selectedMethod);
				
				//if messages were allready there, we clear the set to allow repopulation and cleanup and a feel of things happenning
				if(contAdded == false || contExecutedSet.size() > 8)  
				{ 
					//restart 
					contExecutedSet.clear();
					contBlockedSet.clear();
					contExecutedSet.add(selectedMethod);
				}
			}
			else
				executedSet.add(selectedMethod); //ExplayOut Info
		}
		
		
		if(rootMethod == null)
			rootMethod = envMethod;

		if(contMessages){
			contBlockedSet.clear();
			calcBlockedMessages(selectedMethod, executingEnabled, hotViolation, contBlockedSet);
		}
		else {
			blockedSet.clear();
			calcBlockedMessages(selectedMethod, executingEnabled, hotViolation, blockedSet);
		}
			
		//explay += getNiceMessage1(selectedMethod);
				
				
		//explay = getFullMessage();
		if(contMessages)
			updateTreeFromMessages(contExecutedSet, contBlockedSet, contTree);
		else
			updateTreeFromMessages(executedSet, blockedSet, tree);
		
		explay= "ENV: " + envMethod + "\n";
		explay += "SELECTED: " + selectedMethod + "\n";
		explay += "ME: " + trimString(monitoringEnabled) + "\n";
		explay += "EE: " + trimString(executingEnabled) + "\n";
		explay += "CV: " + trimString(coldViolation) + "\n";
		explay += "HV: " + trimString(hotViolation) + "\n";
		explay += "\n";
		System.out.println(explay);
		
//		if(prevExplay != explay) {
//			updateGUI(explay);
//			prevExplay = explay;
//		}
	}
	
	private void calcBlockedMessagesBlocked(MSDMethod selectedMethod, MSDMethodSet executingEnabled, MSDMethodSet hotViolation, MSDMethodSet outBlockedSet){
		//check if there are interesting things NOT happening aka blocked
		//and write them, these are executing enabled, that are not selected,
		//and are in the hot violation of some other LSC
		MSDMethodSet tempSet = executingEnabled;
		
		if(selectedMethod != null)
			tempSet.remove(selectedMethod);
		
		//if the selected method is nothing, and the executable is empty
		//this is the case to reset blocked
		outBlockedSet.clear();
		
		for (MSDMethod m1 : tempSet) {
			for (MSDMethod m2 : hotViolation) {
								
				if(m1.messageIdStr.equals(m2.messageIdStr))
												
					//blocked are added once if they have allready been blocked
					if(outBlockedSet.contains(m2) == false)
						outBlockedSet.add(m2);
			}
		}

	}
	private void calcBlockedMessages(MSDMethod selectedMethod, MSDMethodSet executingEnabled, MSDMethodSet hotViolation, MSDMethodSet outBlockedSet){
		//check if there are interesting things NOT happening aka blocked
		//and write them, these are executing enabled, that are not selected,
		//and are in the hot violation of some other LSC
		MSDMethodSet tempSet = executingEnabled;
		
		if(selectedMethod != null)
			tempSet.remove(selectedMethod);
		
		//if the selected method is nothing, and the executable is empty
		//this is the case to reset blocked
		if(selectedMethod == null && executingEnabled.size() == 0)
			outBlockedSet.clear();
		
		for (MSDMethod m1 : tempSet) {
			for (MSDMethod m2 : hotViolation) {
								
				if(m1.messageIdStr.equals(m2.messageIdStr))
												
					//blocked are added once if they have allready been blocked
					if(outBlockedSet.contains(m2) == false)
						outBlockedSet.add(m2);
			}
		}

	}
	
	private String getFullMessage()
	{
		//get the executed messages, and blocked messages that are not in executed		
		//simplify - we care about messages that were blocked,
		//and were not executed at any point
		//so we add as blocked, only if the itself is not in explay
		String msg = "";
		for (MSDMethod msdMethod : executedSet) {
			msg += getNiceMessage(msdMethod);
		}
		
		//check if a blocked method, had not been executed later on, hence,
		//it was blocked only temporarily and does not interest us
		for (MSDMethod blockedMethod : blockedSet) {
			boolean blocked = true;
			for (MSDMethod eMethod : executedSet) {
				if(eMethod.messageIdStr.equals(blockedMethod.messageIdStr))
				{
					if(eMethod.args != null){ //if necessary compare args as well
						if(eMethod.args.equals(blockedMethod.args))
							blocked = false;
					}
					else
						blocked = false;
					break;
				}
			}
			if(blocked)
				msg += "BLOCKED " + getNiceMessage(blockedMethod);

		}
		return msg;
	}
	
	
	private void updateTreeFromMessages(MSDMethodSet executedSet, MSDMethodSet blockedSet, JTree tree)
	{
		//get the executed messages, as a tree
		//at this point just simple tree, not hierarchical in any way
         
        ArrayList<ExplainEvent> expEvents = new ArrayList<ExplainEvent>();
		String msg = "";
		ExplainEvent e;
		for (MSDMethod msdMethod : executedSet) {
			e = getExplainEventFromMessage(msdMethod, false);
			if(e!= null)
				expEvents.add(e);
			
		}
		for (MSDMethod blockedMethod : blockedSet) {
			boolean blocked = true;
			for (MSDMethod eMethod : executedSet) {
				if(eMethod.messageIdStr.equals(blockedMethod.messageIdStr))
				{
					if(eMethod.args != null){ //if necessary compare args as well
						if(eMethod.args.equals(blockedMethod.args))
							blocked = false;
					}
					else
						blocked = false;
					break;
				}
			}
			if(blocked){
				expEvents.add(getExplainEventFromMessage(blockedMethod, true));
				
			}
		}
		
		// we explain only if there is what, otherwise the previous explanation is left
//		if(expEvents.size() > 0){ 	
			if(tree != null) {
				DefaultMutableTreeNode treeRoot = (DefaultMutableTreeNode)tree.getModel().getRoot();
				treeRoot.removeAllChildren();
		        for (ExplainEvent event : expEvents) {
		            DefaultMutableTreeNode node = new DefaultMutableTreeNode(event);
		            treeRoot.add(node);
		        }
		        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		        model.reload();
			}
//		}
	}
	
	private ExplainEvent getExplainEventFromMessage(MSDMethod msdMethod, boolean blocked)
	{
		if(instance != null){
		ExplainEvent e = instance.new ExplainEvent();
		
		e.lscName = getLscShortName(msdMethod.LSCName);
		e.method = msdMethod.getMessageName();	
		if(msdMethod.args != null)
			e.method += msdMethod.args.toString();
		e.target = msdMethod.getTargetInstanceName() ;
		
		if(blocked)
			e.iconName = ICON_FORBID;
		else
			e.iconName = ICON_EVENT;
		return e;
		}
		else
			return null;

	}
	
	private String getNiceMessage(MSDMethod msdMethod)
	{
		String sNice;
		sNice =  msdMethod.getTargetInstanceName() +
				"->" + msdMethod.getMessageName();	
		if(msdMethod.args != null)
			sNice += msdMethod.args.toString();
		
		sNice += " in LSC:[" + getLscShortName(msdMethod.LSCName) + " ]"; 
		sNice += "\n";
		
		return sNice;

	}
	
	private String getLscShortName(String lscName){
		String shortName = lscName;
	
		String prefix = "";
		String suffix = "";
		if(lscName.contains("_"))
		{
			int i = lscName.lastIndexOf("_");
			if(i+1 < lscName.length()) {
				prefix = lscName.substring(0, i);
				suffix = lscName.substring(i+1);
				
				//if there's a prefix, and it's repeated in the LSC, remove it
				if(prefix.length() > 0 && suffix.contains(prefix) == true)
					shortName = lscName.substring(i+1);
			}
				
		}
		return shortName;
	}
	
	private String getNiceMessage1(MSDMethod msdMethod)
	{
		String s;
		String lscName = null, method = null;
		int iS, iE;

		String sStart = "MSDMethod: LSC->";
		s = msdMethod.toString();
		//get LSC name
		iS = s.indexOf(sStart);
		iE = s.indexOf("||");
		if(iS >= 0 && iE > iS && iE < s.length())
			lscName = s.substring(iS + sStart.length(), iE);
		
		iS = s.indexOf(":", iE);
		if(iS + 2 < s.length())
			method = s.substring(iS+1);
		
		if(method != null && msdMethod.args != null)
			method += msdMethod.args.toString();
	
		return lscName + "   " + method + "\n";
	}
	
	private String trimString(MSDMethodSet set)
	{
		if(set.size() == 0) return "";
		else {
			String s = set.toString();
		int is = s.indexOf("{\n\t");
		int ie = s.indexOf("\n}\n", is);
		s = s.substring(is+3,  ie);
		return s;
		}
		
	}
		
	public void addView(JPanel parentPanel)
	{
		Dimension d = parentPanel.getPreferredSize();
		display = new JTextPane();
		display.setSize(400, 300);
		display.setLocation(5, 505);
		parentPanel.add(display);
	}
	
	
	public void updateGUI(final String explay) {
				
		   if (!SwingUtilities.isEventDispatchThread()) {
		     SwingUtilities.invokeLater(new Runnable() {
		       @Override
		       public void run() {
		    	   if(display != null)
		    		   display.setText(explay);
		    	   else if(tree != null) {
		    		   tree.setVisible(true);
		    	   }
		    	   
		    	   System.out.println(explay);
		       }
		     });
		}
	}
	
	private JTree createTree(String rootName)
	{
		DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(rootName);
		JTree tree = new JTree(treeRoot); // getTreeForMessages());
        tree.setSize(WIDTH, HEIGHT);
        tree.setCellRenderer(new TreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value,
					boolean selected, boolean expanded, boolean leaf, int row,
					boolean hasFocus) {
				
				JLabel label = new JLabel();
	            Object o = ((DefaultMutableTreeNode) value).getUserObject();
	            if (o instanceof ExplainEvent) {
	            	ExplainEvent eevent = (ExplainEvent) o;
	                ImageIcon ic = iconImages.get(eevent.getIcon());
	                if (ic != null) {
	                    label.setIcon(iconImages.get(eevent.getIcon()));
	                }
	                label.setText(eevent.getText());
	            } else {
	                label.setIcon(null);
	                label.setText("" + value);
	            }
	            return label;
				}
		});
        
        return tree;
	
	}
	
	
	
	public void addTreeView(JPanel parent)
	{
	    /*	treeRoot = new DefaultMutableTreeNode("External Event");
	        tree = new JTree(treeRoot); // getTreeForMessages());
	        tree.setSize(WIDTH, HEIGHT);
	        tree.setCellRenderer(new TreeCellRenderer() {
				
				@Override
				public Component getTreeCellRendererComponent(JTree tree, Object value,
						boolean selected, boolean expanded, boolean leaf, int row,
						boolean hasFocus) {
					
					JLabel label = new JLabel();
		            Object o = ((DefaultMutableTreeNode) value).getUserObject();
		            if (o instanceof ExplainEvent) {
		            	ExplainEvent eevent = (ExplainEvent) o;
		                ImageIcon ic = iconImages.get(eevent.getIcon());
		                if (ic != null) {
		                    label.setIcon(iconImages.get(eevent.getIcon()));
		                }
		                label.setText(eevent.getText());
		            } else {
		                label.setIcon(null);
		                label.setText("" + value);
		            }
		            return label;
					}
			});
*/
		
			tree = createTree("External Event");
			treeRoot = (DefaultMutableTreeNode)tree.getModel().getRoot();
		
	        parent.setLayout(new BorderLayout());
	   
	        //add single tree
//	        JScrollPane pane = new JScrollPane(tree);
//	        pane.setPreferredSize(new Dimension(parent.WIDTH/2, 200));
//	        parent.add(pane, BorderLayout.PAGE_END);

	        
	        //setSize(WIDTH, HEIGHT);
			JPanel containerPanel = new JPanel();
			containerPanel.setLayout(new BorderLayout());
			containerPanel.setPreferredSize(new Dimension(parent.WIDTH, 200));
			parent.add(containerPanel, BorderLayout.PAGE_END);
			
			JLabel label = new JLabel("Explain Play Out:");
			containerPanel.add(label, BorderLayout.PAGE_START);
//
//			JCheckBox check = new JCheckBox("Show cyclic info");
//			containerPanel.add(check, BorderLayout.);
			
			JPanel flowPane = new JPanel();
			flowPane.setLayout(new FlowLayout());
			containerPanel.add(flowPane, BorderLayout.CENTER);
//
	        JScrollPane paneLeft = new JScrollPane(tree);
	        paneLeft.setPreferredSize(new Dimension(300, 200));

	        //parent.add(pane, BorderLayout.PAGE_END);
	        //containerPanel.add(paneLeft, BorderLayout.CENTER);
	        flowPane.add(paneLeft);
	
//			JCheckBox check = new JCheckBox("Show cyclic info");
//			containerPanel.add(check, BorderLayout.LINE_END);

			contTree = createTree("Continues Events");

	       JScrollPane paneRight = new JScrollPane(contTree);
	       paneRight.setPreferredSize(new Dimension(300, 200));
//	       containerPanel.add(paneRight, BorderLayout.LINE_END);
	       flowPane.add(paneRight);

//	    public static void main(String[] args) {
//	        SwingUtilities.invokeLater(new Runnable() {
//	            public void run() {
//	                new JTreeDifferentNodeIcon().setVisible(true);
//	            }
//	        });
	    }

	
	
    class ExplainEvent {
        private String lscName;
        private String method;
        private String target;
        private String iconName;

        public ExplainEvent()
        {
            this.lscName = "";
            this.method = "";
            this.target = "";
            this.iconName = "";      	
        }
        
        public ExplainEvent(String lscName, String method, String target, String iconName) {
            this.lscName = lscName;
            this.method = method;
            this.target = target;
            this.iconName = iconName;
        }

		public String getIcon() {
			return iconName;
			
		}     
		public String getText() {
			return target + " " + method + " (LSC: " + lscName + ")";
			
		}     
    }
    
}
