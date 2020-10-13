package com.pierluigi.advertising_campaign.Configuration;

import com.pierluigi.advertising_campaign.Component.SscStatusAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        SscStatusAuthenticationProvider sscStatusAuthenticationProvider =
                new SscStatusAuthenticationProvider("username","password");
        auth.authenticationProvider(sscStatusAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }
}
