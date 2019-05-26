package axa.partners.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("admin".equals(username))
		{
			return new User("admin","$2a$10$lZuUiQLpOCGpJ2V64dyaAu8NdGb9qzExSuJ0b92dJyXHeFo.1Er3q",new ArrayList<>());
		}
		else
		{
		throw new UsernameNotFoundException("User not found with username:"+username);
		}
	}

}
