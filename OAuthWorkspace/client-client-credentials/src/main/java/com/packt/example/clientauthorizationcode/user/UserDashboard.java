package com.packt.example.clientauthorizationcode.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDashboard {
	@Autowired
	private OAuth2RestTemplate restTemplate;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/callback")
	public ModelAndView callback() {
		return new ModelAndView("forward:/dashboard");
	}

	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("user", userDetails);

		tryToGetUserProfile(mv);

		return mv;
	}

	private void tryToGetUserProfile(ModelAndView mv) {
		String endpoint = "http://localhost:8081/api/profile";
		try {
			UserProfile userProfile = restTemplate.getForObject(endpoint, UserProfile.class);
			mv.addObject("profile", userProfile);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("it was not possible to retrieve user profile");
		}
	}
}
