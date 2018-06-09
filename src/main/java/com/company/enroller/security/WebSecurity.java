package com.company.enroller.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity //konfigurowanie klasy odpowiedzialanej za firewall aplikacji
public class WebSecurity extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable() //niemozliwe takie ataki w tej aplikacji wiec to wlaczamy
               .authorizeRequests()
               .anyRequest().permitAll() //puszczamy wszytko na razie, domyslnie wszytkie zablokowane
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   }
}