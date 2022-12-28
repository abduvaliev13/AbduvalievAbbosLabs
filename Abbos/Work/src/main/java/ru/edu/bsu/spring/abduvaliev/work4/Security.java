package ru.edu.bsu.spring.abduvaliev.work4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@SuppressWarnings({"SpringFacetCodeInspection", "deprecation"})
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security {
    @Bean
    public SecurityFilterChain filterChain(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
        return http.build();
    }
}
