package br.com.davisoares.apilogin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors ->
                        cors.configurationSource(request -> {
                            CorsConfiguration config = new CorsConfiguration();
                            config.setAllowedOrigins(Collections.singletonList("your-allowed-origin"));
                            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                            config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
                            return config;
                        })
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .formLogin(AbstractHttpConfigurer::disable)
                .securityMatcher("/**")
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()
                );


        return http.build();
    }
}
