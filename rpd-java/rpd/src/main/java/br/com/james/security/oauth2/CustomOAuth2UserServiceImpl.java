//package br.com.james.security.oauth2;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import br.com.james.models.Usuario;
//import br.com.james.repositories.UsuarioRepository;
//
//@Service
//public class CustomOAuth2UserServiceImpl extends DefaultOAuth2UserService {
//
//	@Autowired
//	UsuarioRepository usuarioRepository;
//
//	@Override
//	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
////		OAuth2User auth2User = super.loadUser(userRequest);
//
//		Optional<Usuario> usuario = usuarioRepository.findByEmail(userRequest.getClientRegistration().getClientName());
//
//		return (OAuth2User) new User(null, null, false, false, false, false, null);
//	}
//
//}
