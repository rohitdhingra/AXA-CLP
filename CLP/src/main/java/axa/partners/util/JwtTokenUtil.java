package axa.partners.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	@Value("${jwt.secretKey}")
	private String secretKey;

	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return doGenerateToken(claims,userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}

	public String getUsernameFromToken(String jwtToken) {
		return getClaimFromToken(jwtToken,Claims::getSubject);
	}

	private <T> T getClaimFromToken(String jwtToken, Function<Claims,T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(jwtToken);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String jwtToken) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
	}

	public boolean validateToken(String jwtToken, UserDetails userDetails) {
		final String userName = getUsernameFromToken(jwtToken);
		return (userName.equals(userDetails.getUsername())&& !isTokenExpired(jwtToken));
		}

	private boolean isTokenExpired(String jwtToken) {
		final Date expiration = getExpirationDateFromToken(jwtToken);
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String jwtToken) {
		// TODO Auto-generated method stub
		final Claims claims = getAllClaimsFromToken(jwtToken);
		
		return getClaimFromToken(jwtToken, Claims::getExpiration);
	}

}
