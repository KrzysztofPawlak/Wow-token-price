package paka;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class window {

	public static void main(String[] args) {

		// download json file every x
		Timer timer = new Timer();
		test t = new test();
		timer.schedule(t, 0, 5000 * 12 * 10);
		
		// voice to speech
		Voice voice = new Voice("kevin16");
		
		// window event
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				myFrame frame = new myFrame();

				// update window every x
				Timer timer2 = new Timer();
				timer2.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						frame.jBuy.setText("" + t.getBuy());
						frame.jMin24.setText("" + t.getMin24());
						frame.jMax24.setText("" + t.getMax24());
						frame.jDate.setText(t.getTime());
						frame.jAgo.setText("" + t.getDif());
						if (frame.getWorking() == true && frame.getJtext1() > 0) {
							if (t.getBuy() <= frame.getJtext1()) {
//								Toolkit.getDefaultToolkit().beep();
								voice.say("" + frame.getJtext1());
								System.out.println(frame.getJtext1());
							}
							if(("" + frame.getJtext1()).isEmpty()) {
								System.out.println("pusto");
							} else {
								System.out.println("cos jest");
							}
						}
					}
					
				}, 10000, 5000 * 12 * 10); // after 10 sek, started scanning every x
			}
		}); // end window event

		// if beep not working on ubuntu it means: pcspks module isn't loaded.
		// type in terminal to checking this: lsmod | grep pcspkr
		// if results looks like: pcspkr 12718 0
		// load this module using: sudo modprobe pcspkr
		// disable this: sudo modprobe -r pcspkr

	}

}