package chap11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class TextFieldAndComboBoxFrameEx extends JFrame {
	private JTextField tf = new JTextField(10);
	private JComboBox<String> combo = new JComboBox<String>();
	private Vector<String>v=new Vector<String>();
	private JList<String> list =new JList<String>(v); 
	
	public TextFieldAndComboBoxFrameEx() {
		super("JTextField and JComboBox Frame");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(tf);
		c.add(combo);		
		c.add(list);
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				combo.addItem(t.getText());
				v.add(t.getText());
				list.setListData(v);
				t.setText("");
			}
		});

		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TextFieldAndComboBoxFrameEx();
	}
}
