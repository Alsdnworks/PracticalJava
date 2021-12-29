package chap12ex;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PolygonDrawPracticeEx extends JFrame {
	
	public PolygonDrawPracticeEx() {
		super("마우스로 폐다각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new MyPanel());
		this.setSize(750, 350);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private Vector<Point> v = new Vector<Point>();
		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point p = e.getPoint();
					v.add(p);
					repaint();
				}
			});
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);		
			for(int i = 0; i < v.size(); i++) {
				if(i == 0) {
					g.drawLine(v.elementAt(0).x, v.elementAt(0).y, v.lastElement().x, v.lastElement().y);
				}
			}
			for(int i = 0; i < v.size() - 1; i++) {
				g.drawLine(v.elementAt(i).x, v.elementAt(i).y, v.elementAt(i+1).x, v.elementAt(i+1).y);
			}
		}
	}
	
	public static void main(String[] args) {
		new PolygonDrawPracticeEx();
	}
}