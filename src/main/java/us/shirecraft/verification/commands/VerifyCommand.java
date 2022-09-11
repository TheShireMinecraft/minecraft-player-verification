package us.shirecraft.verification.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import us.shirecraft.verification.services.TokenService;

public class VerifyCommand implements CommandExecutor {
    private final TokenService _service;

    public VerifyCommand() {
        _service = new TokenService();
    }

    @Override
    public boolean onCommand(
        @NotNull CommandSender sender,
        @NotNull Command command,
        @NotNull String label,
        String[] args
    ) {
        if(!(sender instanceof Player player))
        {
            sender.sendMessage("This command may only be used by players");
            return true; // Suppress usage information by returning true
        }

        var playerUuid = player.getUniqueId().toString();
        sender.sendMessage("Hello, player with UUID " + playerUuid + " !");

        var token = _service.generateTokenForUuid(playerUuid);
        sender.sendMessage("Your token is: [" + token + "] !");

        return true;
    }
}
