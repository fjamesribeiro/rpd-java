package br.com.james.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//			.requestMatchers("/login", "/css/**", "/images/**", "/js/**").permitAll()
//			.requestMatchers("/**").hasRole("ADMIN")
//			.requestMatchers("/rest/pac/**").hasRole("PAC")
//			.requestMatchers("/rest/psc/**").hasRole("PSC")
 				.anyRequest().authenticated());
//				.anyRequest().permitAll());
// 		http.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home"));
		return http.build();
	}
}
