package com.example.authenticatingldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.stream.Collectors;


@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Welcome to the home page!";
	}

	@GetMapping("/user")
    public Authentication getLoggedUserDeatil() {
     
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     //get username
     String username = auth.getName();
   // concat list of authorities to single string seperated by comma
     String authorityString = auth
        .getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));
   // check if the user have authority -roleA
     String role = "role_A";
     boolean isCurrentUserInRole = auth
         .getAuthorities()
         .stream()
         .anyMatch(role::equals);
   //return Authentication object  
   return auth;
   }

}
