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
		System.out.println(123);
	}
	
	
	/*@Before("execution(* me.fenglu.controller.*.*(..))")
	public void before() {
		System.out.println(new Date());
	}*/
	
	public void moniter() {
		System.out.println(23);
	}
	
}
