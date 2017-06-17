package test.proxy.impl;

import test.proxy.BookStore;

public class BookStoreImpl implements BookStore{

	@Override
	public void addBook() {
		System.out.println("addBook");
	}
}
