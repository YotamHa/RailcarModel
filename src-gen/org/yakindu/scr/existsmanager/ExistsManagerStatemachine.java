package org.yakindu.scr.existsmanager;
import java.util.ArrayList;
import java.util.HashMap;

import il.ac.wis.cs.playgo.ee.sct.IExecutionEngineSCT;
import il.ac.wis.cs.playgo.playtoolkit.ebridge.IExecutionBridge;
import il.ac.wis.cs.playgo.ee.sct.ExecutionBridge2SCT;
/*
 */

public class ExistsManagerStatemachine
		implements
			IExistsManagerStatemachine,
			IExecutionEngineSCT {

	private final boolean[] timeEvents = new boolean[0];

	private final class SCInterfaceImpl implements SCInterface {

		public boolean allocateExit1;

		public void raiseAllocateExit1() {
			allocateExit1 = true;
			systemEvent(selfClassName, selfObjectName, "allocateExit1");
			waitingRegions.remove(activeRegion);

		}

		public void allocateExit1() {
			allocateExit1 = true;
		}

		public boolean allocateExit2;

		public void raiseAllocateExit2() {
			allocateExit2 = true;
			systemEvent(selfClassName, selfObjectName, "allocateExit2");
			waitingRegions.remove(activeRegion);

		}

		public void allocateExit2() {
			allocateExit2 = true;
		}

		public boolean allocateExit3;

		public void raiseAllocateExit3() {
			allocateExit3 = true;
			systemEvent(selfClassName, selfObjectName, "allocateExit3");
			waitingRegions.remove(activeRegion);

		}

		public void allocateExit3() {
			allocateExit3 = true;
		}

		public boolean allocateExit4;

		public void raiseAllocateExit4() {
			allocateExit4 = true;
			systemEvent(selfClassName, selfObjectName, "allocateExit4");
			waitingRegions.remove(activeRegion);

		}

		public void allocateExit4() {
			allocateExit4 = true;
		}

		public boolean exitClear;

		public void raiseExitClear() {
			exitClear = true;
			systemEvent(selfClassName, selfObjectName, "exitClear");
			waitingRegions.remove(activeRegion);

		}

		public void exitClear() {
			exitClear = true;
		}

		public boolean exitAllocated;

		public void raiseExitAllocated() {
			exitAllocated = true;
			systemEvent(selfClassName, selfObjectName, "exitAllocated");
			waitingRegions.remove(activeRegion);

		}

		public void exitAllocated() {
			exitAllocated = true;
		}

		public boolean validAllocation;

		public void raiseValidAllocation() {
			validAllocation = true;
			systemEvent(selfClassName, selfObjectName, "validAllocation");
			waitingRegions.remove(activeRegion);

		}

		public void validAllocation() {
			validAllocation = true;
		}

		public boolean allocatingExit;

		public boolean isRaisedAllocatingExit() {
			return allocatingExit;
		}

		private void raiseAllocatingExit() {
			allocatingExit = true;
			systemEvent(selfClassName, selfObjectName, "allocatingExit");
			waitingRegions.remove(activeRegion);
		}

		private void allocatingExit() {
			allocatingExit = true;
		}

		public boolean exitBusy;

		public boolean isRaisedExitBusy() {
			return exitBusy;
		}

		private void raiseExitBusy() {
			exitBusy = true;
			systemEvent(selfClassName, selfObjectName, "exitBusy");
			waitingRegions.remove(activeRegion);
		}

		private void exitBusy() {
			exitBusy = true;
		}

		protected long platformHandling;
		public long getPlatformHandling() {
			return platformHandling;
		}

		public void setPlatformHandling(long value) {
			this.platformHandling = value;
			trace("platformHandling" + " = " + String.valueOf(value)
					+ " (external change)");
		}

		public void clearEvents() {
			allocateExit1 = false;
			allocateExit2 = false;
			allocateExit3 = false;
			allocateExit4 = false;
			exitClear = false;
			exitAllocated = false;
			validAllocation = false;
		}

		public void clearOutEvents() {
			allocatingExit = false;
			exitBusy = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_Idle, main_region_Busy, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ExecutionBridge2SCT timer;

	private final ArrayList<String> waitingRegions = new ArrayList<String>();

	private ExecutionBridge2SCT ebridge = null;

	private String selfObjectName = null;
	private String selfClassName = null;

	private String activeRegion = "existsManager";

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
		return "ExistsManager";
	}

	public ExistsManagerStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public ExistsManagerStatemachine(String selfObjName, String selfClassName) {
		this();

		this.selfObjectName = selfObjName;
		this.selfClassName = selfClassName;

		statesAbsoluteName.put("main_region_Idle",
				"ExistsManager.main_region.Idle");
		statesAbsoluteName.put("main_region_Busy",
				"ExistsManager.main_region.Busy");
		statesAbsoluteName.put("$NullState$", "$NullState$");
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.platformHandling = 0;

		sCInterface.platformHandling = (long) getPropertyValue(selfObjectName,
				selfClassName, "platformHandling", "long");

	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Idle;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Idle :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Busy :
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
		sCInterface.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCInterface.clearOutEvents();
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

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseAllocateExit1() {
		sCInterface.raiseAllocateExit1();
	}
	public void raiseAllocateExit2() {
		sCInterface.raiseAllocateExit2();
	}
	public void raiseAllocateExit3() {
		sCInterface.raiseAllocateExit3();
	}
	public void raiseAllocateExit4() {
		sCInterface.raiseAllocateExit4();
	}
	public void raiseExitClear() {
		sCInterface.raiseExitClear();
	}
	public void raiseExitAllocated() {
		sCInterface.raiseExitAllocated();
	}
	public void raiseValidAllocation() {
		sCInterface.raiseValidAllocation();
	}
	public boolean isRaisedAllocatingExit() {
		return sCInterface.isRaisedAllocatingExit();
	}
	public boolean isRaisedExitBusy() {
		return sCInterface.isRaisedExitBusy();
	}

	public long getPlatformHandling() {
		return sCInterface.getPlatformHandling();
	}

	public void setPlatformHandling(long value) {
		sCInterface.setPlatformHandling(value);
	}

	/* Entry action for statechart 'ExistsManager'. */
	private void entryAction() {
	}

	/* Exit action for state 'ExistsManager'. */
	private void exitAction() {
	}

	/* The reactions of state Idle. */
	private void react_main_region_Idle() {
		if (sCInterface.allocateExit1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.platformHandling = 1;

			sCInterface.raiseExitAllocated();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Busy;
		} else {
			if (sCInterface.allocateExit3) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.platformHandling = 3;

				sCInterface.raiseExitAllocated();

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Busy;
			} else {
				if (sCInterface.allocateExit2) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCInterface.platformHandling = 2;

					sCInterface.raiseExitAllocated();

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Busy;
				} else {
					if (sCInterface.allocateExit4) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						sCInterface.platformHandling = 4;

						sCInterface.raiseExitAllocated();

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Busy;
					}
				}
			}
		}
	}

	/* The reactions of state Busy. */
	private void react_main_region_Busy() {
		if (sCInterface.exitClear) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Idle;
		}
	}

	public void runCycle() {

		boolean stateVectorChanged = false;
		activeRegion = "existsManager";

		// copy of the original def protected runCycleFunction(ExecutionFlow flow) from Statemachine.xtend:
		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			State[] tempStateVector = stateVector.clone();

			switch (stateVector[nextStateIndex]) {
				case main_region_Idle :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("ExistsManager.main_region")) {
						activeRegion = "ExistsManager.main_region";
						react_main_region_Idle();
					}
					break;
				case main_region_Busy :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("ExistsManager.main_region")) {
						activeRegion = "ExistsManager.main_region";
						react_main_region_Busy();
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
		waitingRegions.add("ExistsManager.main_region");
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
