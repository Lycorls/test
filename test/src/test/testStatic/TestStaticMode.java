package test.testStatic;

public class TestStaticMode {
	public TestStaticMode() {
		System.out.println("in structure");
	}

	static int i = 0;

	{
		System.out.println("in first no static i=" + i);
	}

	static {
		i = 1;
		System.out.println("in static i=" + i);
	}

	{
		System.out.println("in second no static i=" + i);
	}

	public static void main(String args[]) {
		TestStaticMode testStaticMode = new TestStaticMode();
		System.out.println("i=" + i);

	}
}
