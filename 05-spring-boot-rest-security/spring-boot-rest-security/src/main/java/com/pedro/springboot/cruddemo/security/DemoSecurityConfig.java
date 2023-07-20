package com.pedro.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails maria = User.builder().username("maria").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails ana = User.builder().username("ana").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails pedro = User.builder().username("pedro").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(maria, ana, pedro);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();

    }

}
