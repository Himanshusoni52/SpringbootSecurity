package config;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	 

	@Bean
	    public  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
			
		httpSecurity
		.csrf()
		.disable()
		.authorizeHttpRequests().requestMatchers("/user/").permitAll()
		.anyRequest()
		.authenticated().and().httpBasic();
	
		return httpSecurity.build() ;
	 }	
		
		 		 
	 

	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.inMemoryAuthentication().withUser("Himmu").password(this.passWordEncoder().encode("1234")).roles("NORMAL");
	     auth.inMemoryAuthentication().withUser("Bholu").password(this.passWordEncoder().encode("234")).roles("ADMIN");
		 
	 }
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder(10);
//	}




	@Bean
	
	public PasswordEncoder passWordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
	 
	 
}
