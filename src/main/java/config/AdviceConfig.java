package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

@Aspect
public class AdviceConfig implements Ordered{
	
	/*@Around("config.AspectConfig.businessController()")
	public Object around(ProceedingJoinPoint pjp) {
		Object retValue = null;
		try {
			System.out.println(new Date());
			retValue = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return retValue;
	}*/
	
	@Before("config.AspectConfig.businessController()")
	public void befor() {
		System.out.println("1qweqwe");
	}

	@Override
	public int getOrder() {
		return 1;
	}
	
}
