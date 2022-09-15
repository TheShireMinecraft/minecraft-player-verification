package us.shirecraft.verification.helpers;

import org.bukkit.configuration.file.FileConfiguration;
import us.shirecraft.verification.models.PluginConfiguration;

public class ConfigHelper {
    private final static PluginConfiguration _defaults =
        new PluginConfiguration(
            "https://localhost.localdomain/verify/%s/%s/%s",
            "example-key-32-chars-example-key",
            10
        );

    public static void BuildDefaultConfiguration(FileConfiguration config) {
        config.addDefault("verificationBaseUrl", _defaults.verificationBaseUrl);
        config.addDefault("tokenSigningKey", _defaults.tokenSigningKey);
        config.addDefault("tokenExpiryInMinutes", _defaults.tokenExpiryInMinutes);
        config.options().copyDefaults(true);
    }

    public static PluginConfiguration MapConfigurationToModel(FileConfiguration config) {
        var model = new PluginConfiguration();
        model.verificationBaseUrl = config.getString("verificationBaseUrl", _defaults.verificationBaseUrl);
        model.tokenSigningKey = config.getString("tokenSigningKey", _defaults.tokenSigningKey);
        model.tokenExpiryInMinutes = config.getInt("tokenExpiryInMinutes", _defaults.tokenExpiryInMinutes);
        return model;
    }
}