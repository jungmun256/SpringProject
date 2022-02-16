/*
 *  @을 이용한 에러페이지 실습
 * */
package com.test.app.common;

//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.test.app")
public class CommonExceptionHandler {
	
	// 예외 종류마다 하나씩 기재
	// NullPointerException 예외 발생 시
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView excep1(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("error/error.jsp");
		return mav;
	}
	
	// IllegalArgumentException 예외 발생 시 
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView excep2(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("error/errorId.jsp");
		return mav;
	}
	
	
}
