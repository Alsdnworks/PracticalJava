package chap10;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventEx extends JFrame {
	private JLabel la = new JLabel("마우스를 드래그 해보세요");
	public MouseEventEx() {
		super("마우스 어댑터 실습");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		MyMouseListener	listener = new MyMouseListener(); // ������ ��ü ����
		c.addMouseListener(listener); 		// MouseListener ������ ���
		c.addMouseMotionListener(listener);
		c.addMouseWheelListener(listener);

		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
		la.setForeground(Color.BLACK);
		c.add(la);

		setSize(250,150);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent d) {
			JComponent c = (JComponent)d.getSource();
			c.setFocusable(true);
			c.requestFocus();
			c.setBackground(Color.YELLOW);
			la.setText("Mouse Dragged");
			return;
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			JComponent c = (JComponent)e.getSource();
			c.setFocusable(true);
			c.requestFocus();
			c.setBackground(Color.GREEN);
			la.setText("Mouse Relesed");
			return;
		}		
		
		public void mouseWheelMoved(MouseWheelEvent f) { 
			int n = f.getWheelRotation();
			if(n < 0) {
			Font fo = la.getFont();
			int size = fo.getSize();
			la.setFont(new Font("seref",Font.BOLD,size+5));
			}
			else {
			Font fo = la.getFont();
			int size = fo.getSize();
			if (size <= 5) return;
			la.setFont(new Font("seref",Font.BOLD, size-5));
			}
		}
	}



	static public void main(String [] args) {
		new MouseEventEx();
	}
}