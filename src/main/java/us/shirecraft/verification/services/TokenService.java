package us.shirecraft.verification.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import us.shirecraft.verification.models.PluginConfiguration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TokenService {
    private final PluginConfiguration _config;

    public TokenService(PluginConfiguration config) {
        _config = config;
    }

    public String generateTokenForUuid(@NotNull String uuid) {
        var builder = Jwts.builder();
        builder.setSubject(uuid);
        builder.setIssuedAt(new Date());
        builder.setExpiration(calculateExpiryDate(_config.tokenExpiryInMinutes));
        builder.signWith(
            Keys.hmacShaKeyFor(_config.tokenSigningKey.getBytes()),
            SignatureAlgorithm.HS256
        );
        return builder.compact();
    }

    private Date calculateExpiryDate(int minutesToExpiry) {
        return Date.from(
                Instant.now().plus(minutesToExpiry, ChronoUnit.MINUTES)
        );
    }
}
