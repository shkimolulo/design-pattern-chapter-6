package _2.problematic_case;

/**
 * 6.2 문제점
 * 
 * 경합 조건(race condition)
 * 1. thread 1 이 인스턴스 생성 여부 확인, null 이어서 생성자 호출 
 * 2. 생성 전 thread 2 가 인스턴스 생성 여부 확인, null 이어서 생성자 호출
 * 3. 결과적으로 Printer 인스턴스 2개 생성
 */
class UserThread extends Thread {
	public UserThread(String name) {
		super(name);
	}
	
	public synchronized void run() {
		Printer printer = Printer.getPrinter();
		printer.print(Thread.currentThread().getName() + " pirnt using " + printer.toString() + ".");
	}
}

class Printer {
	private static Printer printer = null;
	
	// 상태 유지, 인스턴스마다 각각 만들어 유지 
	private int counter = 0;
	private Printer() { }
	
	public synchronized static Printer getPrinter() {
		if (printer == null) {
			try {
//				 인스턴스 생성 전, 고의적으로 1ms 정지
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str) {
//		synchronized(this) {
			counter++;
			System.out.println(str + ' ' + counter);

//		}
	}
}

public class Client {
	private static final int THREAD_NUM = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserThread[] user = new UserThread[THREAD_NUM];
		for(int i = 0; i < THREAD_NUM; i++) {
			user[i] = new UserThread((i + 1) + "-thread");
			user[i].start();
		}
	}
}
