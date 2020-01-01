package _thread;

/**
 * 책 '난 정말 JAVA를 공부한 적이 없다구요!' (p.681)
 * 
 * 변수 num(99) 에 +1 하는 thread 1, 2 있을 때
 * thread 1 이 참조한 값 99 에 +1 을 하고 num 에 100 을 저장하기 전에
 * thread 2 가 참조한 값 99 에 +1 을 하면
 * 두번째 thread 는 100 으로 증가된 값에 다시 100 을 저장
 */
class Increment
{
	int num = 0;
//	public void increment() { synchronized(this) { num++; } }
	public void increment() { num++; }
	public int getNum() { return num; }
}

class IncThread extends Thread
{
	Increment inc;
	
	public IncThread(Increment inc)
	{
		this.inc = inc;
	}
	
	public void run()
	{
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				inc.increment();
			}
		}
	}
}

class ThreadSyncError {
	public static void main(String[] args)
	{
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
	
		it1.start();
		it2.start();
		it3.start();
		
		try {
			it1.join();
			it2.join();
			it3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(inc.getNum());
	}
}
