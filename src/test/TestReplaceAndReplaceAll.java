package test;


public class TestReplaceAndReplaceAll {
	public static void main(String[] args) {
//		String x = "[kllkklk\\kk\\kllkk]";
//		long time;
//		long value;
//		String tmp;
//		//System.out.println(x.replace("[", "#").replace("]", "#"));
//		time = new Date().getTime();
//		System.out.println("startTime:" + time);
//		for(int i =0;i<1000000;i++)
//		tmp=x.replace("kk", "--");
//		value = new Date().getTime() - time;
//		time = new Date().getTime();
//		System.out.println("run replace:" + value);
//		for(int i =0;i<1000000;i++)
//		tmp=x.replaceAll("kk", "++");
//		value = new Date().getTime() - time;
//		System.out.println("run replaceAll:" + value);
		
		String src = "南京市玄武区北京东路徐州市鼓楼区戏马台";   
	    src = src.replaceAll("(?:江苏省|玄武区|鼓楼区)", "");  
	    System.out.println(src);  
	    
	    String src2 = "测试MMTT";   
	    src2 = src2.replaceAll("(?:TT|测试)", "");  
	    System.out.println(src2);  
	}
}
