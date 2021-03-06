package chap12ex;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDrawPracticeFrameEx extends JFrame {
	public ImageDrawPracticeFrameEx(){
		super("이미지 그리기 연습");
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private JButton abutton = new JButton("Hide");
		private JButton bbutton = new JButton("Show");
		private boolean showFlag = true;
		
		public MyPanel() {
			setLayout(new FlowLayout());
			add(abutton);
			add(bbutton);
			
			abutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag = false; // true와 false의 토글
					MyPanel.this.repaint(); 
					// repaint()는 다시 paintComponent()가 호출되게 하여, 
					// showFlag가 true이면 그리고 false이면 그리지 않도록 함
				}				
			});
			bbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag = true; // true와 false의 토글
					MyPanel.this.repaint(); 
					// repaint()는 다시 paintComponent()가 호출되게 하여, 
					// showFlag가 true이면 그리고 false이면 그리지 않도록 함
				}				
			});
			
			
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(showFlag) // true이면 그리고 false이면 그리지 않음
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);			
		}
	}
	
	static public void main(String[] args) {
		new ImageDrawPracticeFrameEx();
	}
}
