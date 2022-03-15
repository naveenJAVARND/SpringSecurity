package com.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    
	   private String clientid = "naveen";
	   private String clientSecret = "$2a$10$nMzA/NZ139F/0kU/pCxKh.XmKOMJ5NydX3If5R5YokusduJ/oqAXy";
	
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("MIIEpgIBAAKCAQEAzO2GGd8w82WUizMdwroI7m1tJWDzZfgOdgVB9XRfuzCAA0Xo\r\n"
        		+ "T1M12bfHMRB0KW5A9jskmFdO4c4a2qWCtDq7ud0hby6M6HEzbUINY1K4BtyIqlze\r\n"
        		+ "vehmL8EST9YAN42WamFZvdCw0uIFKXE5ueU10xqsUjpvJrY1gE/NViyGOE1MAcn5\r\n"
        		+ "FHHJa/EKzmJ9nVIYgX9lXUoHyc6QSMTw4JR/+sJxnEVYa7F6fWLuFpvXEiK+F6J8\r\n"
        		+ "mWA0DiW2TWqcOpgXkLRt0oCsyH5C7+qDy6hKogMve/9PD4uQJwUfqa+t+lSleVFw\r\n"
        		+ "O3AYQCuehwKtRlQiD/nGdJIYzEt5bzJBIbgM9wIDAQABAoIBAQCsVT8FuM0Ikq8l\r\n"
        		+ "lHn9jMcAAuPboDlv0fgPRgKe8RukZnfwyLRBKT/K9KK9XxHg2YglybzPo/SBLfsl\r\n"
        		+ "TjSpbg76kbyRLDtxKelOg1KQ6To7AvCnG+xxFeQBWsMUgmmyTg5lLbLzTnG1Fj+z\r\n"
        		+ "BzW9X8Uw32h0yhE5I9fALNwIEO9anhvYlJOf29KABKhFY9VzUrmPMb2t4aqLevvU\r\n"
        		+ "XKTqDgLyQDhRr8krRj+f1U0I1crkF2CLai1t1oeFKxRRpjSBeIUlkOX9Hxx4OHC0\r\n"
        		+ "rQ9+MQEfVl7k2CKGhQRmgbjzxjCmnQfbQwpsyjFoO+nOOZnnj+pG7Iqgr+0kXWeL\r\n"
        		+ "tMVkYLJBAoGBAPer+Cup43685iz+qC6wJ6kykFSHpBO2E5TssuGsYG0iQBeJuLUH\r\n"
        		+ "kkpC4ECnL9pAv/XgD5C5EuDRTuyrZzxQtILgPnPJAx6V3gckIsGvPUNpqIrwacjl\r\n"
        		+ "8wSHW9Gb5OLKqBa0SH5thJ6Wnap/i6bbD0PWv13QWWMP1P6qaxfzgGBhAoGBANPR\r\n"
        		+ "mixD4SSZogXT8eezJ0zKrOE02vI/Cub/volMmDvZwNaiHdnZTKK0SfB8Nwf6+wmk\r\n"
        		+ "lYhY/3uHoUskNJxoMO0wrAcsTLS0Cm2OsLkPtjEyB6nSK12P53gQ10ULfzLu6jfJ\r\n"
        		+ "N0Z3CD2mzGx20VP1EFfW+ShoynFoJ0q/hLMgisxXAoGBAKc/mfbiYp3TMhxwW2Ir\r\n"
        		+ "0pyPaKescUBeVBrdPG7o2LTZzC4Y8oJM+pzrTERcohPgZcDD7b7tO7JVpdZsaOpy\r\n"
        		+ "FXPLumC1/UVKLwTjghUJIXXEg+xPLSBdKB6GyZpii84azCeI1uuJSWVOkGnyd3vV\r\n"
        		+ "shk9izzu1W3v4wWWT3t9E9QBAoGBAKOc3ZeffwLEYPBbfBlautqIGu2B5DUGGSfB\r\n"
        		+ "F636KgTg+CFR6/jf7mAnHo3RhLh3Vv1l0dMV25HRe/cMqk699DziQZ7wyvcxsnRZ\r\n"
        		+ "qYvo5PQvDthP7QtCIqsNZxp//OqcvPIGTNnzC7yDYJfPV3Wgb9VJyf86olTi/Kay\r\n"
        		+ "NJAgbNXVAoGBALoQ1ZyUmNLcqPgn/fPGP5xAuPeMzL65z5S6Io9iN8Msior4oqji\r\n"
        		+ "7hDVW23+y/Go3jubMqcusTxgY/bRw1K//9B5uYD/ppMTPXvCwl5/tC0rWFhcE7PF\r\n"
        		+ "L3zTJCERY/JqjeuAt1gJmoN1Bn3UgfEzI7l/Kj8jQmazGKcep3LhDBuB");
        
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) 
      throws Exception {
        endpoints.tokenStore(tokenStore())
                 .accessTokenConverter(accessTokenConverter())
                 .authenticationManager(authenticationManager);
    }
  
   
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
       security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
            .withClient(clientid).secret(clientSecret)
            .authorizedGrantTypes("password", "authorization_code", "refresh_token")
            .authorities("READ_ONLY_CLIENT")
            .scopes("read_profile_info")
            .resourceIds("oauth2-resource")
            .redirectUris("http://localhost:9090/login")
            .accessTokenValiditySeconds(120)
            .refreshTokenValiditySeconds(240000);
    }
}
