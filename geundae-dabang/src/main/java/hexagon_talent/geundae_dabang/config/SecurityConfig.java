package hexagon_talent.geundae_dabang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**","/v3/api-docs/**","/actuator/**","/health/**").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(login -> login.disable())
                .httpBasic(basic -> basic.disable());
        return http.build();
    }
}
