package chap13ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class RandomCircleFrameEx extends JFrame {
	public RandomCircleFrameEx() {
		super("원을 0.5초 간격으로 랜덤한 위치로 이동시키는 스레드");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new CirclePanel());
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// Ÿ�̸� ���� ����� ���̺� ����
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel); // ���̺��� ����Ʈ�ҿ� ����
		TimerThread th = new TimerThread(timerLabel);

		th.start(); // Ÿ�̸� �����尡 ������ �����ϰ� �Ѵ�.
		
		setSize(250,250);
		setVisible(true);
	}
	class TimerThread extends Thread {
		private JLabel timerLabel; // Ÿ�̸� ���� ��µǴ� ���̺�
		
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel; // Ÿ�̸� ī��Ʈ�� ����� ���̺�
		}
		// ������ �ڵ�. run()�� �����ϸ� ������ ����
		@Override
		public void run() {
			int n=0; // Ÿ�̸� ī��Ʈ ��
			while(true) { // ���� ����
				timerLabel.setText(Integer.toString(n)); // ���̺� ī��Ʈ �� ���
				n++; // ī��Ʈ ����
				try {
					Thread.sleep(1000); // 1�� ���� ���� �ܴ�.
				}
				catch(InterruptedException e) {
					return; // ���ܰ� �߻��ϸ� ������ ����
				}
			}
		}
	}
	class CirclePanel extends JPanel implements Runnable {
		private int x = 100; // 원이 그려지는 위치
		private int y = 100;
		private int x1 = 0; // 원이 그려지는 위치
		private int y1 = 0;
		
		public CirclePanel() {
			this.addMouseListener(new MouseAdapter() {
				private Thread th = null;
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(th == null) { // 스레드가 아직 만들어지지 않았을 때만 스레드 생성
						th = new Thread(CirclePanel.this);
						th.start();
					}
				}
			});
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.drawOval(x, y, 50, 50); // (x, y)에서 50x50 크기 원
			g.setColor(Color.GREEN);
			g.drawRoundRect(x1, y1, 50, 50,10,10); // (x, y)에서 50x50 크기 원
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) { return; }
				
				// 원이 그려지는 위치를 랜덤하게 갱신
				x = (int)(Math.random()*this.getWidth()); // 패널의 범위 내에서 선택
				y = (int)(Math.random()*this.getHeight());
				x1 = (int)(Math.random()*this.getWidth()); // 패널의 범위 내에서 선택
				y1 = (int)(Math.random()*this.getHeight());
				repaint();

			}
		}		
	}
	
	public static void main(String[] args) {
		new RandomCircleFrameEx();
	}
}
