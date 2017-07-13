package org.yakindu.scr.car;
import org.yakindu.scr.ITimer;
import java.util.ArrayList;
import java.util.HashMap;

import il.ac.wis.cs.playgo.ee.sct.IExecutionEngineSCT;
import il.ac.wis.cs.playgo.playtoolkit.ebridge.IExecutionBridge;
import il.ac.wis.cs.playgo.ee.sct.ExecutionBridge2SCT;
/*
 import org.yakindu.scr.TimerService;
 */

public class CarStatemachine implements ICarStatemachine, IExecutionEngineSCT {

	private final boolean[] timeEvents = new boolean[1];

	private final class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		public boolean initCar;

		public void raiseInitCar() {
			initCar = true;
			systemEvent(selfClassName, selfObjectName, "initCar");
			waitingRegions.remove(activeRegion);

		}

		public void initCar() {
			initCar = true;
		}

		public boolean destinationSet;

		public void raiseDestinationSet() {
			destinationSet = true;
			systemEvent(selfClassName, selfObjectName, "destinationSet");
			waitingRegions.remove(activeRegion);

		}

		public void destinationSet() {
			destinationSet = true;
		}

		public boolean exitSynced;

		public void raiseExitSynced() {
			exitSynced = true;
			systemEvent(selfClassName, selfObjectName, "exitSynced");
			waitingRegions.remove(activeRegion);

		}

		public void exitSynced() {
			exitSynced = true;
		}

		public boolean arrived;

		public void raiseArrived() {
			arrived = true;
			systemEvent(selfClassName, selfObjectName, "arrived");
			waitingRegions.remove(activeRegion);

		}

		public void arrived() {
			arrived = true;
		}

		public boolean endDepart;

		public void raiseEndDepart() {
			endDepart = true;
			systemEvent(selfClassName, selfObjectName, "endDepart");
			waitingRegions.remove(activeRegion);

		}

		public void endDepart() {
			endDepart = true;
		}

		public boolean endArrival;

		public void raiseEndArrival() {
			endArrival = true;
			systemEvent(selfClassName, selfObjectName, "endArrival");
			waitingRegions.remove(activeRegion);

		}

		public void endArrival() {
			endArrival = true;
		}

		public boolean alert100;

		public void raiseAlert100() {
			alert100 = true;
			systemEvent(selfClassName, selfObjectName, "alert100");
			waitingRegions.remove(activeRegion);

		}

		public void alert100() {
			alert100 = true;
		}

		public boolean startArrival;

		public boolean isRaisedStartArrival() {
			return startArrival;
		}

		private void raiseStartArrival() {
			startArrival = true;
			systemEvent(selfClassName, selfObjectName, "startArrival");
			waitingRegions.remove(activeRegion);
		}

		private void startArrival() {
			startArrival = true;
		}

		public boolean startDepart;

		public boolean isRaisedStartDepart() {
			return startDepart;
		}

		private void raiseStartDepart() {
			startDepart = true;
			systemEvent(selfClassName, selfObjectName, "startDepart");
			waitingRegions.remove(activeRegion);
		}

		private void startDepart() {
			startDepart = true;
		}

		protected long iD;
		public long getID() {
			return iD;
		}

		public void setID(long value) {
			this.iD = value;
			trace("ID" + " = " + String.valueOf(value) + " (external change)");
		}

		protected long terminal;
		public long getTerminal() {
			return terminal;
		}

		public void setTerminal(long value) {
			this.terminal = value;
			trace("terminal" + " = " + String.valueOf(value)
					+ " (external change)");
		}

		protected long stopsAt;
		public long getStopsAt() {
			return stopsAt;
		}

		public void setStopsAt(long value) {
			this.stopsAt = value;
			trace("stopsAt" + " = " + String.valueOf(value)
					+ " (external change)");
		}

		protected String mode;
		public String getMode() {
			return mode;
		}

		public void setMode(String value) {
			this.mode = value;
			trace("mode" + " = " + String.valueOf(value) + " (external change)");
		}

		protected long destenation;
		public long getDestenation() {
			return destenation;
		}

		public void setDestenation(long value) {
			this.destenation = value;
			trace("destenation" + " = " + String.valueOf(value)
					+ " (external change)");
		}

		protected boolean inTerminal;
		public boolean getInTerminal() {
			return inTerminal;
		}

		public void setInTerminal(boolean value) {
			this.inTerminal = value;
			trace("inTerminal" + " = " + String.valueOf(value)
					+ " (external change)");
		}

		public void clearEvents() {
			initCar = false;
			destinationSet = false;
			exitSynced = false;
			arrived = false;
			endDepart = false;
			endArrival = false;
			alert100 = false;
		}

		public void clearOutEvents() {
			startArrival = false;
			startDepart = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_init, main_region_idle, main_region_standby, main_region_Operating, main_region_Operating_r1_departure, main_region_Operating_r1_Cruising, main_region_Operating_r1_arrival, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ExecutionBridge2SCT timer;

	private final ArrayList<String> waitingRegions = new ArrayList<String>();

	private ExecutionBridge2SCT ebridge = null;

	private String selfObjectName = null;
	private String selfClassName = null;

	private String activeRegion = "car";

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
		return "Car";
	}

	public CarStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public CarStatemachine(String selfObjName, String selfClassName) {
		this();

		this.selfObjectName = selfObjName;
		this.selfClassName = selfClassName;

		statesAbsoluteName.put("main_region_init", "Car.main_region.init");
		statesAbsoluteName.put("main_region_idle", "Car.main_region.idle");
		statesAbsoluteName
				.put("main_region_standby", "Car.main_region.standby");
		statesAbsoluteName.put("main_region_Operating",
				"Car.main_region.Operating");
		statesAbsoluteName.put("main_region_Operating_r1_departure",
				"Car.main_region.Operating.r1.departure");
		statesAbsoluteName.put("main_region_Operating_r1_Cruising",
				"Car.main_region.Operating.r1.Cruising");
		statesAbsoluteName.put("main_region_Operating_r1_arrival",
				"Car.main_region.Operating.r1.arrival");
		statesAbsoluteName.put("$NullState$", "$NullState$");
	}

	public void init() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.iD = 0;

		sCInterface.terminal = 0;

		sCInterface.stopsAt = 0;

		sCInterface.mode = "";

		sCInterface.destenation = 0;

		sCInterface.inTerminal = false;

		sCInterface.iD = (long) getPropertyValue(selfObjectName, selfClassName,
				"iD", "long");
		sCInterface.terminal = (long) getPropertyValue(selfObjectName,
				selfClassName, "terminal", "long");
		sCInterface.stopsAt = (long) getPropertyValue(selfObjectName,
				selfClassName, "stopsAt", "long");
		sCInterface.mode = (String) getPropertyValue(selfObjectName,
				selfClassName, "mode", "String");
		sCInterface.destenation = (long) getPropertyValue(selfObjectName,
				selfClassName, "destenation", "long");
		sCInterface.inTerminal = (boolean) getPropertyValue(selfObjectName,
				selfClassName, "inTerminal", "boolean");

	}

	public void enter() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_init;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_init :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_idle :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_standby :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Operating_r1_departure :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);
				break;

			case main_region_Operating_r1_Cruising :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Operating_r1_arrival :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			default :
				break;
		}

		switch (stateVector[0]) {
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

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
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

	public void raiseInitCar() {
		sCInterface.raiseInitCar();
	}
	public void raiseDestinationSet() {
		sCInterface.raiseDestinationSet();
	}
	public void raiseExitSynced() {
		sCInterface.raiseExitSynced();
	}
	public void raiseArrived() {
		sCInterface.raiseArrived();
	}
	public void raiseEndDepart() {
		sCInterface.raiseEndDepart();
	}
	public void raiseEndArrival() {
		sCInterface.raiseEndArrival();
	}
	public void raiseAlert100() {
		sCInterface.raiseAlert100();
	}
	public boolean isRaisedStartArrival() {
		return sCInterface.isRaisedStartArrival();
	}
	public boolean isRaisedStartDepart() {
		return sCInterface.isRaisedStartDepart();
	}

	public long getID() {
		return sCInterface.getID();
	}

	public void setID(long value) {
		sCInterface.setID(value);
	}
	public long getTerminal() {
		return sCInterface.getTerminal();
	}

	public void setTerminal(long value) {
		sCInterface.setTerminal(value);
	}
	public long getStopsAt() {
		return sCInterface.getStopsAt();
	}

	public void setStopsAt(long value) {
		sCInterface.setStopsAt(value);
	}
	public String getMode() {
		return sCInterface.getMode();
	}

	public void setMode(String value) {
		sCInterface.setMode(value);
	}
	public long getDestenation() {
		return sCInterface.getDestenation();
	}

	public void setDestenation(long value) {
		sCInterface.setDestenation(value);
	}
	public boolean getInTerminal() {
		return sCInterface.getInTerminal();
	}

	public void setInTerminal(boolean value) {
		sCInterface.setInTerminal(value);
	}

	/* Entry action for statechart 'Car'. */
	private void entryAction() {
	}

	/* Exit action for state 'Car'. */
	private void exitAction() {
	}

	/* The reactions of state init. */
	private void react_main_region_init() {
		if (sCInterface.initCar) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_idle;
		}
	}

	/* The reactions of state idle. */
	private void react_main_region_idle() {
		if (sCInterface.destinationSet) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_standby;
		}
	}

	/* The reactions of state standby. */
	private void react_main_region_standby() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		timer.setTimer(this, 0, 5 * 1000, true);

		sCInterface.raiseStartDepart();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Operating_r1_departure;
	}

	/* The reactions of state departure. */
	private void react_main_region_Operating_r1_departure() {
		if (sCInterface.endDepart) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 0);

			sCInterface.inTerminal = false;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Operating_r1_Cruising;
		} else {
			if (timeEvents[0]) {
				sCInterface.raiseStartDepart();
			}
		}
	}

	/* The reactions of state Cruising. */
	private void react_main_region_Operating_r1_Cruising() {
		if (sCInterface.alert100) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.raiseStartArrival();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Operating_r1_arrival;
		}
	}

	/* The reactions of state arrival. */
	private void react_main_region_Operating_r1_arrival() {
		if (sCInterface.endArrival) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if ((sCInterface.mode == null ? "pass" == null : sCInterface.mode
					.equals("pass"))) {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Operating_r1_Cruising;
			} else {
				if ((sCInterface.mode == null
						? "stop" == null
						: sCInterface.mode.equals("stop"))) {
					switch (stateVector[0]) {
						case main_region_Operating_r1_departure :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;

							timer.unsetTimer(this, 0);
							break;

						case main_region_Operating_r1_Cruising :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case main_region_Operating_r1_arrival :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default :
							break;
					}

					sCInterface.inTerminal = true;

					nextStateIndex = 0;
					stateVector[0] = State.main_region_idle;
				}
			}
		}
	}

	public void runCycle() {

		boolean stateVectorChanged = false;
		activeRegion = "car";

		// copy of the original def protected runCycleFunction(ExecutionFlow flow) from Statemachine.xtend:
		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			State[] tempStateVector = stateVector.clone();

			switch (stateVector[nextStateIndex]) {
				case main_region_init :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region")) {
						activeRegion = "Car.main_region";
						react_main_region_init();
					}
					break;
				case main_region_idle :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region")) {
						activeRegion = "Car.main_region";
						react_main_region_idle();
					}
					break;
				case main_region_standby :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region")) {
						activeRegion = "Car.main_region";
						react_main_region_standby();
					}
					break;
				case main_region_Operating_r1_departure :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region.Operating.r1")) {
						activeRegion = "Car.main_region.Operating.r1";
						react_main_region_Operating_r1_departure();
					}
					break;
				case main_region_Operating_r1_Cruising :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region.Operating.r1")) {
						activeRegion = "Car.main_region.Operating.r1";
						react_main_region_Operating_r1_Cruising();
					}
					break;
				case main_region_Operating_r1_arrival :
					// trigger transitions (i.e., call the corresponding react method) only for regions that are waiting regions
					if (waitingRegions.contains("Car.main_region.Operating.r1")) {
						activeRegion = "Car.main_region.Operating.r1";
						react_main_region_Operating_r1_arrival();
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
		waitingRegions.add("Car.main_region");
		waitingRegions.add("Car.main_region.Operating.r1");
		waitingRegions.add("Car._region1");
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
		/*
		this.setTimer(new TimerService());
		 */
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
