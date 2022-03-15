package com.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.SpringSecurity.Service.User_DetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
    private User_DetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new SimpleUrlAuthenticationSuccessHandler();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(encodePwd());
		
		return authProvider;
	}
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/**")
    	.authorizeRequests()
    	.antMatchers("/oauth/authorize**", "/login**", "/error**")
    	.permitAll()
	.and()
    	.authorizeRequests()
    	.anyRequest().authenticated()
	.and()
		.formLogin().permitAll();
	}
	
	
		
	 @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(encodePwd());

		}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
		
		
	@Bean
	public BCryptPasswordEncoder encodePwd()
	{
		return new BCryptPasswordEncoder(10);
	}
}
