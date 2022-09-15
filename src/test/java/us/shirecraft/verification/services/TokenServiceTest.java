package us.shirecraft.verification.services;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import us.shirecraft.verification.models.PluginConfiguration;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenServiceTest {
    @Test
    void generateTokenForUuid__should_generate_signed_token_with_player_uuid() {
        // Arrange
        var config = new PluginConfiguration();
        config.tokenSigningKey = "-temporary-key-%%-temporary-key-";
        config.tokenExpiryInMinutes = 10;
        var systemUnderTest = new TokenService(config);
        var playerUuid = "31e36756-3820-4de5-bcff-f73902bba8ca";

        // Act
        var token = systemUnderTest.generateTokenForUuid(playerUuid);
        var jwtClaims = Jwts.parserBuilder()
            .setSigningKey(config.tokenSigningKey.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();
        var msInOneSecond = 1000d;
        var secondsInMinute = 60d;
        var tokenLifeInMinutes = (int) Math.ceil(
            (jwtClaims.getExpiration().getTime() - new Date().getTime())
            / msInOneSecond
            / secondsInMinute
        );

        // Assert
        assertEquals(playerUuid, jwtClaims.getSubject());
        assertEquals(config.tokenExpiryInMinutes, tokenLifeInMinutes);
    }
}
