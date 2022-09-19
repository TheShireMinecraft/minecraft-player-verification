package us.shirecraft.verification.services;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import us.shirecraft.verification.helpers.UrlHelper;
import us.shirecraft.verification.models.PluginConfiguration;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void generateTokenForUuid__should_generate_token_for_url_that_can_be_decoded_and_verified() {
        // Arrange
        var config = new PluginConfiguration();
        config.tokenSigningKey = "-temporary-key-%%-temporary-key-";
        config.tokenExpiryInMinutes = 10;
        var systemUnderTest = new TokenService(config);
        var playerUuid = "069a79f4-44e9-4726-a5be-fca90e38aaf5";
        var token = systemUnderTest.generateTokenForUuid(playerUuid);
        var verificationUrl = UrlHelper.buildUrlForToken(
                "https://localhost:8081/verify/",
                token,
                true,
                true,
                true
        );
        var header = "eyJhbGciOiJIUzI1NiJ9";
        var urlParts = verificationUrl.split("/");
        var urlPayload = urlParts[4];
        var urlSignature = urlParts[5];
        var reconstructedTokenParts = new String[] { header, "eyJ" + urlPayload, urlSignature };

        // Act
        var reconstructedToken = String.join(".", reconstructedTokenParts);

        // Assert
        assertEquals(token, reconstructedToken);
        assertDoesNotThrow(() -> {
            Jwts.parserBuilder()
                    .setSigningKey(config.tokenSigningKey.getBytes())
                    .build()
                    .parseClaimsJws(reconstructedToken);
        });
    }
}
