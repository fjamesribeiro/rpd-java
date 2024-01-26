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
public class SecConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(Customizer.withDefaults())
				.authorizeHttpRequests(request -> request.requestMatchers("/login", "/css/**", "/js/**", "/images/**")
						.permitAll().anyRequest().authenticated())
//				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true))
				.oauth2Login(oauth2 -> oauth2.loginPage("/login").defaultSuccessUrl("/", true)).build();
	}
}
