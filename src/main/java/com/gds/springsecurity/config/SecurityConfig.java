package com.gds.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * 重写configure方法， 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/fonts/**").permitAll() // 都可以访问
		.antMatchers("/users/**").hasRole("admin")	// 需要角色才可以访问
		.and()
		.formLogin()	// form表单登录
		.loginPage("/login").failureUrl("/login-error");	// 自定义登录界面
	
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	// 认证信息存在内存中, 为了省事儿
		.withUser("admin").password("123").roles("admin");
	}
	
}



