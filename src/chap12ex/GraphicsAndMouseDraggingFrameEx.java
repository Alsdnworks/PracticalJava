package chap12ex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsAndMouseDraggingFrameEx extends JFrame {
	public GraphicsAndMouseDraggingFrameEx(){
		super("이미지 위에 드래깅 연습");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/wa.jpg");
		private Image img = icon.getImage();
		private int ovalX=100, ovalY=100; //  중심 좌표
		private final int RADIUS = 20; // 반지름
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint(); // 
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.CYAN);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS); // 그리기	
			g.setColor(Color.RED);
			g.drawString("wa 샌즈! 언더테일 아시는구나",(this.getWidth()/3), 40);
		}
	}
	
	static public void main(String[] args) {
		new GraphicsAndMouseDraggingFrameEx();
	}
}
