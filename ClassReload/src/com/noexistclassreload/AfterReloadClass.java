package com.noexistclassreload;

public class AfterReloadClass implements IReloadClass{

	@Override
	public void test() {
		System.out.println("AfterReloadClass running");
	}
}
