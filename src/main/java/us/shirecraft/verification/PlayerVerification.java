package us.shirecraft.verification;

import org.bukkit.plugin.java.JavaPlugin;
import us.shirecraft.verification.commands.VerifyCommand;
import us.shirecraft.verification.helpers.ConfigHelper;

public final class PlayerVerification extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigHelper.BuildDefaultConfiguration(getConfig());
        saveConfig();
        var config = ConfigHelper.MapConfigurationToModel(getConfig());

        var verifyCommand = this.getCommand("verify");
        if(verifyCommand != null)
        {
            verifyCommand.setExecutor(new VerifyCommand(config));
        }

        getLogger().info("Player verification plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Player verification plugin has been disabled");
    }
}
