package test.singleton;

/**
 * 通过内部静态类实现单例
 * 
 * 这种方式不能抵御反射创建的类
 * 
 * @author hefan
 * @date 创建时间：2017年1月23日 下午2:15:54
 *
 */
public class Elvis {
	private static boolean flag = false;

	private Elvis() {
	}

	private static class SingletonHolder {
		private static final Elvis INSTANCE = new Elvis();
	}

	public static Elvis getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void doSomethingElse() {

	}
}
