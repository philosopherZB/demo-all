package com.philosopherzb.commonutil.chain.demo;

public class DefaultCase implements BaseCase {
	@Override
	public void doSomething(String input, BaseCase baseCase) {
		// TODO do something
		System.out.println(getClass().getName());
	}
}
