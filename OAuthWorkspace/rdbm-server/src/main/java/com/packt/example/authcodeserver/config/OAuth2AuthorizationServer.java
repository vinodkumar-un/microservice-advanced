package com.packt.example.authcodeserver.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	/*
	 * @Override public void configure(ClientDetailsServiceConfigurer clients)
	 * throws Exception {
	 * clients.inMemory().withClient("clientapp").secret("123456").redirectUris(
	 * "http://localhost:9000/callback")
	 * .authorizedGrantTypes("authorization_code").scopes("read_profile"); }
	 */

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	public ApprovalStore approvalStore() {
		return new JdbcApprovalStore(dataSource);
	}

	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.approvalStore(approvalStore()).tokenStore(tokenStore());
	}
}
