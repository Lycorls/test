package test.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试枚举单例
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:30:28
 *
 */
public class TestMain {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<SingletonClass> classType = SingletonClass.class;
		Constructor<SingletonClass> c = (Constructor<SingletonClass>) classType
				.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
	}
}
