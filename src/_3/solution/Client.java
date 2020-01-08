package _3.solution;

/**
 * 6.3 해결책 
 *  
 * 다중 스레드 문제 해결 방법
 * 
 * 1. 정적 변수에 인스턴스를 만들어 바로 초기화하는 방법
 * - 객체는 한 번만 생성되지만 count 아직 이상하게 출력 
 * - 여러 thread 가 하나뿐인 counter 변수 값에 동시에 접근해 갱신 
 * 
 * 2. 인스턴스를 만드는 메서드에 동기화하는 방법
 * - thread 1 이 getPrinter() 호출해서 실행중인 상태에서 
 * - thread 2 가 getPrinter() 호출하면 thread 1 실행 완료될 때까지 대기하고 있다가 완료되면 실행 
 * - synchronized 필요한 위치에 제한적 사용해 성능 영향 주지 않도록 주의 
 */
class UserThread extends Thread {
	public UserThread(String name) {
		super(name);
	}
	
	public void run() {
		Printer printer = Printer.getPrinter();
		printer.print(Thread.currentThread().getName() + " pirnt using " + printer.toString() + ".");
	}
}

// 1
//class Printer {
//	private static Printer printer = new Printer();
//	private int counter = 0;
//	private Printer() { }
//	
//	public static Printer getPrinter() {
//		return printer;
//	}
//	
//	public void print(String str) {
//		counter++;
//		System.out.println(str + ' ' + counter);
//	}
//}

// 2
class Printer {
	private static Printer printer = null;
    private int counter = 0;
    private Printer() { }
    
    public static synchronized Printer getPrinter() {
    	if (printer == null) {
    		printer = new Printer();
    	}
    	return printer;
    }
    
    public void print(String str) {
    	synchronized(this) {  // 오직 하나의 스레드만 접근을 허용함  
    		counter++;
        	System.out.println(str + ' ' + counter);
    	}
    }
}

public class Client {
	private static final int THREAD_NUM = 5;
	
	public static void main(String[] args) {
		UserThread[] user = new UserThread[THREAD_NUM];
		for(int i = 0; i < THREAD_NUM; i++) {
			user[i] = new UserThread((i + 1) + "-thread");
			user[i].start();
		}
	}
}
