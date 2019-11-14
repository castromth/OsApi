package br.com.vizentec.kiwi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vizentec.kiwi.config.security.TokenService;
import br.com.vizentec.kiwi.controller.dto.TokenDto;
import br.com.vizentec.kiwi.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthControler {
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dados = form.converter();
		
		try {
			Authentication auth = authManager.authenticate(dados);
			String token = tokenService.tokenGen(auth);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
