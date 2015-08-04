package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
@EnableScheduling
@EnableTransactionManagement
@Configuration
@Import({AppConfigDataSource.class})
@ComponentScan(basePackages={"me.fenglu.service","me.fenglu.repository"})
//@ImportResource({"classpath:config/applicationContext.xml"})
public class AppConfigMain {
	
	@Bean(name="aspectConfig")
	public AspectConfig aspectConfig() {
		return new AspectConfig();
	}
	
	@Bean
	public AdviceConfig adviceConfig() {
		return new AdviceConfig();
	}
}
