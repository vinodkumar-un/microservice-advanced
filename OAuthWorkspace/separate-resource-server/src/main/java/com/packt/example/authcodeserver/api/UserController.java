package com.packt.example.authcodeserver.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@CrossOrigin
	@RequestMapping("/api/profile")
	public ResponseEntity<UserProfile> profile() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user.getUsername() + "@mailinator.com";

		UserProfile profile = new UserProfile();
		profile.setName(user.getUsername());
		profile.setEmail(email);
		return ResponseEntity.ok(profile);
	}

	/*
	 * @RequestMapping("/api/profile") public ResponseEntity<UserProfile> profile()
	 * { //need in case of client credentials grant type String user = (String)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
	 * email = user + "@mailinator.com";
	 * 
	 * UserProfile profile = new UserProfile(); profile.setName(user);
	 * profile.setEmail(email); return ResponseEntity.ok(profile); }
	 */
}
