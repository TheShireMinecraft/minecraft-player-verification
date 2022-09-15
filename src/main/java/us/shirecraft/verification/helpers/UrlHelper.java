package us.shirecraft.verification.helpers;

public class UrlHelper {
    public static String buildUrlForToken(String baseUrl, String token) {
        var tokenParts = token.split("\\.");
        var header = tokenParts[0];
        var payload = tokenParts[1];
        var signature = tokenParts[2];
        var template = baseUrl + "%s/%s/%s";
        return String.format(template, header, payload, signature);
    }
}
