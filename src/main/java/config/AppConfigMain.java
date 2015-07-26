package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
@EnableScheduling
@Configuration
@Import(AppConfigDataSource.class)
public class AppConfigMain {
	
}
