package test.proxy;

import test.proxy.impl.BookStoreImpl;

/**
 * 代理模式
 * @author hefan
 * @date 创建时间：2017年2月22日 上午9:44:02
 *
 */
public class TestProxy {
	public static void main(String[] args) {
		BookStoreProxy proxy = new BookStoreProxy();
		BookStore bookStore = (BookStore) proxy.bind(new BookStoreImpl());
		bookStore.addBook();
	}
}
