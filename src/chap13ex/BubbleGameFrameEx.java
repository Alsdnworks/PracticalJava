package chap13ex;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGameFrameEx extends JFrame{
	public int key;
	public BubbleGameFrameEx() {
		setTitle("버블 게임");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);	
		setVisible(true);

	}
	
	public static void main(String [] args) {
		new rockPaperScissors();
	}
}
class GamePanel extends JPanel {
	public int key;
	public GamePanel() {
		setLayout(null);
		setFocusable(true);
		requestFocus();
		addMouseListener(new MouseAdapter() {		
			@Override
			public void mousePressed(MouseEvent e) {
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();
			}
		});
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent d) {
				TextThread textThread = new TextThread(d.getKeyChar());
				textThread.start();
			}
		});
	}
	
	class BubbleThread extends Thread {
		private JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("images/bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); // GamePanel에 add()
			GamePanel.this.repaint();
		}
		
		@Override
		public void run() {
			while(true) {
				int x = bubble.getX() ;
				int y = bubble.getY() - 5;
				if(y < 0) {
					GamePanel.this.remove(bubble); // 컴포넌트 제거
					GamePanel.this.repaint(); // 컴포넌트 제거 후 패널 다시 그리기
					return; // thread ends
				}
				bubble.setLocation(x, y); // 컴포넌트 위치 이동
				GamePanel.this.repaint(); // 이동된 컴포넌트 다시 크리기
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
	
	class TextThread extends Thread {
		private JLabel la=new JLabel("");
		public TextThread(int key) {
			la.setLocation((int) (Math.random() * 300) ,(int) (Math.random() * 300) ); // la�� �ʱ� ��ġ�� (50,50)
			la.setSize(100,100);
			la.setText(Character.toString(key));
			add(la);
//			la.setText(Character.toString(key));
			GamePanel.this.repaint();
		}
		
		@Override
		public void run() {
			while(true) {
				int x = la.getX() ;
				int y = la.getY() - 5;
				if(y < 0) {
					GamePanel.this.remove(la); // 컴포넌트 제거
					GamePanel.this.repaint(); // 컴포넌트 제거 후 패널 다시 그리기
					return; // thread ends
				}
				la.setLocation(x, y); // 컴포넌트 위치 이동
				GamePanel.this.repaint(); // 이동된 컴포넌트 다시 크리기
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
