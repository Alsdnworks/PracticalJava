package chap13ex;

import java.util.Scanner;

public class CountingThreadConsoleEX {

	static public void main(String [] args) {
			while(true) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("아무 키나 입력>> ");
				scanner.nextLine(); // 어떤 키라도 입력되기를 기다림
				System.out.print("원본 1, 수정 2, 끝 3>> ");
				int a = scanner.nextInt(); // 어떤 키라도 입력되기를 기다림
				
				if(a == 1) {
					//Thread th = new Thread(new CountingThread());
					//th.start();
				}
				else if( a==2) {
					Thread th2 = new Thread(new CountingThread2());
					th2.start();//스레드 시작 아래에..
					System.out.println("메인 스레드 종료");//메인 스레드 종료를 넣어라..
				}
				else if (a==3) {
					return;
				}
			}
		// 아래의 join()이 없어도 됨.
		// 지름 main()은 종료하지만, 스레드 th는 살아 있음
		// 아래는 main()이 스레드 th가 종료되기를 기다렸다가 종료함
		/*try {
			th.join(); // 스레드 th가 종료되기를 기다림
		}
		catch(InterruptedException e) {	} */
	}
}

/*class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}*/

class CountingThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=30; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
		return;
	}
}
