package com.newlecture.web.config;

import java.io.IOException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages= {"com.newlecture.web.dao.mybatis","com.newlecture.web.dao.java"})
//@Configuration
public class ServiceContextConfig {
	
	//Mapperlocation 리소스 받아올 때 필요한 객체
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@192.168.0.15:1521/xepdb1");
		basicDataSource.setUsername("\"newlec\"");
		basicDataSource.setPassword("l4class");
	
		return basicDataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(basicDataSource());
		sqlSessionFactory.setMapperLocations(
				applicationContext.getResources("classpath:com/newlecture/web/dao/mybatis/mapper/*xml"));

		return sqlSessionFactory;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws IOException, Exception {
		SqlSessionFactory factory = sqlSessionFactory().getObject();
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(factory);
		return sqlSession;
	}
	
}
