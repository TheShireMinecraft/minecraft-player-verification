package us.shirecraft.verification.helpers;

public class UrlHelper {
    public static String buildUrlForToken(
        String baseUrl,
        String token,
        boolean replaceJwtDotsWithSlashes,
        boolean omitJwtHeaderFromUrl,
        boolean omitJwtHeaderAndPayloadEyjPrefix
    ) {
        var tokenParts = token.split("\\.");
        var header = tokenParts[0];
        var payload = tokenParts[1];
        var signature = tokenParts[2];

        if(omitJwtHeaderAndPayloadEyjPrefix) {
            if (header.startsWith("eyJ")) {
                header = header.substring(3);
            }
            if (payload.startsWith("eyJ")) {
                payload = payload.substring(3);
            }
        }

        var delimiter = replaceJwtDotsWithSlashes ? "/" : ".";
        var jwtParts = omitJwtHeaderFromUrl
            ? new String[] { payload, signature }
            : new String[] { header, payload, signature };

        return baseUrl + String.join(delimiter, jwtParts);
    }
}
