package test.cglib;

import test.proxy.impl.BookStoreImpl;

public class TestCglib {
	public static void main(String[] args) {
		BookStoreCglib cglib = new BookStoreCglib();
		BookStoreImpl bookStoreCglib = (BookStoreImpl) cglib.getInstance(new BookStoreImpl());
		bookStoreCglib.addBook();
	}
}
