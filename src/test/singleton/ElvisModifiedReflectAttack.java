package test.singleton;

import java.lang.reflect.Constructor;  

/**
 * 测试修改后单例
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:40:31
 *
 */
public class ElvisModifiedReflectAttack {  
 
    public static void main(String[] args)  {  
        try {  
            Class<ElvisModified> classType = ElvisModified.class;  
 
            Constructor<ElvisModified> c = classType.getDeclaredConstructor(null);  
            c.setAccessible(true);  
            ElvisModified e1 = (ElvisModified)c.newInstance();  
            ElvisModified e2 = ElvisModified.getInstance();  
            System.out.println(e1==e2);  
        }  
        catch (Exception e)  {  
            e.printStackTrace();  
        }  
    }  
}
