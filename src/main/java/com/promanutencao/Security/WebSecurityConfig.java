package com.promanutencao.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/static/**", "/resources/**").permitAll()
				.antMatchers("/veiculos").permitAll()
				.antMatchers("/veiculos/salvar").permitAll()
				//.antMatchers("/fornecedores").hasRole("USER")
			.and()
				.formLogin().loginPage("/login").permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
			.logout().logoutSuccessUrl("/login?logout").permitAll();
		
	}
	
}
