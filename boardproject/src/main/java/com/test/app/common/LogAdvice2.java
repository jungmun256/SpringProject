package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice2 {
	
	// JP : 스프링컨테이너가 new JP() (==jp 객체생성)
	// 현재 수행되는 비즈니스 메서드 정보를 셋팅
	
	public void printLog2(JoinPoint jp) {
		Object[] args = jp.getArgs();
		System.out.println("매개변수에 활용된 데이터"+args[0]);
	}
	
}
