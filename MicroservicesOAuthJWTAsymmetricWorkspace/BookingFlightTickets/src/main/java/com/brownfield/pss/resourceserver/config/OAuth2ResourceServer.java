package com.brownfield.pss.resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
	/*
	 * @Autowired private RedisConnectionFactory connectionFactory;
	 * 
	 * @Bean public TokenStore tokenStore() { RedisTokenStore redis = new
	 * RedisTokenStore(connectionFactory); return redis; }
	 * 
	 * @Override public void configure(ResourceServerSecurityConfigurer endpoints)
	 * throws Exception { endpoints.tokenStore(tokenStore()); }
	 */

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and()
		.requestMatchers().antMatchers("/booking/**").and().
		cors();
	}
}
