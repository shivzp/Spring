package com.spring.aop.SpringBootAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// first * any class second any method (..) irrespective of no of args
	@Before("com.spring.aop.SpringBootAOP.aspect.CommonConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		logger.info("before asopect {}", joinPoint);
	}

	@AfterReturning(value = "execution(* com.spring.aop.SpringBootAOP.business.*.*(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		logger.info("after aspect {}, {}", joinPoint, result);
	}

	@AfterThrowing(value = "execution(* com.spring.aop.SpringBootAOP.business.*.*(..))", throwing = "result")
	public void after(JoinPoint joinPoint, Exception result) {
		logger.info("after aspect {}, {}", joinPoint, result);
	}
	
	@After(value = "execution(* com.spring.aop.SpringBootAOP.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after aspect {}, {}", joinPoint);
	}
	
	// used for calculating method execution time
	@Around("execution(* com.spring.aop.SpringBootAOP.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Arounf {} {} " , joinPoint, timeTaken);
	}
}
