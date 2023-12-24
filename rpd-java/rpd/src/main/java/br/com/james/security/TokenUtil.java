package br.com.james.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

	public static Authentication decodeToken(HttpServletRequest request) {
		if (request.getHeader("Authorization").equals("Bearer *rpd")) {
			return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
		}

		return null;
	}

}
