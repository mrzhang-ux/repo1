package com.yidongxueyuan.proxy;

public class SpringBrother implements Human {

	@Override
	public void sing(float money) {
		System.out.println(money+"...sing");

	}

	@Override
	public void dance(float money) {
		System.out.println(money+"...dance");

	}

}
