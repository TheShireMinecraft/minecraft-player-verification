package us.shirecraft.verification.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import us.shirecraft.verification.helpers.UrlHelper;
import us.shirecraft.verification.services.TokenService;

public class VerifyCommand implements CommandExecutor {
    private final TokenService _service;
    private final UrlHelper _urlHelper;

    public VerifyCommand() {
        _service = new TokenService();
        _urlHelper = new UrlHelper();
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

        sender.sendMessage("Use the link below to verify your account:");
        sender.sendMessage(buildVerificationUrlForPlayer(player));

        return true;
    }

    private String buildVerificationUrlForPlayer(Player player) {
        var playerUuid = player.getUniqueId().toString();
        var token = _service.generateTokenForUuid(playerUuid);
        return _urlHelper.buildUrlForToken(token);
    }
}
