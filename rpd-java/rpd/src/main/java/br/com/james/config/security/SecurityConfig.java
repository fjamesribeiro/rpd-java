package br.com.james.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.httpBasic(Customizer.withDefaults());

		http.csrf().disable();

		http.httpBasic();

		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers("/login", "/css/**", "/images/**", "/js/**").permitAll()

//			.requestMatchers("/**").hasRole("ADMIN")
//			.requestMatchers("/rest/pac/**").hasRole("PAC")
//			.requestMatchers("/rest/psc/**").hasRole("PSC")
				.anyRequest().authenticated());
//				.anyRequest().permitAll());
		http.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/"));

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailServiceImpl();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		return authenticationManagerBuilder.build();

	}

}
