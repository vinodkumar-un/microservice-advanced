package com.packt.example.authcodeserver.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/api/profile")
	public ResponseEntity<UserProfile> profile() {
		System.out.println("####"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());	
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String email = user.getUsername() + "@mailinator.com";
		String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user + "@mailinator.com";

		UserProfile profile = new UserProfile();
		//profile.setName(user.getUsername());
		profile.setName(user);
		profile.setEmail(email);
		return ResponseEntity.ok(profile);
	}
	//@RequestMapping("/api/hello")
	@RequestMapping("/aspire/hello")
	public ResponseEntity<String> hello() {
		System.out.println("###hello() method in UserController class");
		return ResponseEntity.ok("Hello World!");
	}
}
