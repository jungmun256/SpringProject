package com.test.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	// pjp = new PJP("현재 실행하는 비즈니스 메서드 정보")
	
	@Around("PointcutCommon.aPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//System.out.println(pjp.getSignature().getName()+"() 비즈니스메서드 실행중");
		System.out.println("[비즈니스 메서드 수행 전]");
		
		
		StopWatch sw = new StopWatch();
		sw.start();
		//비즈니스 메서드를 탈취
		Object obj = pjp.proceed(); 
		sw.stop();
		System.out.println("[비즈니스 메서드 수행 후]");
		
		System.out.println(pjp.getSignature().getName()+"() 비즈니스메서드 실행에 소요되는 시간은");
		System.out.println(sw.getTotalTimeMillis()+"입니다.");
		return obj;
	}
}
