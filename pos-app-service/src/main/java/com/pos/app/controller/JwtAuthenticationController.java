package com.pos.app.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pos.app.service.JwtUserDetailsService;
import com.pos.app.vo.StatusResponse;
import com.pos.app.config.JwtTokenUtil;
import com.pos.app.constants.AppConstants;
import com.pos.app.dto.MessageResponse;
import com.pos.app.model.JwtRequest;
import com.pos.app.model.JwtResponse;
import com.pos.app.model.User;
import com.pos.app.model.UserDTO;
import com.pos.app.repository.UserRepository;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	Logger log = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping( "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		log.info("inside createAutheticationToken() method -------- JwtAuthenticationController");
		User user = new User();
		try {
			user = userRepo.findByEmail(authenticationRequest.getUsername());
		}catch (Exception e) {
			log.error("ERROR :"+ e.getMessage());
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		authenticate(user.getUsername(), authenticationRequest.getPassword());
		
		log.info("user authenticated.. ");
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(user.getUsername());
	

		final String token = jwtTokenUtil.generateToken(userDetails);
		log.info("Token Generated :"+token);
		
		StatusResponse response = new StatusResponse();
		response.setStatus(AppConstants.STATUS_SUCCESS);
		response.setMessage("Login Success");
		response.setData(new JwtResponse(token,user.getRole()));
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping( "/register")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			log.info("inside authenticate() method before authenticate");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			log.error("ERROR :"+ e.getMessage());
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			log.error("ERROR :"+ e.getMessage());
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
/*	
	public ResponseEntity<?> logOut(){
		ResponseCookie cookie = jwtTokenUtil.getCleanJwtCookies();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(new MessageResponse("You've been signed out"));
	}
	*/
}