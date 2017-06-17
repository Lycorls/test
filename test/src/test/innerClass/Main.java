package test.innerClass;

/**
 * http://blog.csdn.net/chenssy/article/details/13170015#reply
 * @author hefan
 * @date 创建时间：2017年6月2日 下午7:28:48
 *
 */
public class Main {
	public static void main(String[] args) {
		Test test = new Test();  
        test.test(new Bird() {  
              
            public int fly() {  
                return 10000;  
            }  
            
            public String getName() {  
                return "大雁";  
            }  
        });  
	}
}
