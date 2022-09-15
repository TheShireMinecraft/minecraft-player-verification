package us.shirecraft.verification.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TokenService {
    private final SignatureAlgorithm _algorithm = SignatureAlgorithm.HS256;
    private final SecretKey _signingKey; // TODO move key to a configuration item

    public TokenService() {
        _signingKey = Keys.hmacShaKeyFor("-temporary-key-%%-temporary-key-".getBytes()); // 32 chars
    }

    public String generateTokenForUuid(@NotNull String uuid) {
        var builder = Jwts.builder();
        builder.setSubject(uuid);
        builder.setIssuedAt(new Date());
        builder.setExpiration(calculateExpiryDate(10));
        builder.signWith(_signingKey, _algorithm);
        return builder.compact();
    }

    private Date calculateExpiryDate(int minutesToExpiry) {
        return Date.from(
                Instant.now().plus(minutesToExpiry, ChronoUnit.MINUTES)
        );
    }
}
