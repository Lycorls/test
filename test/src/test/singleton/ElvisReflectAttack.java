package test.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过JAVA的反射机制来“攻击”单例模式
 * 
 * 可以看到，通过反射获取构造函数，然后调用setAccessible(true)就可以调用私有的构造函数，所有e1和e2是两个不同的对象。
 * 
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:20:59
 *
 */
public class ElvisReflectAttack {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> classType = Elvis.class;

		Constructor<?> c = classType.getDeclaredConstructor(null);
		c.setAccessible(true);
		Elvis e1 = (Elvis) c.newInstance();
		Elvis e2 = Elvis.getInstance();
		System.out.println(e1 == e2);
	}

}
