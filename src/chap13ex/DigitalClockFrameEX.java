package chap13ex;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockFrameEX extends JFrame {
	public DigitalClockFrameEX() {
		setTitle("디지탈 시계 만들기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new MyLabels()); // 컨텐트팬의 CENTER에 붙임
		c.add(new MyLabel()); // 컨텐트팬의 CENTER에 붙임


		setSize(300,200);
		setVisible(true);
	}

	class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabel.this);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		
		public String makeClockText() {
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int date = c.get(Calendar.DATE);
			
			
			String clockText = Integer.toString(year);
			clockText = clockText.concat("년");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("월");
			clockText = clockText.concat(Integer.toString(date));
			clockText = clockText.concat("일");
			
			return clockText;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}
	
	class MyLabels extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabels() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabels.this);
			timerThread = new Thread(MyLabels.this);
			timerThread.start();
		}
		
		public String makeClockText() {
			Calendar c = Calendar.getInstance();			
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int date = c.get(Calendar.DATE);
			
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			return clockText;
		}
		public String makeClockTexts() {
			Calendar c = Calendar.getInstance();			
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int date = c.get(Calendar.DATE);
			
			
			String clockText = Integer.toString(year);
			clockText = clockText.concat("년");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("월");
			clockText = clockText.concat(Integer.toString(date));
			clockText = clockText.concat("일");
			
			return clockText;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}
	
	public static void main(String [] args) {
		new DigitalClockFrameEX();
	}
} 
