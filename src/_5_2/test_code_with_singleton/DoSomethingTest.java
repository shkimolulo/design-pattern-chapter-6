package _5_2.test_code_with_singleton;

import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;

class UsePrinter {
	public void doSomething() {
		String str = null;
		str = "UsePrinter 의 doSomething() 호출";
		
		PrinterFactory.getPrinterFactory().getPrinter().print(str);
	}
	
//	public void print(String str) { }
}

class PrinterFactory {
	private static PrinterFactory printerFactory = null;
	protected PrinterFactory() {}
	
	public synchronized static PrinterFactory getPrinterFactory() {
		if (printerFactory == null) {
			printerFactory = new PrinterFactory(); 
		}
		return printerFactory;
	}
	
	public static void setPrinterFactory(PrinterFactory p) {
		printerFactory = p;
	}
	
	public Printer getPrinter() {
		return new FakePrinter();
	}
}

class FakePrinterFactory extends PrinterFactory {
	public Printer getPrinter() {
		return new FakePrinter();
	}
}

public class DoSomethingTest extends TestCase {
	public void testDoSomething() {
		FakePrinterFactory fake = new FakePrinterFactory();
		UsePrinter u = new UsePrinter();
		PrinterFactory.setPrinterFactory(fake);
		u.doSomething();
	}
}