package _1.generate_printer_manager;

/**
 * 6.1 프린터 관리자 만들기
 * 
 * 10명의 직원이 프린터 하나만 공유해서 사용해야 할 때,
 * - Printer 생성자를 private 으로 선언 -> 외부 호출 X
 * - Printer 인스턴스 하나는 만들어야 함 -> 인스턴스 만들어 외부 제공할 메서드 필요 
 * 
 * static
 * - 구체적인 인스턴스가 아닌 클래스 자체에 속함 
 * - 클래스 인스턴스 통하지 않고 메서드 실행 및 변수 참조 가능
 */
public class Printer {
	// 인스턴스 생성 전 초기화, 클래스에서 생성된 모든 인스턴스들에게 공유 
	private static Printer printer = null;
	private Printer() {}

	public static Printer getPrinter() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	public void print(String str) {
		System.out.println(str);
		// Printer@(객체 식별할 수 있는 해시값)
	}
}