package chapter5.serlector.selectfortimeout;

import java.nio.channels.Selector;

public class WakeupThread extends Thread {

	private Selector sel;
	
	public WakeupThread(Selector sel) {
		super();
		this.sel = sel;
	}
    @Override
    public void run() {
    	try {
			currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	sel.wakeup();
    }
}
