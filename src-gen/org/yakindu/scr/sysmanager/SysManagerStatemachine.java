package org.yakindu.scr.sysmanager;
import java.util.ArrayList;
import java.util.HashMap;

import il.ac.wis.cs.playgo.ee.sct.IExecutionEngineSCT;
import il.ac.wis.cs.playgo.playtoolkit.ebridge.IExecutionBridge;
import il.ac.wis.cs.playgo.ee.sct.ExecutionBridge2SCT;
/*
 */

public class SysManagerStatemachine
		implements
			ISysManagerStatemachine,
			IExecutionEngineSCT {

	private final boolean[] timeEvents = new boolean[0];

	public enum State {
		main_region_a, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ExecutionBridge2SCT timer;

	private final ArrayList<String> waitingRegions = new ArrayList<String>();

	private ExecutionBridge2SCT ebridge = null;

	private String selfObjectName = null;
	private String selfClassName = null;

	private String activeRegion = "sysManager";

	public String getSelfObjectName() {
		return selfObjectName;
	}

	public String getSelfClassName() {
		return selfClassName;
	}

	public String getActiveRegion() {
		return activeRegion;
	}

	public HashMap<String, String> statesAbsoluteName = new HashMap<String, String>();

	public String toString() {
		return this.getClass().getSimpleName() + "[" + this.selfObjectName
				+ ":" + this.selfClassName + "]";
	}

	// returns the case sensitive name of the statemachine
	public String getStatemachineName() {
		return "sysManager";
	}

	public SysManagerStatemachine() {

	}

	public SysManagerStatemachine(String selfObjName, String selfClassName) {
		this();

		this.selfObjectName = selfObjName;
		this.selfClassName = selfClassName;

		statesAbsoluteName.put("main_region_a", "sysManager.main_region.a");
		statesAbsoluteName.put("$NullState$", "$NullState$");
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_a;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_a :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	public ArrayList<String> getStateVector() {
		ArrayList<String> stateList = new ArrayList<String>();

		for (State state : stateVector) {
			stateList.add(statesAbsoluteName.get(state.toString()));
		}
		return stateList;
	}

	public ArrayList<String> getWaitingRegions() {
		return waitingRegions;
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/**
	 * Set the timer for the state machine to be implemented by the ExecutionBridge. It must be set
	 * externally on a timed state machine before a run cycle can be correctly
	 * executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ExecutionBridge2SCT timer) {
		this.timer = timer;
	}

	public ExecutionBridge2SCT getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	/* Entry action for statechart 'sysManager'. */
	private void entryAction() {
	}

	/* Exit action for state 'sysManager'. */
	private void exitAction() {
	}

	/* The reactions of state a. */
	private void react_main_region_a() {
	}

	public void runCycle() {

		boolean stateVectorChanged = false;
		activeRegion = "sysManager";

		// copy of the original def protected runCycleFunction(ExecutionFlow flow) from Statemachine.xtend:
		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			State[] tempStateVector = stateVector.clone();

			switch (stateVector[nextStateIndex]) {
				case main_region_a :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("sysManager.main_region")) {
						activeRegion = "sysManager.main_region";
						react_main_region_a();
					}
					break;
				default :
					// $NullState$
			}

			// if the stateVector changed and if a Tracer aspect exists, this info will be added to the PlayGo PlayoutView:
			for (int i = 0; i < stateVector.length; i++) { // need to iterate over all regions, as one reaction may effect many regions (e.g., in case of entrance to orthogonal state)
				String debugMsg = new String();
				if (!stateVector[i].toString().equals(
						tempStateVector[i].toString())) {
					stateVectorChanged = true;
					debugMsg = "Moved to "
							+ statesAbsoluteName.get(stateVector[i].toString());
				}
				if (!debugMsg.isEmpty()) {
					trace(debugMsg);
				}
			}
		}

		clearEvents();

		// Call runCycle recursively until the statemachine has no internal actions to perform.
		if (stateVectorChanged) {
			runCycle(); // runCycle (i.e., advance the statemachine) as long as it has internal actions to perform
		}

	}

	public void initSuperCycle() {
		// clearEvents(); // this removes also external/user events... must not clear all events...
		waitingRegions.clear();
		waitingRegions.add("sysManager.main_region");
	}

	public void endSuperCycle() {
		clearEvents();
	}

	@Override
	public boolean isFinal() {
		return false;
	}

	public void setExecutionBridge(IExecutionBridge eb) {
		this.ebridge = (ExecutionBridge2SCT) eb;
	}

	public void initEE() {
		/**/
		this.setTimer(this.ebridge);

		// enter the statemachine and activate the Idle state
		this.init();
		this.enter();
	}

	public void activateMethod(String className, String objectName,
			String methodName, String... arguments) {
		ebridge.activateMethod(className, objectName, methodName, arguments);
	}

	public void setPropertyValue(String className, String objectName,
			String propertyName, String value) {
		// ToDo: add implementation to call setter
	}

	public void systemEvent(String targetClassName, String targetObjectName,
			String eventName) {
		if (targetClassName.equals(selfClassName) && targetObjectName != null
				&& targetObjectName.equals(selfObjectName)) {
			ebridge.systemEvent(this.toString(), selfClassName, selfObjectName,
					eventName);
		} else {
			ebridge.systemEventSelfExcluded(this.toString(), selfClassName,
					selfObjectName, targetClassName, eventName);
		}
	}

	public void objectPropertyChanged(String className, String objectName,
			String propertyName, String type, String value) {
		ebridge.setOriginatedFromExecutionEngine(this.toString());
		ebridge.objectPropertyChanged(this.toString(), className, objectName,
				propertyName, type, value);
		ebridge.setOriginatedFromExecutionEngine(null);
	}

	public Object getPropertyValue(String objectName, String className,
			String propertyName, String type) {
		return ebridge.getPropertyValue(objectName, className, propertyName,
				type);

	}

	public void trace(String eventName) {
	}

}
