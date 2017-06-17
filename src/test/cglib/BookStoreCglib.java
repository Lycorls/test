package test.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 需要cglib-2.2.jar、asm-all-4.0.jar
 * http://blog.csdn.net/qq_35101189/article/details/56306780
 * 
 * Cglib动态代理 
 * JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，
 * 并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。 
 * @author hefan
 * @date 创建时间：2017年2月22日 上午11:02:19
 *
 */
public class BookStoreCglib implements MethodInterceptor{

	private Object target;
	
	public Object getInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("事务开始");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("事务结束");
		return null;
	}
	
}
