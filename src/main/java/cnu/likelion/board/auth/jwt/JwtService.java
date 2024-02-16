package cnu.likelion.board.auth.jwt;

import static java.util.concurrent.TimeUnit.DAYS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import cnu.likelion.board.common.exception.UnAuthorizedException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final ObjectMapper objectMapper;
    private final long accessTokenExpirationDayToMills;
    private final Algorithm algorithm;

    public JwtService(JwtProperty jwtProperty) {
        this.objectMapper = new ObjectMapper();
        this.accessTokenExpirationDayToMills =
                MILLISECONDS.convert(jwtProperty.accessTokenExpirationDay(), DAYS);
        this.algorithm = Algorithm.HMAC512(jwtProperty.secretKey());
    }

    public String createToken(Long memberId) {
        return JWT.create()
                .withExpiresAt(new Date(
                        accessTokenExpirationDayToMills + System.currentTimeMillis()
                ))
                .withIssuedAt(new Date())
                .withClaim("memberId", memberId)
                .sign(algorithm);
    }

    public Long extractMemberId(String token) {
        try {
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getClaim("memberId")
                    .asLong();
        } catch (JWTVerificationException e) {
            throw new UnAuthorizedException("유효하지 않은 토큰입니다.");
        }
    }
}
