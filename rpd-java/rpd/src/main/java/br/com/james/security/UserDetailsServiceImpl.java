package br.com.james.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.james.models.Usuario;
import br.com.james.repositories.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = repository.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return new MyUserDetails(usuario);
	}

}
