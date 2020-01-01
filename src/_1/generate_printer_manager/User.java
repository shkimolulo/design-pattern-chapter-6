package _1.generate_printer_manager;

/**
 * toString()
 * - 객체를 문자로 표현하는 메소드 
 * - toString 을 직접 호출하지 않아도 어떤 객체를 출력하면 자동으로 호출
 * - 참고 https://edu.goorm.io/learn/lecture/41/바로실습-생활코딩-자바-java/lesson/770/tostring
 */
public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public void print() {
		Printer printer = Printer.getPrinter();
		printer.print(this.name + " print using " + printer.toString() + ".");
	}
}