package us.shirecraft.verification;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import us.shirecraft.verification.commands.VerifyCommand;

public class PlayerVerification extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginCommand verifyCommand = this.getCommand("verify");
        if(verifyCommand != null)
        {
            verifyCommand.setExecutor(new VerifyCommand());
        }

        getLogger().info("Player verification plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Player verification plugin has been disabled");
    }
}
