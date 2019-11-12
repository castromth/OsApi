package br.com.vizentec.kiwi.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.vizentec.kiwi.model.Usuario;
import br.com.vizentec.kiwi.repository.UsuarioRepository;

public class AuthTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository userRepository;
	

	public AuthTokenFilter(TokenService tokenService,UsuarioRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		boolean isValid = tokenService.isValid(token);
		if(isValid)
			autenticarUser(token);
	}
	
	
	private void autenticarUser(String token) {
		Long userId = tokenService.getUserId(token);
		Usuario user = userRepository.findById(userId).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}


	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7,token.length());
	}

}
