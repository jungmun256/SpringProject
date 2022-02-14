package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardVO;
import com.test.app.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	//2. 포인트컷 설정
	
	@AfterReturning(pointcut="PointcutCommon.bPointcut()",returning="obj")
	public void afterLog(JoinPoint jp, Object obj) {  //"바인드 변수"
		String coreMethod = jp.getSignature().getName();
		System.out.println("AR어드바이스"+coreMethod+"()");
		
		if(obj instanceof MemberVO) {
			MemberVO vo = (MemberVO)obj; //다운캐스팅
			System.out.println("MemberVO를 반환" + vo +"입니다.");
		}
		else if(obj instanceof BoardVO) {
			BoardVO vo = (BoardVO)obj; 
			System.out.println("BoardVO를 반환" + vo +"입니다.");
		}
		else {
			System.out.println("일치하는 객체 없음");
		}
	}
}
