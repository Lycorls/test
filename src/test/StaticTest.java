package test;

public class StaticTest {
	public static void main(String[] args) {
		staticFunction();
	}
	
	static StaticTest st = new StaticTest();
	
	static{
		System.out.println("1");
	}
	
	{
		System.out.println("2");//对象初始化模块
	}
	
	StaticTest(){
		System.out.println("3");
		System.out.println("a=" + a + "    b=" + b);
	}
	
	public static void staticFunction(){
		System.out.println("4");
	}
	
	int a = 10;
	static int b = 112;
}
