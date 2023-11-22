package com.prgrms.devcource.security.configures;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure{

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/assets/**");
    }

    @Bean
    protected SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/me").hasAnyRole("USER", "ADMIN")
                    .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                    .defaultSuccessUrl("/")
                    .permitAll()
                );
        return http.build();
    }
}
