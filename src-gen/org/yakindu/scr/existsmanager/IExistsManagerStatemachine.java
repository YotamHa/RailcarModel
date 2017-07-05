package org.yakindu.scr.existsmanager;
import org.yakindu.scr.IStatemachine;

public interface IExistsManagerStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseAllocateExit1();
		public void raiseAllocateExit2();
		public void raiseAllocateExit3();
		public void raiseAllocateExit4();
		public void raiseExitClear();
		public void raiseExitAllocated();
		public void raiseValidAllocation();
		public boolean isRaisedAllocatingExit();
		public boolean isRaisedExitBusy();
		public long getPlatformHandling();
		public void setPlatformHandling(long value);

	}

	public SCInterface getSCInterface();

}
