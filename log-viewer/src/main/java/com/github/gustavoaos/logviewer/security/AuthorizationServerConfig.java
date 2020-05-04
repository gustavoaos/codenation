package com.github.gustavoaos.logviewer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private static final int ACCESS_TOKEN_VALIDITY_IN_SECONDS = 3600;
    private static final int REFRESH_TOKEN_VALIDITY_IN_SECONDS = 3600;

    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Autowired  
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override  
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {  
        clients.inMemory()  
                .withClient(clientId)
                .secret(clientSecret) // .secret(new BCryptPasswordEncoder().encode(clientSecret))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")  
                .scopes("read", "write", "trust")  
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS)  
                .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);  
    }

    @Override  
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {  
        endpoints.authenticationManager(authenticationManager)  
                 .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);  
    }

}