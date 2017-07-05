package playgo.systemmodel.generated;

import il.ac.wis.cs.playgo.playableComponents.swing.PlayableSystemModelObject;
import il.ac.wis.cs.playgo.playableComponents.swing.container.PlayablePanel;
import il.ac.wis.cs.playgo.playtoolkit.Utils;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.java.GuiJAgent;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp.GuiTcpAgent;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayableComponent;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayableContainer;
import il.ac.wis.cs.playgo.playtoolkit.container.PlayableFramework;
import il.ac.wis.cs.systemmodel.ObjectCreationType;
import il.ac.wis.cs.systemmodel.SystemModel;
import il.ac.wis.cs.systemmodel.SystemModelClass;
import il.ac.wis.cs.systemmodel.SystemModelObject;
import il.ac.wis.cs.systemmodel.SystemModelProperty;
import il.ac.wis.cs.systemmodel.impl.SystemModelImpl;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import playgo.systemmodel.SystemModelMain;

public class SystemModelGui extends PlayableFramework
{
	static final Font labelFont = new Font("Tahoma", Font.PLAIN, 12);
	static final Font boldLabelFont = new Font("Tahoma", Font.BOLD, 12);

	private final int LEFT_SPACER=5, UP_SPACER=3, TOP_SPACER=10;
	private final int SPACE_BETWEEN_SM_OBJECTS = 20;

	private final int FRAME_XPOS = 100;
	private final int FRAME_YPOS = 50;
	private final int MAX_FRAME_HEIGHT = 700;

	private final int MINIMAL_HEIGHT = 80;	
	private final int MINIMAL_WIDTH = 250;

	protected JFrame frame;
	private int TOP_POS=0;
	private int maxColWidth; 
	
	private JPanel mainPanel;
	private SystemModel sm;
	
	//CTOR
	public SystemModelGui(){
		super();
	}

	@Override
	protected void initPlayable() 
	{
		if (guiAgent == null)
		{
//	        String playInStr = System.getProperty("playInMode");
//	        if(playInStr!=null && playInStr.equals("true")){
			if (Utils.isPlayInMode()){
	        	guiAgent = new GuiTcpAgent(this, PORT);	//play-in 
	        }
	        else{
	        	guiAgent = new GuiJAgent(this);
	        	SystemModelMain.getInstance();
	        }
		}
	}
	
	@Override
	protected void initialize() 
	{
		frame = new JFrame("System Model GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(FRAME_XPOS, FRAME_YPOS);
		frame.setAlwaysOnTop(true);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		addComponentsToPane(mainPanel);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		frame.getContentPane().add(scrollPane);
	
		rePositionPanels();
	}
	
	//addComponentsToPane
	public void addComponentsToPane(Container pane) 
	{
		boolean plaInMode = false;
        String playInStr = System.getProperty("playInMode");
        if(playInStr!=null && playInStr.equals("true")){
        	plaInMode=true;
        }
		sm = new SystemModelImpl(new File("." +File.separator + ".system.model.xml"));
		ArrayList<SystemModelObject> allObjects = new ArrayList<SystemModelObject>();
		if(sm.getAllObjects()!=null && sm.getAllObjects().size()>0)
		{
			for (SystemModelClass smCls:sm.getClasses()){
				for(SystemModelObject smObj:sm.getObjects(smCls.getName(), false)){
					if(smObj.isGui(sm)){
						if( !plaInMode && smObj.getObjectCreationType()==ObjectCreationType.DYNAMIC_PLAY_IN){
							continue;	//skip DYNAMIC_PLAY_IN objects when not in playIn
						}
						allObjects.add(smObj);
					}
				}
			}
		}
		TOP_POS = TOP_SPACER;
		JPanel objPanel;
		for (SystemModelObject smObj : allObjects){
			objPanel = createPlayableSMObject(smObj);
			objPanel.setLocation(LEFT_SPACER, TOP_POS);
			TOP_POS += objPanel.getSize().height;
			pane.add(objPanel);
			TOP_POS += SPACE_BETWEEN_SM_OBJECTS;
		}
	}

	//createPlayableSMObject
	private JPanel createPlayableSMObject(String className, String objectName)
	{
		SystemModelClass smClass = sm.getClassByName(className);
		String playableComponent = smClass.getPlayableComponent();
		
		final PlayablePanel objPanel = new PlayablePanel(
				objectName, className, this);
		objPanel.setLayout(null);
		
		int objectTopPos = 0;

		IPlayableComponent playableComp = null;
		Component comp = null;

		//PlayableSystemModelObject is a special case
		if(playableComponent==null || playableComponent.equals(
				"il.ac.wis.cs.playgo.playableComponents.swing.PlayableSystemModelObject")){
			playableComp = createPlayableSystemModelObject(smClass, objectName);
			return (JPanel)playableComp;
		}else
		{
			try {
				Class<?> playableCls = Class.forName(playableComponent);
				Constructor<?> ctor = playableCls.getConstructor(
						String.class, String.class, IPlayableContainer.class);
				if(ctor==null){
					String mes = "PlayableComponets must define the following constructor:\n" +
							"public PlayableComponent(String name, String className, IPlayableContainer framework)";
					JOptionPane.showMessageDialog(
							null, mes, "Missing Constructor", JOptionPane.ERROR_MESSAGE);					
					throw new RuntimeException(mes);
				}
				playableComp = (IPlayableComponent) ctor.newInstance(
						objectName, className, this);
				
				if(smClass.getProperties()!=null && smClass.getProperties().size()>0){
					for(SystemModelProperty prop:smClass.getProperties()){
						playableComp.setPropertyValue(prop.getName(), prop.getDefaultValue());
					}
				}
				if(playableComp instanceof  JPanel){
					JPanel pp = (JPanel)playableComp; 
					pp.setSize(playableComp.getPlayableWidth(), playableComp.getPlayableHeight());
					return pp;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//wrap non JPanel components in a PlayablePanel
		int elementHeight = playableComp.getPlayableHeight();
		int elementWidth = playableComp.getPlayableWidth();
		
		comp = (Component) playableComp;
		comp.setBounds(LEFT_SPACER, objectTopPos, elementWidth, elementHeight);		

		if(elementWidth > maxColWidth){
			maxColWidth = elementWidth;
		}
		objectTopPos+=elementHeight;

		objPanel.add(comp);
		objPanel.map(objectName, playableComp, objectName);
		
		objPanel.setSize(playableComp.getPlayableWidth()+6*LEFT_SPACER,
				objectTopPos+2*UP_SPACER);

		return objPanel; 
	}
	
	//createPlayableSMObject
	private JPanel createPlayableSMObject(SystemModelObject smObj)
	{
		return createPlayableSMObject(smObj.getRepresentsClassName(), smObj.getName());
	}
	
	//createPlayableSystemModelObject
	private IPlayableComponent createPlayableSystemModelObject(
			SystemModelClass smClass, String objectName) 
	{
		PlayableSystemModelObject psm = new PlayableSystemModelObject(
				objectName, 
				smClass.getName(),
				this);
		psm.init(smClass, objectName);
		
		psm.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				rePositionPanels();
			}
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
			@Override
			public void componentMoved(ComponentEvent arg0) {
			}
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		return psm;
	}
	
	private String highlightedObject = null;
	
	@Override
	public void highlightObject(String objectName) 
	{
		if(mainPanel!=null && mainPanel.getComponents()!=null && 
				mainPanel.getComponents().length > 0)
		{
			IPlayableComponent ipcomp;
			for(Component comp:mainPanel.getComponents()){
				if(comp instanceof IPlayableComponent){
					ipcomp = (IPlayableComponent)comp;
					if(ipcomp.getName().equals(objectName)){
						ipcomp.highlightObject(objectName);
						highlightedObject = objectName;
					}
				}
			}
		}
	}
	
	@Override
	public void clearObject() 
	{
		if(mainPanel!=null && mainPanel.getComponents()!=null && 
				mainPanel.getComponents().length > 0)
		{
			if(highlightedObject==null){
				return;
			}
			IPlayableComponent ipcomp;
			for(Component comp:mainPanel.getComponents()){
				if(comp instanceof IPlayableComponent){
					ipcomp = (IPlayableComponent)comp;
					if(ipcomp.getName().equals(highlightedObject)){
						ipcomp.clearObject();
						highlightedObject = null;
					}
				}
			}
		}
	}
	
	//rePositionPanels
	private void rePositionPanels() 
	{		
		if(mainPanel==null){
			return;
		}
		if(mainPanel.getComponents()==null || mainPanel.getComponents().length<1){
			frame.setSize(MINIMAL_WIDTH, MINIMAL_HEIGHT);
			return;
		}
		List<Component> playablePanels = 
				(List<Component>) Arrays.asList(mainPanel.getComponents());

		int numOfCols, frameWidth;
		if(playablePanels.size()<6){	//one column in case if less than 5 objects
			numOfCols = 1;
			Dimension col1dim = drawColumn(1, numOfCols, playablePanels, LEFT_SPACER);
			frameWidth = col1dim.width + 12*LEFT_SPACER;
		}
		else{
			numOfCols = 2;
			Dimension col1dim = drawColumn(1, numOfCols, playablePanels, LEFT_SPACER);
			Dimension col2dim = drawColumn(2, numOfCols, playablePanels, 4*LEFT_SPACER + col1dim.width);
			frameWidth = col1dim.width + col2dim.width + 12*LEFT_SPACER;
			
			if(col1dim.height > col2dim.height){
				TOP_POS = col1dim.height; 
			}else{
				TOP_POS = col2dim.height;
			}
		}
		int frameHeight = TOP_POS + 50;
		if(frameHeight > MAX_FRAME_HEIGHT){
			frameHeight = MAX_FRAME_HEIGHT;
		}
		mainPanel.setPreferredSize(new Dimension(maxColWidth, TOP_POS));

		if(frame.getHeight()>frameHeight){	//do not shorten the frame
			frame.setSize(frameWidth, frame.getHeight());
		}else{
			frame.setSize(frameWidth, frameHeight);
		}
	}

	//drawColumn (returns column height)
	private Dimension drawColumn(int column, int totalColumns, List<Component> playablePanels, int colLeft) 
	{
		int colWidth = 0;
		Component panel;
		IPlayableComponent pp;
		TOP_POS = TOP_SPACER;
		
		for(int i=(column-1); i<playablePanels.size(); i+=totalColumns)
		{
			panel = playablePanels.get(i);
			panel.setLocation(colLeft, TOP_POS);
			
			pp = (IPlayableComponent)panel;
			if(pp.getPlayableWidth()>colWidth){
				colWidth = pp.getPlayableWidth();
			}
			int ppHeight;
			if(panel instanceof PlayablePanel &&((PlayablePanel)panel).
					getComponents()[0] instanceof PlayableSystemModelObject){
				PlayableSystemModelObject psmo = (PlayableSystemModelObject)((PlayablePanel)panel).getComponents()[0];
				ppHeight = psmo.getPlayableHeight();				
			}else{
				ppHeight = pp.getPlayableHeight();
			}
			TOP_POS += ppHeight + SPACE_BETWEEN_SM_OBJECTS;
		}
		return new Dimension(colWidth, TOP_POS);
	}

	@Override
	public void containerRepaint() {
		rePositionPanels();
	}
	
	//main
	public static void main(String[] args) 
	{
		try {
			SystemModelGui window = new SystemModelGui();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void construct(String className, String objectName) 
	{
		if(mainPanel!=null)
		{
			if(objectAlreadyExistsInMainPanel(objectName)){
				return;
			}
			JPanel objPanel = createPlayableSMObject(className, objectName);
			objPanel.setLocation(LEFT_SPACER, TOP_POS);
			TOP_POS += objPanel.getSize().height;
			mainPanel.add(objPanel);
			TOP_POS += SPACE_BETWEEN_SM_OBJECTS;
			
			rePositionPanels();
			appIsUp();
		}
	}

	//objectAlreadyExistsInMainPanel
	private boolean objectAlreadyExistsInMainPanel(String objectName) 
	{
		if(mainPanel==null){
			return false;
		}
		Component[] comps = mainPanel.getComponents();
		if(comps==null || comps.length<1){
			return false;
		}
		for(Component comp:comps){
			if(comp.getName().equals(objectName)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy(String className, String objectName) 
	{
		if(mainPanel==null){
			return;
		}
		Component[] comps = mainPanel.getComponents();
		if(comps==null || comps.length<1){
			return;
		}
		Component compToRemove = null;
		
		for(Component comp:comps){
			if(comp.getName().equals(objectName)){
				compToRemove = comp; 
				break;
			}
		}
		if(compToRemove!=null){
			mainPanel.remove(compToRemove);
			rePositionPanels();
		}
	}

	@Override
	public void playgoIsUp(boolean playOut) {
		// TODO Auto-generated method stub
	}
	
}
