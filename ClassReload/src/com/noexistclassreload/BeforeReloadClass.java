package com.noexistclassreload;

public class BeforeReloadClass implements IReloadClass{

	@Override
	public void test() {
		System.out.println("BeforeReloadClass run");
	}
}
