package us.shirecraft.verification.models;

public class PluginConfiguration {
    public String verificationBaseUrl;
    public String tokenSigningKey;
    public int tokenExpiryInMinutes;

    public PluginConfiguration() {
    }

    public PluginConfiguration(
        String verificationBaseUrl,
        String tokenSigningKey,
        int tokenExpiryInMinutes
    ) {
        this.verificationBaseUrl = verificationBaseUrl;
        this.tokenSigningKey = tokenSigningKey;
        this.tokenExpiryInMinutes = tokenExpiryInMinutes;
    }
}
