package us.shirecraft.verification.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import us.shirecraft.verification.helpers.ChatHelper;
import us.shirecraft.verification.helpers.UrlHelper;
import us.shirecraft.verification.models.PluginConfiguration;
import us.shirecraft.verification.services.TokenService;

public class VerifyCommand implements CommandExecutor {
    private final TokenService _service;
    private final PluginConfiguration _config;

    public VerifyCommand(PluginConfiguration config) {
        _config = config;
        _service = new TokenService(config);
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

        var verificationUrl = buildVerificationUrlForPlayer(player);
        var verificationButton = ChatHelper.constructVerificationButtonForUrl(verificationUrl);

        sender.sendMessage("");
        sender.sendMessage("Use the button below to verify your account:");
        sender.sendMessage(verificationButton);

        return true;
    }

    private String buildVerificationUrlForPlayer(Player player) {
        var playerUuid = player.getUniqueId().toString();
        var token = _service.generateTokenForUuid(playerUuid);
        return UrlHelper.buildUrlForToken(
            _config.verificationBaseUrl,
            token,
            _config.replaceJwtDotsWithSlashes,
            _config.omitJwtHeaderFromUrl,
            _config.omitJwtHeaderAndPayloadEyjPrefix
        );
    }
}
