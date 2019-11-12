package br.com.vizentec.kiwi.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.vizentec.kiwi.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${kiwi.jwt.expiration}")
	private String expiration;
	
	@Value("${kiwi.jwt.secret}")
	private String secret;
	
	public String tokenGen(Authentication auth) {
		Usuario user = (Usuario) auth.getPrincipal();
		Date now = new Date();
		Date expDate = new Date(now.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("KiwiOs")
				.setSubject(user.getId().toString())
				.setIssuedAt(now)
				.setExpiration(expDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getUserId(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());

	}

}
