package com.philosopherzb.commonutil.chain.demo;

public class TwoCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
    	if ("2".equals(input)) {
			// TODO do something
			System.out.println(getClass().getName());
			return;
		}
		baseCase.doSomething(input, baseCase);
    }
}
