package us.shirecraft.verification.models;

public class PluginConfiguration {
    public String verificationBaseUrl;
    public String tokenSigningKey;
    public int tokenExpiryInMinutes;
    public boolean replaceJwtDotsWithSlashes;

    public PluginConfiguration() {
    }

    public PluginConfiguration(
        String verificationBaseUrl,
        String tokenSigningKey,
        int tokenExpiryInMinutes,
        boolean replaceJwtDotsWithSlashes
    ) {
        this.verificationBaseUrl = verificationBaseUrl;
        this.tokenSigningKey = tokenSigningKey;
        this.tokenExpiryInMinutes = tokenExpiryInMinutes;
        this.replaceJwtDotsWithSlashes = replaceJwtDotsWithSlashes;
    }
}
