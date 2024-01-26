package br.com.james.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {

	private OAuth2User auth2User;

	public CustomOAuth2User(OAuth2User auth2User) {
		super();
		this.auth2User = auth2User;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return auth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auth2User.getAuthorities();
	}

	@Override
	public String getName() {
		return auth2User.getAttribute("name");
	}

}
