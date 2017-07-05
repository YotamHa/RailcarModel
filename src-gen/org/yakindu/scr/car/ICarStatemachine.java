package org.yakindu.scr.car;
import org.yakindu.scr.IStatemachine;

public interface ICarStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseInitCar();
		public void raiseDestinationSet();
		public void raiseExitSynced();
		public void raiseArrived();
		public void raiseEndDepart();
		public void raiseEndArrival();
		public void raiseAlert100();
		public boolean isRaisedStartArrival();
		public boolean isRaisedStartDepart();
		public long getID();
		public void setID(long value);
		public long getTerminal();
		public void setTerminal(long value);
		public long getStopsAt();
		public void setStopsAt(long value);
		public String getMode();
		public void setMode(String value);
		public long getDestenation();
		public void setDestenation(long value);

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public String addStop(String stopsAt, String added);
		public String clearStop(String removed, String stopsAt);
		public String isStop(String terminal, String stopsAt);
	}

	public SCInterface getSCInterface();

}
