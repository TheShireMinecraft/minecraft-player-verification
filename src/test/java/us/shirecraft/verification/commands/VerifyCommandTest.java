package us.shirecraft.verification.commands;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import us.shirecraft.verification.models.PluginConfiguration;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class VerifyCommandTest {
    @Test
    void onCommand__should_reject_non_player_senders() {
        // Arrange
        var systemUnderTest = new VerifyCommand(null);
        var sender = mock(ConsoleCommandSender.class);

        // Act
        systemUnderTest.onCommand(sender, mock(Command.class), "", new String[0]);

        // Assert
        verify(sender).sendMessage("This command may only be used by players");
    }

    @Test
    void onCommand__should_let_players_execute() {
        // Arrange
        var config = new PluginConfiguration();
        config.verificationBaseUrl = "https://shirecraft.us/verify/";
        config.tokenExpiryInMinutes = 10;
        config.tokenSigningKey = "00000000000000000000000000000000";
        var systemUnderTest = new VerifyCommand(config);
        var sender = mock(Player.class);
        var expectedUuid = "d4ac69b7-0de6-4052-a082-fa343c3f72f4";
        when(sender.getUniqueId()).thenReturn(UUID.fromString(expectedUuid));

        // Act
        systemUnderTest.onCommand(sender, mock(Command.class), "", new String[0]);

        // Assert
        verify(sender).sendMessage("Use the button below to verify your account:");
        verify(sender).sendMessage(ArgumentMatchers.any(TextComponent.class));
    }
}
