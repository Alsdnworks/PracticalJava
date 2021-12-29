package chap13ex;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VibratingLableEX extends JFrame{
	public VibratingLableEX() {
		setTitle("진동하는 프레임 만들기");
		Container c = getContentPane();
		this.setLayout(new BorderLayout());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn =new JButton("kill Timer");
		setSize(300,300);
		setLocation(100,100);
		setVisible(true);
		JLabel timerLabel = new JLabel();
		timerLabel.setText("진동 레이블");
		setFont(new Font("TimesRoman", Font.PLAIN, 40));

		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		c.add(timerLabel); // 컨텐트팬의 CENTER에 붙임
		c.add(btn,BorderLayout.SOUTH);
		
		
		VibratingThread thread = new VibratingThread(timerLabel);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.interrupt(); // Ÿ�̸� ������ ���� ����
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false); // ��ư ��Ȱ��ȭ
			}
		});
		c.add(btn,BorderLayout.NORTH);


		thread.start();
	}

	
	// Component를 상속받은 어떤 컴포넌트도 진동시킬 수 있는 스레드
	class VibratingThread extends Thread {
		private Component comp; // Component를 상속받은 어떤 컴포넌트
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		
		@Override
		public void run() {
			Random r = new Random();
			int y = comp.getY(); // 진동시키고자하는 컴포넌트의 시작 위치 x
			int x = comp.getX(); // 진동시키고자하는 컴포넌트의 시작 위치 y
			
			while(true) {
				try {
					Thread.sleep(10); // 10ms초 
				}
				catch(InterruptedException e) { return; }
				
				// sign은 방향
				int sign = (r.nextBoolean())? 1 : -1;
				int tmpX = x + r.nextInt(5)*sign;

				sign = (r.nextBoolean())? 1 : -1;
				int tmpY = y + r.nextInt(5)*sign;
				
				comp.setLocation(tmpX, tmpY);
				
				
	
						try {
							Thread.sleep(0); // 1�ʵ��� ���� �ܴ�.
						}
						catch(InterruptedException e) {
							return; // ���ܰ� �߻��ϸ� ������ ����
						}
					
				
				
			}
		}

	}
	public static void main(String [] args) {
		new VibratingLableEX();
	}
} 
