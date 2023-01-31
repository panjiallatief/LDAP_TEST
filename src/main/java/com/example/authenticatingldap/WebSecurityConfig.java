package com.example.authenticatingldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
public class WebSecurityConfig {

	@Bean
	ActiveDirectoryLdapAuthenticationProvider authenticationProvider() {
		return new ActiveDirectoryLdapAuthenticationProvider("beritasatu.id", "ldap://172.20.6.7");
		// return new ActiveDirectoryLdapAuthenticationProvider("berita1.tv", "ldap://192.168.10.10");
	}
	
	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	// 	http
	// 		.authorizeRequests()
	// 			.anyRequest().fullyAuthenticated()
	// 			.and()
	// 		.formLogin();

	// 	return http.build();
	// }

	// @Autowired
	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
	// 	auth
	// 		.ldapAuthentication()
	// 			.userDnPatterns("uid={0},ou=people")
	// 			.groupSearchBase("ou=Data")
	// 			.contextSource()
					
	// 				.and()
	// 			.passwordCompare()
	// 				.passwordEncoder(new BCryptPasswordEncoder())
	// 				.passwordAttribute("userPassword");
	// }

	// @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // http
    // .authorizeRequests()
    // .anyRequest().fullyAuthenticated()
    // .and()
    // .formLogin();
    // }

    // @Bean
    // public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
    
    // ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = 
    //     new ActiveDirectoryLdapAuthenticationProvider("berita1.tv", "ldap://192.168.10.10");
    
    // // to parse AD failed credentails error message due to account - expiry,lock, credentialis - expiry,lock
    // activeDirectoryLdapAuthenticationProvider.setConvertSubErrorCodesToExceptions(true); 
    
    // return activeDirectoryLdapAuthenticationProvider;
    // }
    
    
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth
    // .authenticationProvider(activeDirectoryLdapAuthenticationProvider());
    // }

}

//@Configuration
//public class WebSecurityConfig {

//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		return http
//			.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin(Customizer.withDefaults())
//			.build();
//	}
//}
