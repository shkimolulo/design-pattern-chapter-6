package _5_2.test_code_with_singleton;

// 싱글턴 패턴 사용
class RealPrinter315 implements Printer {	 
	private static RealPrinter315 printer = null;
	private RealPrinter315() { }
	
	public synchronized static RealPrinter315 getPrinter() {
		if (printer == null) {
			printer = new RealPrinter315();
		}
		return printer;
	}
	
	public void print(String str) {
		// 실제 프린터 하드웨어를 조작하는 코드
		System.out.println("RealPrinter315 의 printer() 호출, " + str);
	}
}
