package com.philosopherzb.commonutil.chain.demo;

public class BetterDemo {

	public static void main(String[] args) {
		String input = "2";
		CaseChain caseChain = new CaseChain();
		caseChain.addBaseCase(new OneCase()).addBaseCase(new TwoCase()).addBaseCase(new DefaultCase());
		caseChain.doSomething(input, caseChain);
	}

}
