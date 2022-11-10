package com.greatlearning.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employee.serviceImpl.DomainUserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final DomainUserDetailsServiceImpl userDetailsService;

	// authentication
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// configure users
		authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	// authorization
	@Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
        // configure authorization rules here
        httpSecurity.cors().disable().csrf().disable();
        httpSecurity
        	.authorizeRequests().antMatchers(HttpMethod.GET,"/api/role/**")
        	.permitAll()
        	.antMatchers("/login**")
        	.permitAll()
        	.antMatchers(HttpMethod.POST,"/api/user**","/api/role/**")
        	.permitAll()
        	.and()
        	.authorizeRequests()
        	.antMatchers(HttpMethod.POST,"/api/employees/**")
        		.hasRole("ADMIN")
        	.antMatchers(HttpMethod.PUT,"/api/employees/**","/api/user/**","/api/role/**")
        		.hasRole("ADMIN")
        	.antMatchers(HttpMethod.DELETE,"/api/employees/**","/api/user/**","/api/role/**")
        		.hasRole("ADMIN")
        	.antMatchers(HttpMethod.GET,"/api/user/**")
        		.hasRole("ADMIN")
        	.anyRequest()
        	.authenticated()
        	.and()
        	.formLogin()
        	.and()
    		.logout().logoutSuccessUrl("/login").permitAll()
        	.and()
        	.httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
