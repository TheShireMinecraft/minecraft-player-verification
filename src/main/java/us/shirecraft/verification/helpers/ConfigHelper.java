package us.shirecraft.verification.helpers;

import org.bukkit.configuration.file.FileConfiguration;
import us.shirecraft.verification.models.PluginConfiguration;

public class ConfigHelper {
    private final static String _defaultVerificationBaseUrl = "https://localhost.localdomain/verify/%s/%s/%s";
    private final static String _defaultTokenSigningKey = "example-key-32-chars-example-key";
    private final static int _defaultTokenExpiryInMinutes = 10;

    public static void BuildDefaultConfiguration(FileConfiguration config) {
        config.addDefault("verificationBaseUrl", _defaultVerificationBaseUrl);
        config.addDefault("tokenSigningKey", _defaultTokenSigningKey);
        config.addDefault("tokenExpiryInMinutes", _defaultTokenExpiryInMinutes);
        config.options().copyDefaults(true);
    }

    public static PluginConfiguration MapConfigurationToModel(FileConfiguration config) {
        var model = new PluginConfiguration();
        model.verificationBaseUrl = config.getString("verificationBaseUrl", _defaultVerificationBaseUrl);
        model.tokenSigningKey = config.getString("tokenSigningKey", _defaultTokenSigningKey);
        model.tokenExpiryInMinutes = config.getInt("tokenExpiryInMinutes", _defaultTokenExpiryInMinutes);
        return model;
    }
}