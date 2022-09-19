package us.shirecraft.verification.helpers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class ChatHelper {
    public static TextComponent constructVerificationButtonForUrl(String url) {
        return Component.text("[ Verify Account ]")
                .color(NamedTextColor.GREEN)
                .decorate(TextDecoration.BOLD)
                .clickEvent(ClickEvent.openUrl(url));
    }
}
