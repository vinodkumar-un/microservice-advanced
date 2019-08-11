package com.brownfield.pss.springsecurity.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Customized configuration to disable both frameset and csrf() in order to
		// access H2 console in web browser
		http.authorizeRequests()
			.anyRequest().authenticated().and()
			.formLogin().and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/?logout").and()
			.httpBasic().and()
			.headers().frameOptions().disable().and
			().csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("user1@example.com").password("user1").roles("USER").and()
			.withUser("user2@example.com").password("user2").roles("USER");
	}
}
