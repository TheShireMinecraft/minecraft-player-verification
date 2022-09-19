package us.shirecraft.verification.helpers;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ChatHelperTest {
    @Test
    void constructVerificationButtonForUrl__should_construct_text_component_with_click_event() {
        // Arrange
        final var url = "https://localhost:4567/verify/aaabbbccc";

        // Act
        var actual = ChatHelper.constructVerificationButtonForUrl(url);

        // Assert
        assertEquals("[ Verify Account ]", actual.content());
        assertEquals(ClickEvent.Action.OPEN_URL, Objects.requireNonNull(actual.clickEvent()).action());
        assertEquals(url, Objects.requireNonNull(actual.clickEvent()).value());
        assertEquals(NamedTextColor.GREEN, actual.color());
        assertTrue(actual.hasDecoration(TextDecoration.BOLD));
        assertEquals(HoverEvent.Action.SHOW_TEXT, Objects.requireNonNull(actual.hoverEvent()).action());
        assertEquals(
            "Connect your in-game and website accounts",
            ((TextComponent) Objects.requireNonNull(actual.hoverEvent()).value()).content()
        );
    }
}
