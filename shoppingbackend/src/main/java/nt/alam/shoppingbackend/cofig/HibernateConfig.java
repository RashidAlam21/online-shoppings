package nt.alam.shoppingbackend.cofig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"nt.alam.shoppingbackend.bo"})
@EnableTransactionManagement
public class HibernateConfig {
	/*
	 * Changing the below based on the DBMS you choose.
	 */
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshoppings";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="RAlam";
	private final static String DATABASE_PASSWORD="";
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		//providing database connection information..
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	/**
	 * SessionFactory Bean will be available
	 * @param dataSource
	 * @return
	 */
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("nt.alam.shoppingbackend.bo");
		return builder.buildSessionFactory();
	}
	/**
	 * All the hibernate properties will be return this method.
	 * @return
	 */
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show.sql","true");
		properties.put("hibernate.format.sql","true");
		return properties;
	}
	/**
	 * this is the transaction manager bean..
	 * @param sessionFactory
	 * @return
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
