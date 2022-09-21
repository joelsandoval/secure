package com.scan.secure.services;

import com.scan.secure.model.User;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@PropertySource("classpath:jwt.properties")
public class TokenService {

	@Value("${app.name}")
	private String APP_NAME;
	
	@Value("${jwt.secret}")
	private String SECRET;
	
	@Value("${jwt.expires_in}")
	private int EXPIRE_IN;
	
	@Value("${jwt.header}")
	private String HEADER;
	
	
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			username = claims.getSubject();
		}catch(Exception e) {
			username = null;
		}
		return username;
	}
	
	public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

	public String getRoleFromToken(String token) {
        String role;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            role = (String) claims.get("role");
        } catch (Exception e) {
            role = null;
        }
        return role;
    }
	
    public String refreshToken(String token) {
        String refreshedToken;
        Date a = new Date();
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            claims.setIssuedAt(a);
            refreshedToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith( SIGNATURE_ALGORITHM, SECRET )
                .compact();
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }


    public String generateToken(String username, String password, Collection<? extends GrantedAuthority> collection, String rolePath, Long userId) {
           	
    	Claims claim = Jwts.claims();
    	claim.put("exp", generateExpirationDate());
    	claim.put("iat", new Date());
    	claim.put("sub", username);
    	claim.put("key", password);
    	claim.put("iss", APP_NAME);
    	claim.put("rolePath", rolePath);
        claim.put("userId", userId);
    
    	
    	if(collection != null && !collection.isEmpty()) {
    		for(GrantedAuthority rol: collection) {
    			claim.put("role", rol.getAuthority());
    		}
    	}
    	
        return Jwts.builder().setClaims(claim).signWith(SIGNATURE_ALGORITHM, SECRET).compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        long expiresIn = EXPIRE_IN;
        return new Date(new Date().getTime() + expiresIn * 1000);
    }

    public int getExpiredIn() {
        return EXPIRE_IN;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsernameFromToken(token);
        
        final Date created = getIssuedAtDateFromToken(token);
        return (
                username != null &&
                username.equals(userDetails.getUsername()) &&
                        !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())
        );
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String getToken( HttpServletRequest request ) {
        String authHeader = getAuthHeaderFromHeader( request );
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public String getAuthHeaderFromHeader( HttpServletRequest request ) {
        return request.getHeader(HEADER);
    }

	public String getRolePath(String authToken) {
		String role;
        try {
            final Claims claims = this.getAllClaimsFromToken(authToken);
            role = (String) claims.get("rolePath");
        } catch (Exception e) {
            role = null;
        }
        return role;
	}

	public String getFolioForToken(String authToken) {
		String token;
        try {
            final Claims claims = this.getAllClaimsFromToken(authToken);
            token = (String) claims.get("folio");
        } catch (Exception e) {
        	token = null;
        }
        return token;
	}
}
