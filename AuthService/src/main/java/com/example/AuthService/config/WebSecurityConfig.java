package com.example.AuthService.config;

import com.example.AuthService.security.TokenUtils;
import com.example.AuthService.security.auth.RestAuthenticationEntryPoint;
import com.example.AuthService.security.auth.TokenAuthenticationFilter;
import com.example.AuthService.service.UserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
// Ukljucivanje podrske za anotacije "@Pre*" i "@Post*" koje ce aktivirati autorizacione provere za svaki pristup metodi
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Bean koji ce raditi hesiranje lozinke
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserServiceDetails jwtUserDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private TokenUtils tokenUtils;

    //Authentication manager - spring bean, kazemo mu da cemo koristiti nas implementirani userServiceDetails
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication()
                .withUser("d").password("$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm").roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                // sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
                //.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
                
                // svim korisnicima dopusti da pristupe putanjama /auth/**
                .authorizeRequests().antMatchers("/auth/**").permitAll()
                                    .antMatchers("/h2-console/**").permitAll()

                // za svaki drugi zahtev korisnik mora biti autentifikovan
                .anyRequest().authenticated().and()

                // umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT tokena umesto cistih korisnickog imena i lozinke (koje radi BasicAuthenticationFilter)
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
                        BasicAuthenticationFilter.class)
                .formLogin().disable()
                .cors();
        
        // zbog jednostavnosti primera

        http.headers().frameOptions().disable();
    }

    // Generalna bezbednost aplikacije
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/**", "/auth/login");
        web.ignoring().antMatchers(HttpMethod.GET, "/webjars/**", "/favicon.ico",
				"/**/*.css", "/**/*.js", "/favicon.ico", "/**/*.html");
    }


}