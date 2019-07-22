package com.test.springboot.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspects {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspects.class);
	
	/**
	 * 	哪个类、哪些方法、返回值是什么，需要AOP切入
	 */
	@Pointcut("execution(public * com.test.springboot.controller.UserController.*(..))")
	public void pointCut() {}
	
	/**
	 *	1、前置通知，在目标方法之前运行。
	 */
	@Before("pointCut()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore...");
		
		// 接收到请求，记录请求内容
        ServletRequestAttributes attributes = 
        		(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }
	}
	
	/**
	 *	2、后置通知，目标方法运行之后运行，无论是否异常。
	 */
	@After("pointCut()")
	public void logAfter() {
		System.out.println("logAfter...");
	}
	
	/**
	 *	3、返回通知，目标方法正常返回后运行。
	 */
	@AfterReturning(returning = "resp", pointcut = "pointCut()")
	public void logReturn(Object resp) {
		System.out.println("logReturn...");
		// 处理完请求，返回内容
        logger.info("RESPONSE : " + resp);
	}
	
	/**
	 *	4、异常通知，目标方法出现异常后运行。
	 */
	@AfterThrowing(value="pointCut()", throwing="exception")
	public void logException(Exception exception) {
		System.out.println("logException..."+exception);
	}
	
	/**
	 *	5、环绕通知，动态代理, 手动执行目标方法运行ProceedingJoinPoint.procced(), 最底层通知,手动指定执行目标方法(@Around), 
	 *	执行之前相当于前置通知, 执行之后相当于返回通知，执行顺序比@Before还早，比@After也早
	 *	其实就是通过反射执行目标对象的连接点处的方法；
	 * @throws Throwable 
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around before...");
//		joinPoint.proceed();
//		System.out.println("around after..");
		Object obj = joinPoint.proceed();//相当于执行目标方法
		System.out.println("around after..");
		return obj;
	}
	
}
