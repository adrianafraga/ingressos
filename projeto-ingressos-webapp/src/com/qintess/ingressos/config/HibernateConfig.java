package com.qintess.ingressos.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  //anotação para lidar com transações do SQL
@EnableTransactionManagement
public class HibernateConfig { //o spring lida com pacotes e não classes para fazer o scan de entidades do hibernate
	
	@Bean //método que será invocado pelo spring de forma automática
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.qintess.ingressos.entidade");
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/db~dbIngressos");
		
		//os dados de user e pass do banco h2
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
		
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionManager = new  HibernateTransactionManager ();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
		
		
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties ();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		//hibernateProperties.setProperty("hibernate.jdbc.time_zone","UTC");		
		return hibernateProperties;
	}

}
