package us.shirecraft.verification.helpers;

import org.bukkit.configuration.MemoryConfiguration;
import us.shirecraft.verification.models.PluginConfiguration;

public class ConfigHelper {
    private final static PluginConfiguration _defaults =
        new PluginConfiguration(
            "https://localhost.localdomain/verify/",
            "example-key-32-chars-example-key",
            10,
            true,
            false,
            false
        );

    public static void BuildDefaultConfiguration(MemoryConfiguration config) {
        config.addDefault("verificationBaseUrl", _defaults.verificationBaseUrl);
        config.addDefault("tokenSigningKey", _defaults.tokenSigningKey);
        config.addDefault("tokenExpiryInMinutes", _defaults.tokenExpiryInMinutes);
        config.addDefault("replaceJwtDotsWithSlashes", _defaults.replaceJwtDotsWithSlashes);
        config.addDefault("omitJwtHeaderFromUrl", _defaults.omitJwtHeaderFromUrl);
        config.addDefault("omitJwtHeaderAndPayloadEyjPrefix", _defaults.omitJwtHeaderAndPayloadEyjPrefix);
        config.options().copyDefaults(true);
    }

    public static PluginConfiguration MapConfigurationToModel(MemoryConfiguration config) {
        var model = new PluginConfiguration();
        model.verificationBaseUrl = config.getString("verificationBaseUrl", _defaults.verificationBaseUrl);
        model.tokenSigningKey = config.getString("tokenSigningKey", _defaults.tokenSigningKey);
        model.tokenExpiryInMinutes = config.getInt("tokenExpiryInMinutes", _defaults.tokenExpiryInMinutes);
        model.replaceJwtDotsWithSlashes = config.getBoolean("replaceJwtDotsWithSlashes", _defaults.replaceJwtDotsWithSlashes);
        model.omitJwtHeaderFromUrl = config.getBoolean("omitJwtHeaderFromUrl", _defaults.omitJwtHeaderFromUrl);
        model.omitJwtHeaderAndPayloadEyjPrefix = config.getBoolean("omitJwtHeaderAndPayloadEyjPrefix", _defaults.omitJwtHeaderAndPayloadEyjPrefix);
        return model;
    }
}