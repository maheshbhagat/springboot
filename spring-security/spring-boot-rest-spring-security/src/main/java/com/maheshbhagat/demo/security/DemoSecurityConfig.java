package com.maheshbhagat.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pwd, active from members where user_id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(congigurer ->
                congigurer
                        .requestMatchers(HttpMethod.GET, "/magic-api/students").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET, "/magic-api/students/**").hasRole("STUDENT")

                        .requestMatchers(HttpMethod.POST, "/magic-api/students").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/students/**").hasRole("TEACHER")

                        .requestMatchers(HttpMethod.GET, "/magic-api/teachers").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET, "/magic-api/teachers/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST, "/magic-api/teachers").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/teachers/**").hasRole("TEACHER")

                        .requestMatchers(HttpMethod.DELETE, "/magic-api/students/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/teachers/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails nilam = User.builder()
                .username("nilam")
                .password("{noop}test123")
                .roles("STUDENT")
                .build();

        UserDetails mahesh = User.builder()
                .username("mahesh")
                .password("{noop}test123")
                .roles("STUDENT", "TEACHER")
                .build();

        UserDetails admin = User.builder()
                .username("boss")
                .password("{noop}test123")
                .roles("STUDENT", "TEACHER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(nilam, mahesh, admin);
    }
    */
}
