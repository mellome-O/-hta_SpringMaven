package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN") // �����Ͱ����� ROLE������ ���⼭�� ROLE ���� �־��ֱ�
				.antMatchers("/student/**").hasAnyRole("ADMIN", "STUDENT").and().formLogin().loginPage("/member/login")
				// .loginProcessingUrl("/member/login") //�� url �������� post �ȴ� form�� action���
				.defaultSuccessUrl("/index").and().logout().logoutUrl("/member/logout").logoutSuccessUrl("/index").and()

		// .csrf()
		// .disable()
		;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT ID, PWD PASSWORD, 1 ENABLED FROM MEMBER WHERE ID=?")
				.authoritiesByUsernameQuery("SELECT ID, 'ROLE_ADMIN' AUTHORITY FROM MEMBER WHERE ID=?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}
}
