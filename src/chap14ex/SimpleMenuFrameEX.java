package chap14ex;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuFrameEX extends JFrame {
	public SimpleMenuFrameEX() {
		super("메뉴 만들기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		setSize(300,200);
		setVisible(true);
	}
	private void createMenu() {
		JMenu fileMenu = new JMenu("파일");
		fileMenu.add(new JMenuItem("열기"));
		fileMenu.add(new JMenuItem("닫기"));
		
		JMenu editMenu = new JMenu("편집");
		
		JMenu zoomMenu = new JMenu("확대");
		zoomMenu.add(new JMenuItem("화면확대"));
		zoomMenu.add(new JMenuItem("쪽윤곽"));
		
		JMenu inputMenu = new JMenu("입력");
		
		JMenu viewMenu = new JMenu("보기");
		viewMenu.add(new JMenuItem("미리보가"));
		viewMenu.addSeparator(); // �и��� ����
		viewMenu.add(new JMenuItem("숨김"));
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(zoomMenu);
		mb.add(inputMenu);
		mb.add(viewMenu);
		setJMenuBar(mb);		
	}
	static public void main(String[] arg) {
		new SimpleMenuFrameEX();
	}
}
