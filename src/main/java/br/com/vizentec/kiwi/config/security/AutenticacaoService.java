package br.com.vizentec.kiwi.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vizentec.kiwi.model.Usuario;
import br.com.vizentec.kiwi.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepo.findByEmail(username);
		if(user.isPresent()) 
			return user.get();
		
		 throw new UsernameNotFoundException("Dados invalidos") ;
	}

}
