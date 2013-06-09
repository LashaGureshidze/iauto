package ge.iauto.services;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CarExpirationTimeChecker {
private static Timer timer;
	
	private static TimerTask timerTask;
	
	public static void start(int secunds) {
		timer = new Timer("Currency Updater");
		timerTask = new TimerTask() {
			@Override
			public void run() {
				try {
					Date date = new Date();
					
				} catch (Throwable t) {
					System.out.println("carExpirationTimeChecker " + t.toString());
				}
			}
		};
		timer.schedule(timerTask, 0, secunds * 1000);
	}
	
	public static void shutdown() {
		timer.cancel();
		timerTask.cancel();
	}
}
