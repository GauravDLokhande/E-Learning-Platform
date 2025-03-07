package com.elearning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomJWTAuthenticationFilter customJWTAuthenticationFilter;

    public SecurityConfiguration(CustomJWTAuthenticationFilter customJWTAuthenticationFilter) {
        this.customJWTAuthenticationFilter = customJWTAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/courses", "/users/signup", "/users/signin", "/instructors/**","/admin/**" ,"/v*/api-doc*/**", "/swagger-ui/**", "/modules/lessons/**", "/users/**", "/users/otpgenerate").permitAll()
                .requestMatchers(HttpMethod.OPTIONS).permitAll()
                .requestMatchers("/users/signin","/courses/purchase/**", "/instructors/**", "/users/**", "/users/otpgenerate").hasRole("STUDENT")
                .requestMatchers("/courses/add", "/courses/delete", "/admin/**").hasRole("ADMIN")
                .requestMatchers("/instructors/lessons/**").hasRole("INSTRUCTOR")
                .anyRequest().authenticated())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(customJWTAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();  // No password encoding
    }
}