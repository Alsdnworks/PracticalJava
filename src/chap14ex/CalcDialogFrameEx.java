package chap14ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CalcDialogFrameEx extends JFrame {
	private JLabel resultLabel = new JLabel("계산 결과 출력");
	public CalcDialogFrameEx() {
		super("다이얼로그 만들기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("calculate");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.GREEN);		
		c.add(resultLabel);
		setSize(250,200);
		setVisible(true);
	}
	
	class MyActionListener implements  ActionListener {
		private CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(CalcDialogFrameEx.this);			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
				resultLabel.setText(Integer.toString(dialog.getResult()));
		}
	}

	class CalcDialog extends JDialog {
		private int sum = 0;
		private boolean bValid = false;
		private JTextField a = new JTextField(10);
		private JTextField b = new JTextField(10);
		private JButton aaddBtn = new JButton("   Add   ");
		private JButton saddBtn = new JButton("   Sub   ");
		private JButton maddBtn = new JButton("   Mul   ");
		private JButton daddBtn = new JButton("   Div   ");
		
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new BorderLayout());
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel1.add(new JLabel("두 수를 입력하세요."),BorderLayout.NORTH);
			panel2.add(a);
			panel2.add(b);
			panel3.add(aaddBtn);
			panel3.add(saddBtn);
			panel3.add(maddBtn);
			panel3.add(daddBtn);
			
			add(panel1,BorderLayout.NORTH);
			add(panel2,BorderLayout.CENTER);
			add(panel3,BorderLayout.SOUTH);
			
			
			aaddBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x + y;
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(CalcDialog.this, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			saddBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x - y;
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(CalcDialog.this, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});			
			maddBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x * y;
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(CalcDialog.this, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			daddBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x / y;
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(CalcDialog.this, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			setSize(400,200);
		}
		
		public boolean isValid() {
			return bValid;
		}
		public int getResult() {
			if(bValid)
				return sum;
			return 0;
		}
	}
	static public void main(String[] arg) {
		new CalcDialogFrameEx();
	}
}

