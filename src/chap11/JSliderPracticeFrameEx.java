package chap11;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSliderPracticeFrameEx extends JFrame {
	private JSlider slider = new JSlider(100,200,150);
	private JLabel label = new JLabel("        ");
	public JSliderPracticeFrameEx() {
		super("JSlider Practice Frame");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(slider);
		c.add(label);

		// 슬라이더의 속성 설정
		slider.setMajorTickSpacing(20);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);

		// 출력 레이블의 속성 설정
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.GREEN);
		label.setText(Integer.toString(slider.getValue()));

		// 슬라이더에 Change 리스너 작성
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				label.setText(Integer.toString(s.getValue()));
			}
		});

		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JSliderPracticeFrameEx();
	}
}
