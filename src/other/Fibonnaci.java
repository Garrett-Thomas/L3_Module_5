package other;

public class Fibonnaci {
	public static void main(String[] args) {
		Fibonnaci yum = new Fibonnaci();
		yum.makeFibbonaci();
	}
	public void makeFibbonaci() {
			int a = 0;
			System.out.println(a);
			int b = 1;
			System.out.println(b);
			int c = a + b;
			System.out.println(c);
			for (int i = 0; i < 8; i++) {
			System.out.println(a = c + b);
			System.out.println(b = a + c);
			System.out.println(c = a + b);
			}
			
		
	}
}
