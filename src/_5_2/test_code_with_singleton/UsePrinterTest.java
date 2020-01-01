package _5_2.test_code_with_singleton;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.TestCase;

class UsePrinter2 {
	public void doSomething(Printer printer) {
		String str = null;
		str = "UsePrinter 의 doSomething() 호출";
		
		printer.print(str);
	}
}

public class UsePrinterTest extends TestCase {
	public void testDoSomething() {
		FakePrinter fake = new FakePrinter();
		UsePrinter2 u = new UsePrinter2();
		u.doSomething(fake);
		assertEquals("UsePrinter 의 doSomething() 호출, FakePrinter 의 printer() 호출", fake.get());
	}
}
