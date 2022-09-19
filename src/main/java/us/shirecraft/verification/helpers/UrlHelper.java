package us.shirecraft.verification.helpers;

public class UrlHelper {
    public static String buildUrlForToken(
        String baseUrl,
        String token,
        boolean replaceJwtDotsWithSlashes,
        boolean omitJwtHeaderFromUrl
    ) {
        var tokenParts = token.split("\\.");
        var header = tokenParts[0];
        var payload = tokenParts[1];
        var signature = tokenParts[2];
        var delimiter = replaceJwtDotsWithSlashes ? "/" : ".";
        var jwtParts = omitJwtHeaderFromUrl
            ? new String[] { payload, signature }
            : new String[] { header, payload, signature };
        return baseUrl + String.join(delimiter, jwtParts);
    }
}
