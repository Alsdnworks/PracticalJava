package chap14ex;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBarAndMessageDialogFrameEX extends JFrame {
	public ToolBarAndMessageDialogFrameEX() {
		super("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JToolBar tBar = new JToolBar();
		tBar.add(new JLabel("학번 : "));
		JTextField tf = new JTextField(8);
		tf.addKeyListener(new MyKeyListener());
		tBar.add(tf);
		c.add(tBar, BorderLayout.SOUTH);// 툴바는 반드시 BorderLayout 배치관리자가 있는 컨테이너에 붙여야 함
		
		setSize(400,300);
		setVisible(true);
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {// 숫자 키 아님
				String k = Character.toString(e.getKeyChar());
				k = k.concat("는 숫자 키가 아닙니다. \r\n숫자를 입력하세요.");
				JOptionPane.showMessageDialog(null, k, "경고", JOptionPane.ERROR_MESSAGE);
				e.consume(); // 현재 키 제거
			}
		}
	}

	static public void main(String[] arg) {
		new ToolBarAndMessageDialogFrameEX();
	}
}
