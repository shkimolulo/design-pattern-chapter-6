package _5_1.singleton_and_static;

/**
 * 6.4 싱글턴 패턴 
 * 
 * 싱글턴 패턴(Singleton Pattern)
 * - 싱글턴: 단 하나의 원소만을 가진 집합
 * - 인스턴스가 오직 하나만 생성되는 것 보장, 어디에서든 접근
 * 
 * 6.5 싱글턴 패턴과 정적 클래스
 * - 정적 메서드로만 이루어진 정적 클래스 -> 싱글턴 패턴과 동일한 효과 
 * - 객체 생성 X 메서드 사용 
 * - 컴파일 타임에 바인딩 되는 인스턴스 메서드보다 성능 우수 
 */
class Printer {
    private static int counter = 0;
    
    public synchronized static void print(String str) {
    	counter++;
    	System.out.println(str + ' ' + counter);
    }
}

class UserThread extends Thread {
	public UserThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Printer.print(Thread.currentThread().getName() + " print using " + ".");
	}
}

public class Client {
	private static final int THREAD_NUM = 5;
	
	public static void main(String[] args) {
		UserThread[] user = new UserThread[THREAD_NUM];
		for(int i = 0; i < THREAD_NUM; i++) {
			user[i] = new UserThread((i + 1) + "-thread");
			user[i].start();
			
			try {
				user[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
