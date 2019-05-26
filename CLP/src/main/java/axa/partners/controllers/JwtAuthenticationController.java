package axa.partners.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import axa.partners.dto.JWTResponseDTO;
import axa.partners.dto.JwtRequestDTO;
import axa.partners.services.JwtUserDetailsService;
import axa.partners.util.JwtTokenUtil;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO jwtRequestDTO) throws Exception
	{
		authenticate(jwtRequestDTO.getUsername(),jwtRequestDTO.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequestDTO.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JWTResponseDTO(token));
	}

	private void authenticate(String username, String password) throws Exception{
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(DisabledException e)
		{
			throw new Exception("USER_DISABLED",e);
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("INVALID CREDENTIALS",e);
		}
	}
	
}
