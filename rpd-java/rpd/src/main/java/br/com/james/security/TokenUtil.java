package br.com.james.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.james.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

	private static final String EMISSOR = "rpd_online";
	private static final String TOKEN_HEADER = "Bearer ";
	private static final String TOKEN_KEY = "01234567890123456789012345678901";
	private static final long UM_SEGUNDO = 1000;
	private static final long UM_MINUTO = 10 * UM_SEGUNDO;

	public static AuthToken encondeToken(Usuario usuario) {
		Key secrKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());

		String jwtToken = Jwts.builder().setSubject(usuario.getLogin()).setIssuer(EMISSOR)
				.setExpiration(new Date(System.currentTimeMillis() + UM_MINUTO))
				.signWith(secrKey, SignatureAlgorithm.HS256).compact();

		AuthToken authToken = new AuthToken(TOKEN_HEADER + jwtToken);

		return authToken;
	}

	public static Authentication decodeToken(HttpServletRequest request) {

		String jwtToken = request.getHeader("Authorization");

		jwtToken = jwtToken.replace(TOKEN_HEADER, "");

		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(TOKEN_KEY.getBytes()).build().parseClaimsJws(jwtToken);

		String usuario = claims.getBody().getSubject();
		String emissor = claims.getBody().getIssuer();
		Date validade = claims.getBody().getExpiration();

		if (usuario.length() > 0 && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
			return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
		}

		return null;
	}

}
