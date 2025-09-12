package com.playstore.owner_service.config;

import com.playstore.owner_service.service.OwnerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private OwnerDetailsServiceImpl ownerDetailsService;

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(ownerDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

   
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                		"/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                		"/uploads/**",
                		"/notifications/**",
                        "/owner/register",
                        "/owner/login",
                        "/css/**",
                        "/js/**",
                        "/h2-console/**",
                        "api/apps/visible"
                        
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/owner/login")          
                .usernameParameter("email")        
                .passwordParameter("password")
                .defaultSuccessUrl("/owner/dashboard", true)
                .failureUrl("/owner/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/owner/logout")
                .logoutSuccessUrl("/owner/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
            );

        // Allow H2 console in browser
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }
}
