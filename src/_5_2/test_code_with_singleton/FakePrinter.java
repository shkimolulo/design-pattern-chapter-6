package _5_2.test_code_with_singleton;

//테스트용 가짜 프린터 
public class FakePrinter implements Printer {
	private String str;
	
	public void print(String str) {
		this.str = str + ", FakePrinter 의 printer() 호출";
	}
	
	public String get() {
		return str;
	}
}