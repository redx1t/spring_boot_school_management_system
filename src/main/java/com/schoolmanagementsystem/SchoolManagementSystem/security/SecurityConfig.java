package com.schoolmanagementsystem.SchoolManagementSystem.security;

import com.schoolmanagementsystem.SchoolManagementSystem.filter.CustomAuthenicationFilter;
import com.schoolmanagementsystem.SchoolManagementSystem.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenicationFilter customAuthenicationFilter = new CustomAuthenicationFilter(authenticationManagerBean());
        customAuthenicationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //allow unauth users to access login page
        http.authorizeRequests().antMatchers("/api/login/**", "/api/v1/users/refresh/**").permitAll();
        // authenication based on roles
        http.authorizeRequests().antMatchers("/api/v1/users/user/**").hasAnyAuthority("ROLE_PARENT","ROLE_BURSAR", "ROLE_TEACHER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/api/v1/bursar/**").hasAnyAuthority("ROLE_BURSAR", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/api/v1/parents/**").hasAnyAuthority("ROLE_PARENT", "ROLE_ADMIN", "ROLE_TEACHER");
        http.authorizeRequests().antMatchers("/api/v1/teachers/**").hasAnyAuthority("ROLE_TEACHER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/api/v1/admin/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenicationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.cors().configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:80", "http://example.com"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        });
        //super.configure(http);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
