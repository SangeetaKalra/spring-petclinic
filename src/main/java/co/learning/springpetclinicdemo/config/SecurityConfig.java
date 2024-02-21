package co.learning.springpetclinicdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwt-set-uri}")
    String jwkSetUri;

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    protected SecurityFilterChain getFilterChainNew(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer((oauth2Resourceserver) -> oauth2Resourceserver.jwt(
                        (jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()).jwtAuthenticationConverter(jwtAuthConverter))));

        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }


}
