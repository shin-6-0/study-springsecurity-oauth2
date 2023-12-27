package io.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint()); 
        //httpBasic > 인증방식. 인증 못받았을 경우 authenticationEntryPoint로 이동
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //세션 인증 방식을 사용하지 않겠다
        return http.build();
    }
}
