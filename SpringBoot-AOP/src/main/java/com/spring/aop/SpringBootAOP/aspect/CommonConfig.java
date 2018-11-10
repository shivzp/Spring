package com.spring.aop.SpringBootAOP.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonConfig {

	@Pointcut("execution(* com.spring.aop.SpringBootAOP.business.*.*(..))")
	public void dataLayerExecution() {};
}
