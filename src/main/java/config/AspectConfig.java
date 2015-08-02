package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfig {
	
	@Pointcut("within(me.fenglu.controller..*)")
	public void inWebLayer() {
	}
	
	@Pointcut("execution(* me.fenglu.service.*.*(..))")
    public void businessController() {
	}
	
	public void moniter() {
		System.out.println(23);
	}
	
}
