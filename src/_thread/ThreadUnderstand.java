package _thread;

/**
 * 책 '난 정말 JAVA를 공부한 적이 없다구요!' (p.660)
 *
 * thread
 * - process: 할당된 메모리 공간을 기반으로 실행 중에 있는 프로그램
 * - process 내에서 프로그램의 흐름 형성하는 주체 
 * 
 * start(), run()
 * - thread 는 자신만의 메모리 공간을 받아서 별도의 실행흐름 형성
 * - start() 호출 시, 메모리 공간 할당 등 thread 실행 위한 작업 후에 run() 대신 호
 */
class ShowThread extends Thread {
	String threadName;
	
	public ShowThread(String name)
	{
		threadName = name;
	}
	
	public void run()
	{
		for (int i = 0; i < 5; i++) 
		{			
			try {
				sleep(1);
				System.out.println("안녕하세요. " + threadName + " 입니다.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadUnderstand
{
	public static void main(String[] args)
	{
		ShowThread st1 = new ShowThread("AAA Thread");
		ShowThread st2 = new ShowThread("BBB Thread");
		
		st1.start();
		st2.start();
	}
}