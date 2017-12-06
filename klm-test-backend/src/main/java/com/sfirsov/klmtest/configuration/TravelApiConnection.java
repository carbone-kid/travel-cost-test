package com.sfirsov.klmtest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class TravelApiConnection {
    @Value("${travel.api.client.id}")
    String travelApiClientId;

    @Value("${travel.api.client.secret}")
    String travelApiClientSecret;

    @Value("${travel.api.accessTokenUri}")
    String accessTokenUri;

    @Bean(name = "travelRestTemplate")
    RestTemplate createRestTemplate() {
        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();

        resource.setAccessTokenUri(accessTokenUri);
        resource.setClientId(travelApiClientId);
        resource.setClientSecret(travelApiClientSecret);
        resource.setScope(Arrays.asList("read"));

        AccessTokenRequest atr = new DefaultAccessTokenRequest();

        return new OAuth2RestTemplate(
                resource,
                new DefaultOAuth2ClientContext(atr)
        );
    }
}
