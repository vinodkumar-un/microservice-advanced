package com.packt.example.authcodeserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	/*
	 * @Autowired private RedisConnectionFactory connectionFactory;
	 * 
	 * @Bean public TokenStore tokenStore() { RedisTokenStore redis = new
	 * RedisTokenStore(connectionFactory); return redis; }
	 */

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("aspire");
		return converter;
	}

	@Bean
	public JwtTokenStore jwtTokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// endpoints.tokenStore(tokenStore());
		endpoints.tokenStore(jwtTokenStore());
		endpoints.accessTokenConverter(accessTokenConverter());
		endpoints.authenticationManager(authenticationManager); // need by password grant
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("clientapp")
						  .secret("123456")
						  .redirectUris("http://localhost:9000/callback")
						  .authorizedGrantTypes("authorization_code", "implicit", 
						"password", "client_credentials","refresh_token")
						  //.authorizedGrantTypes("implicit")
						  .accessTokenValiditySeconds(1200)
						  .scopes("read_profile");
	}

	@Autowired
	private AuthenticationManager authenticationManager; // needed by password grant
}
