package br.com.james.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.james.models.Usuario;
import br.com.james.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	HttpSession session; // autowiring session

	@Autowired
	UsuarioRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + email));

		session.setAttribute("idUsuario", usuario.getId());

		return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true, usuario.getRoles());

	}

}
