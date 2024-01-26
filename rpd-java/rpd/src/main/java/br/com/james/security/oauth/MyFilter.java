package br.com.james.security.oauth;
/*
 * package br.com.james.security;
 * 
 * import java.io.IOException;
 * 
 * import org.springframework.http.MediaType; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * import br.com.james.dto.ErroDTO; import jakarta.servlet.FilterChain; import
 * jakarta.servlet.ServletException; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * public class MyFilter extends OncePerRequestFilter {
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException {
 * 
 * if (request.getHeader("Authorization") != null) { // r
 * ecupero o cabeçalho
 * Authentication authentication = TokenUtil.decodeToken(request); // cabecalho
 * existe, preciso veruificar se eh valido if (authentication != null) { // se o
 * meu token for válido, passo a requisicao pra frente
 * SecurityContextHolder.getContext().setAuthentication(authentication); } else
 * { // token existe porém é invalido, customizo a resposta ErroDTO erro = new
 * ErroDTO(401, "User not authorized"); response.setStatus(erro.status());
 * response.setContentType(MediaType.APPLICATION_JSON_VALUE); ObjectMapper
 * mapper = new ObjectMapper();
 * response.getWriter().print(mapper.writeValueAsString(erro));
 * response.getWriter().flush(); return; } }
 * 
 * filterChain.doFilter(request, response); }
 * 
 * }
 */
