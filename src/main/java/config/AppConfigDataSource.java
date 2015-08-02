package config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:/config/c3p0.properties")
@PropertySource("classpath:/config/hibernate.properties")
public class AppConfigDataSource {
	
	@Autowired
	Environment env;
	
	@Bean
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("c3p0.driverClass"));
			dataSource.setUser(env.getProperty("c3p0.user"));
			dataSource.setPassword(env.getProperty("c3p0.password"));
			dataSource.setJdbcUrl(env.getProperty("c3p0.jdbcUrl"));
			dataSource.setMaxStatements(Integer.parseInt(env.getProperty("c3p0.maxStatements")));
			dataSource.setAcquireIncrement(Integer.parseInt(env.getProperty("c3p0.acquireIncrement")));
			dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("c3p0.initialPoolSize")));
			dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("c3p0.maxPoolSize")));
			dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("c3p0.minPoolSize")));
			dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("c3p0.maxIdleTime")));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sessionFactory().getObject());
		return template;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		//sessionFactory.setAnnotatedPackages(new String[] {"me.fenglu.model"});
		sessionFactory.setPackagesToScan(new String[]{"me.fenglu.model"});
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
		//hibernateProperties.setProperty("hibernate.connection.provider_class",env.getProperty("hibernate.connection.provider_class"));
		hibernateProperties.setProperty("hibernate.cache.provider_class",env.getProperty("hibernate.cache.provider_class"));
		//hibernateProperties.setProperty("hibernate.cache.use_query_cache",env.getProperty("hibernate.cache.use_query_cache"));
		//hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",env.getProperty("hibernate.cache.use_second_level_cache"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		//hibernateProperties.setProperty("hibernate.cache.region.factory_class",env.getProperty("hibernate.cache.region.factory_class"));
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	
	
}
