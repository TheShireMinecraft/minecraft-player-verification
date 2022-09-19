package us.shirecraft.verification.helpers;

public class UrlHelper {
    public static String buildUrlForToken(String baseUrl, String token, boolean replaceJwtDotsWithSlashes) {
        var tokenParts = token.split("\\.");
        var header = tokenParts[0];
        var payload = tokenParts[1];
        var signature = tokenParts[2];
        var delimiter = replaceJwtDotsWithSlashes ? "/" : ".";
        return baseUrl + String.join(delimiter, new String[] {header, payload, signature});
    }
}
