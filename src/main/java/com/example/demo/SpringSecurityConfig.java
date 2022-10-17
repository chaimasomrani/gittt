package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
    private UsersService usersService;
	 @Autowired
    private UsersRepository usersRepository;


   
   

   

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/h2-console/**","/refreshToken/**","/block/**","/checkEmail/**","/active**","/resetPassword/**").permitAll();
    	//http.headers().frameOptions().disable();
     
                
               // .anyRequest().authenticated();
    }
}