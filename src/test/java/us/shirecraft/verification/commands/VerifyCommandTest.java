package us.shirecraft.verification.commands;

import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class VerifyCommandTest {
    @Test
    void onCommand__should_reject_non_player_senders() {
        // Arrange
        var systemUnderTest = new VerifyCommand();
        var sender = mock(ConsoleCommandSender.class);

        // Act
        systemUnderTest.onCommand(sender, mock(Command.class), "", new String[0]);

        // Assert
        verify(sender).sendMessage("This command may only be used by players");
    }

    @Test
    void onCommand__should_let_players_execute() {
        // Arrange
        var systemUnderTest = new VerifyCommand();
        var sender = mock(Player.class);
        var expectedUuid = "d4ac69b7-0de6-4052-a082-fa343c3f72f4";
        when(sender.getUniqueId()).thenReturn(UUID.fromString(expectedUuid));

        // Act
        systemUnderTest.onCommand(sender, mock(Command.class), "", new String[0]);

        // Assert
        verify(sender).sendMessage("Use the link below to verify your account:");
        verify(sender).sendMessage(ArgumentMatchers.startsWith("https://shirecraft.us/verify/"));
    }
}
