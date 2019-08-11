package com.packt.example.clientauthorizationcode.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class ClientConfiguration {
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Bean
    public OAuth2ProtectedResourceDetails authorizationCode() {
        //AuthorizationCodeResourceDetails resourceDetails = new AuthorizationCodeResourceDetails();
    	ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();

        resourceDetails.setId("oauth2server");
        resourceDetails.setTokenName("oauth_token");
        resourceDetails.setClientId("clientapp");
        resourceDetails.setClientSecret("123456");
        resourceDetails.setAccessTokenUri("http://localhost:9090/oauth/token");
       // resourceDetails.setUserAuthorizationUri("http://localhost:9090/oauth/authorize");
        resourceDetails.setScope(Arrays.asList("read_profile"));
        //resourceDetails.setPreEstablishedRedirectUri(("http://localhost:9000/callback"));
       // resourceDetails.setUseCurrentUri(false);
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);

        return resourceDetails;
    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {

        OAuth2ProtectedResourceDetails resourceDetails = authorizationCode();

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails, oauth2ClientContext);

        //AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(new AuthorizationCodeAccessTokenProvider()));
        AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(new ResourceOwnerPasswordAccessTokenProvider()));

        template.setAccessTokenProvider(provider);

        return template;
    }

}
