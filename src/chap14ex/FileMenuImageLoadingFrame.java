package chap14ex;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileMenuImageLoadingFrame extends JFrame {
	public FileMenuImageLoadingFrame() {
		super("메뉴로 배경 이미지 로딩하기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		createMenu();
		setSize(400,400);
		setVisible(true);
	}
	
	private void createMenu() {
		
		
		JMenu fileMenu = new JMenu("파일");
		JMenu editMenu = new JMenu("편집");
		JMenu inputMenu = new JMenu("입력");

		JMenuItem colorMenuItem = new JMenuItem("열기");
		fileMenu.add(colorMenuItem);
		JMenuItem close = new JMenuItem("닫기");
		fileMenu.add(close);
		JMenu zoomMenu = new JMenu("확대");
		zoomMenu.add(new JMenuItem("화면확대"));
		zoomMenu.add(new JMenuItem("쪽윤곽"));
		JMenu viewMenu = new JMenu("보기");
		viewMenu.add(new JMenuItem("미리보기"));
		viewMenu.addSeparator(); // �и��� ����
		JMenuItem hideMenuItem = new JMenuItem("숨김");
		viewMenu.add(hideMenuItem);
		colorMenuItem.addActionListener(new OpenActionListener());
		close.addActionListener(new cOpenActionListener());
		hideMenuItem.addActionListener(new bOpenActionListener());
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		mb.add(zoomMenu);
		mb.add(inputMenu);

		mb.add(editMenu);

		mb.add(viewMenu);
		setJMenuBar(mb);		
	}

	class cOpenActionListener implements ActionListener {
		public cOpenActionListener() {
			dispose();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	class bOpenActionListener implements ActionListener {
		public bOpenActionListener() {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String filePath = null;
			MyPanel p = (MyPanel)getContentPane();
			ImageIcon icon = new ImageIcon(filePath);
			p.setBgImage(icon.getImage());
		}
	}
	
	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;
		public OpenActionListener() {
			chooser= new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG Images", "jpg");
		    chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", 
							"경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			MyPanel p = (MyPanel)getContentPane();
			ImageIcon icon = new ImageIcon(filePath);
			p.setBgImage(icon.getImage());
		}
	}

	class MyPanel extends JPanel {
		private Image bgImg = null;
		
		public void setBgImage(Image bgImg) {
			this.bgImg = bgImg;
			repaint();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			if(bgImg == null) // initially bgImg is null
				return;
			g.drawImage(bgImg, 0,0,this.getWidth(), this.getHeight(), this);
		}
	}
	
	static public void main(String[] arg) {
		new FileMenuImageLoadingFrame();
	}
}
