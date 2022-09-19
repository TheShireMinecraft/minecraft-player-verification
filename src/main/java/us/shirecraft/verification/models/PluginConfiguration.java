package us.shirecraft.verification.models;

public class PluginConfiguration {
    public String verificationBaseUrl;
    public String tokenSigningKey;
    public int tokenExpiryInMinutes;
    public boolean replaceJwtDotsWithSlashes;
    public boolean omitJwtHeaderFromUrl;
    public boolean omitJwtHeaderAndPayloadEyjPrefix;

    public PluginConfiguration() {
    }

    public PluginConfiguration(
        String verificationBaseUrl,
        String tokenSigningKey,
        int tokenExpiryInMinutes,
        boolean replaceJwtDotsWithSlashes,
        boolean omitJwtHeaderFromUrl,
        boolean omitJwtHeaderAndPayloadEyjPrefix
    ) {
        this.verificationBaseUrl = verificationBaseUrl;
        this.tokenSigningKey = tokenSigningKey;
        this.tokenExpiryInMinutes = tokenExpiryInMinutes;
        this.replaceJwtDotsWithSlashes = replaceJwtDotsWithSlashes;
        this.omitJwtHeaderFromUrl = omitJwtHeaderFromUrl;
        this.omitJwtHeaderAndPayloadEyjPrefix = omitJwtHeaderAndPayloadEyjPrefix;
    }
}
