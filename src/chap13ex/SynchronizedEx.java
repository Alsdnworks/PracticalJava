package chap13ex;

public class SynchronizedEx {
	public static void main(String [] args) {
		SharedBoard board = new SharedBoard(); // ������ ���� ������ ����

		// ������ ���� �� �������� �ּҸ� �˷��ش�. �� ������� �����ǿ� ���ÿ� �����Ѵ�.
		Thread th1 = new StudentThread("kitae", board); // "kitae" �̸��� ������ ����
		Thread th2 = new StudentThread("hyosoo", board); // "hyosoo" �̸��� ������ ����
		
		// �� �����带 �����Ų��.
		th1.start();
		th2.start();
	}
}

// ��������Ÿ�� �������� �ùķ��̼��ϴ� Ŭ����
// �� WorkerThread �����忡 ���� ���� ���ٵ�
class SharedBoard {
	private int sum = 0; // �������� ��
	public void add() { // synchronized�� ������ ���, �� �޼ҵ忡 ��Ƽ������ �浹 �߻�
		int n = sum;
		Thread.yield(); // ���� ���� ���� ������ �纸
		n += 10; // 10 ����
		sum = n; // ������ ���� �����տ� ���
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}
	public int getSum() { return sum; }
}

// �л��� �ùķ��̼��ϴ� ������ Ŭ����
class StudentThread extends Thread {
	private SharedBoard board; // �������� �ּ�
	
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	// �������� 10�� �����Ͽ� ī�����Ѵ�.
	@Override
	public void run() {
		for(int i=0; i<10; i++) 
			board.add();	
	}
}