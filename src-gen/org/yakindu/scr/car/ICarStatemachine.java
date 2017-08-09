package org.yakindu.scr.car;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ICarStatemachine extends ITimerCallback, IStatemachine {
	public interface SCInterface {
		public void raiseInitCar();
		public void raiseDestinationSet();
		public void raiseEndDepart();
		public void raiseEndArrival();
		public void raiseAlert100();
		public boolean isRaisedStartArrival();
		public boolean isRaisedStartDepart();
		public String getMode();
		public void setMode(String value);
		public boolean getInTerminal();
		public void setInTerminal(boolean value);

	}

	public SCInterface getSCInterface();

}
