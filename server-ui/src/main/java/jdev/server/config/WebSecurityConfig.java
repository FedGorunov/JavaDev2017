package jdev.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by pinta on 21.07.2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/css","/img").permitAll()
                .antMatchers("/home","/hello").authenticated()
                .antMatchers("/routes/**", "/payments/**").access("hasRole('CLIENT')")
                .antMatchers("/registerClient/**").access("hasRole('MANAGER')")
                .anyRequest().hasRole("ROOT")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("User").password("pass").roles("CLIENT")
                .and()
                .withUser("Manager").password("secret").roles( "MANAGER")
                .and()
                .withUser("Admin").password("super").roles("ROOT");
    }
}







