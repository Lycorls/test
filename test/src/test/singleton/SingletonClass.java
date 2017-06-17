package test.singleton;

/**
 * 从JDK1.5开始，实现Singleton还有新的写法，只需编写一个包含单个元素的枚举类型。推荐写法：
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:26:01
 *
 */
public enum SingletonClass {  
    INSTANCE;  
 
    public void test(){  
        System.out.println("The Test!");  
    }  
}
