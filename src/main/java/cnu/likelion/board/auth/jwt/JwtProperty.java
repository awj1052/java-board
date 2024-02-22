package cnu.likelion.board.auth.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public record JwtProperty(
        String secretKey,
        Long accessTokenExpirationDay
) {
}
