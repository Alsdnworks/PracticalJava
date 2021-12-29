package chap13ex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RockSissorsPaper_Game extends JFrame implements ActionListener{

   private static final long serialVersionUID = 1L;
   
   static int x; //유저가 사용할 값 x
   static int y; //컴퓨터가 랜덤으로 사용할 값 y
   
   static String user = "";
   static String com = "";
   //리스트 생성
   static List list = new List();
   //버튼생성
   JButton rock = new JButton("바위");
   JButton sissors = new JButton("가위");
   JButton paper = new JButton("보");
   
   public void RSP_Game() {
      //프레임 만들기
      setTitle("가위바위보 게임");
      setSize(400,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      //text생성&추가
      JLabel text = new JLabel("AI와 하는 가위바위보 게임 입니다.");
      JLabel text1 = new JLabel("가위, 바위, 보중 원하시는 것을 클릭해 주세요");
      c.add(text);
      c.add(text1);
      
      //버튼 추가
      c.add(rock);
      c.add(sissors);
      c.add(paper);
      
      //버튼 위치 조절
      sissors.setBounds(20,180,70,30);
      rock.setBounds(150,180,70,30);
      paper.setBounds(280,180,70,30);
      
      //액션리스너로 버튼 작동
      rock.addActionListener(this);
      paper.addActionListener(this);
      sissors.addActionListener(this);
      
      //리스트 생성,위치 조절
      list.setBounds(30,70,330,70);
      c.add(list);
   }
   //유저가 버튼 클릭
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == rock) {
         list.removeAll();
         list.add("바위를 고르셨습니다.");
         battle(com,"바위");
         result();
      }
      else if(e.getSource() == sissors) {
         list.add("가위를 고르셨습니다.");
         battle(com,"가위");
         result();
      }
      else if(e.getSource() == paper) {
         list.add("보를 고르셨습니다.");
         battle(com,"보");
         result();
      }   
   }
   static void result() {
      y = (int)(Math.random()*3);
      switch(y){
         case 0 : com = "가위";
         break;
         case 1 : com = "바위"; 
         break;
         default : com = "보"; 
         break;   
      }
   }
   static void battle(String com, String user) {
      if(com.equals("가위")){
         if(user.equals("가위")){
            list.add("컴퓨터는 가위를 골랐습니다..");
             list.add("아쉽게도 비겼습니다 ㅠㅠ.");
            }else if(user.equals("바위")){
             list.add("컴퓨터는 가위를 골랐습니다.");
             list.add("축하합니다!! 이겼습니다.");
            }else{
             list.add("컴퓨터는 보를 냈습니다.");
             list.add("헉!! 컴퓨터한테 지다니!");
            }
           }
      else if(com.equals("바위")){
         if(user.equals("가위")){
            list.add("컴퓨터는 가위를 골랐습니다.");
             list.add("헉!! 컴퓨터한테 지다니!");
            }else if(user.equals("바위")){
             list.add("컴퓨터는 가위를 골랐습니다.");
             list.add("아쉽게도 비겼습니다 ㅠㅠ.");
            }else{
             list.add("컴퓨터는 보를 냈습니다.");
             list.add("축하합니다!! 이겼습니다.");
            }
           }
      else {
         if(user.equals("가위")){
            list.add("컴퓨터는 가위를 골랐습니다.");
             list.add("축하합니다!! 이겼습니다.");
            }else if(user.equals("바위")){
             list.add("컴퓨터는 가위를 골랐습니다.");
             list.add("헉!! 컴퓨터한테 지다니!");
            }else{
             list.add("컴퓨터는 보를 냈습니다.");
             list.add("아쉽게도 비겼습니다 ㅠㅠ.");
            }
      }

   }

}


public class rockPaperScissors {
   public static void main(String[]args) {
      new RockSissorsPaper_Game();
   }

}