package _1.generate_printer_manager;

public class UsePrinter {
	private static final int USER_NUM = 10;
	
	public static void main(String[] args) {
		User[] user = new User[USER_NUM];
		
		for (int i = 0; i < USER_NUM; i++) {
			user[i] = new User((i + 1) + "-user");	// User 인스턴스 생성 
			user[i].print();
		}
	}
}