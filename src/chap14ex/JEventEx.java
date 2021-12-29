package chap14ex;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JEventEx extends JFrame {
	public JEventEx() {
		super("JComponent 예제");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(500,800); 
		setVisible(true);		
	}
		
	class MyPanel extends JPanel {
		private JLabel la = new JLabel("14장 연습문제");
		private String [] text = {"1번", "1번 수정", "2번", "2번수정","4번", "4번수정", "6번", "6번 수정", "0번", "0번 수정","7번","7번 수정"}; 
		private JButton [] btn = new JButton[10]; 
	
		public MyPanel() {
			setBackground(Color.PINK);
			setLayout(null);
						
			la.setFont(new Font("Gothic", Font.BOLD, 40));
			la.setHorizontalAlignment(JLabel.CENTER); //JLabel 가운데 정렬
			la.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
			la.setBackground(Color.YELLOW); // 배경색 설정
			la.setSize(500, 100);

			add(la);

			for(int i=0; i<btn.length; i++) {
				btn[i] = new JButton(text[i]); 
				btn[i].setFont(new Font("Gothic", Font.PLAIN, 30));
				btn[i].setSize(180, 50);
				btn[i].setLocation(160, 110+i*60);			
				add(btn[i]);
			}	
			
			btn[0].addActionListener(new ActionListener() {	//1
				public void actionPerformed(ActionEvent e) {
					new SimpleMenuFrame();
				}
			});	
			btn[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SimpleMenuFrameEX();
				}
			});
			btn[2].addActionListener(new ActionListener() {	//2
				public void actionPerformed(ActionEvent e) {
					new FileMenuImageLoadingFrameEX();
				}
			});	
			btn[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FileMenuImageLoadingFrame();
				}
			});	
			btn[4].addActionListener(new ActionListener() {	//4
				public void actionPerformed(ActionEvent e) {
					new ToolBarAndMessageDialogFrameEX();
				}
			});
			btn[5].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ToolBarAndMessageDialogFrame();
				}
			});
			btn[6].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CalcDialogFrame();
				}
			});
			btn[7].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CalcDialogFrameEx();
				}
			});
			btn[8].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new JEventEx();
				}
			});
			btn[9].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new JEventEx();
				}
			});

					
		}
	}
	public static void main(String[] args) {
		new JEventEx();
	}
}