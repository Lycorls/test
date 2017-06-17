package test.singleton;

/**
 * 修改后，若反射创建多个对象，抛出异常
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:40:01
 *
 */
public class ElvisModified  {  
    private static boolean flag = false;  
 
    private ElvisModified(){  
        synchronized(ElvisModified.class)  
        {  
            if(flag == false)  
            {  
                flag = !flag;  
            }  
            else 
            {  
                throw new RuntimeException("单例模式被侵犯！");  
            }  
        }  
    }  
 
    private  static class SingletonHolder{  
        private static final ElvisModified INSTANCE = new ElvisModified();  
    }  
 
    public static ElvisModified getInstance()  
    {  
        return SingletonHolder.INSTANCE;  
    }  
 
    public void doSomethingElse()  
    {  
 
    }  
}
