//package br.com.james.security.oauth2;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
//
//public class CustomOidcUserService  extends OidcUserService{
//
//	 @Override
//	    public OidcUser loadUser(OidcUserRequest userRequest) {
//	        OAuth2User oAuth2User = super.loadUser(userRequest);
////	        Set<OAuth2UserAuthority> authorities = new HashSet()<>(oAuth2User.getAuthorities());
//	        return oAuth2User;
//	    }
//
//}
