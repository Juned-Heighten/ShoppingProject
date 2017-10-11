package com.h.config;

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

import com.h.dto.Address;
import com.h.dto.Cart;
import com.h.dto.Category;
import com.h.dto.Product;
import com.h.dto.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com")
    
public class HibernateConfig {
	
	private static final String DB_DRIVER="org.h2.Driver";
	private static final String DB_URL="jdbc:h2:tcp://localhost/~/osdb";
	private static final String DB_USER="sa";
	private static final String DB_PWD="";
	private static final String DB_DIALECT="org.hibernate.dialect.H2Dialect";
	
	@Bean
	public DataSource getDS()
	{   
	   BasicDataSource ds=new BasicDataSource();
	   ds.setDriverClassName(DB_DRIVER);
	   ds.setUsername(DB_USER);
	   ds.setUrl(DB_URL);
	   ds.setPassword(DB_PWD);
		return ds;
	}
	
	@Bean
	public SessionFactory getSF(DataSource ds) throws Exception
	{
		LocalSessionFactoryBuilder fb=new LocalSessionFactoryBuilder(ds);
		fb.addProperties(getHibernateProperties());
		fb.addAnnotatedClasses(Category.class);
		fb.addAnnotatedClasses(Product.class);
		fb.addAnnotatedClass(User.class);
		fb.addAnnotatedClass(Address.class);
		fb.addAnnotatedClass(Cart.class);
		//fb.scanPackages("com");
		return fb.buildSessionFactory();
	}
	
	
	public Properties getHibernateProperties()
	{
		Properties p=new Properties();
		p.put("hibernate.dialect", DB_DIALECT);
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql","true");
		p.put("hibernate.hbm2ddl.auto","update");
		return p;
	}
	
	@Bean
	public HibernateTransactionManager getTm(SessionFactory sf)
	{
		HibernateTransactionManager tm=new HibernateTransactionManager(sf);
		return tm;
	}

}
