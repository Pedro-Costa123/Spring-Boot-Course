package com.pedro.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails maria = User.builder().username("maria").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails ana = User.builder().username("ana").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails pedro = User.builder().username("pedro").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(maria, ana, pedro);

    }

}
