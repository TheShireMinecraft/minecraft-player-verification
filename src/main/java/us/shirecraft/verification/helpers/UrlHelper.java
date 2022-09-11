package us.shirecraft.verification.helpers;

public class UrlHelper {
    final String urlTemplate = "https://shirecraft.us/verify/%s/%s/%s";

    public UrlHelper() {
    }

    public String buildUrlForToken(String token) {
        var tokenParts = token.split("\\.");
        var header = tokenParts[0];
        var payload = tokenParts[1];
        var signature = tokenParts[2];
        return String.format(urlTemplate, header, payload, signature);
    }
}
