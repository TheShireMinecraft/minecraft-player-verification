package verification;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerVerification extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Player verification plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Player verification plugin has been disabled");
    }
}
