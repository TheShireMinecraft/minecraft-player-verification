package us.shirecraft.verification.helpers;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ConfigHelperTest {
    @Test
    void BuildDefaultConfiguration__Should_Set_Defaults() {
        // Arrange
        var mockConfiguration = mock(FileConfiguration.class);
        var mockOptions = mock(FileConfigurationOptions.class);
        when(mockConfiguration.options()).thenReturn(mockOptions);

        // Act
        ConfigHelper.BuildDefaultConfiguration(mockConfiguration);

        // Assert
        verify(mockConfiguration).addDefault(ArgumentMatchers.eq("verificationBaseUrl"), ArgumentMatchers.anyString());
        verify(mockConfiguration).addDefault(ArgumentMatchers.eq("tokenSigningKey"), ArgumentMatchers.anyString());
        verify(mockConfiguration).addDefault(ArgumentMatchers.eq("tokenExpiryInMinutes"), ArgumentMatchers.anyInt());
        verify(mockConfiguration).addDefault(ArgumentMatchers.eq("replaceJwtDotsWithSlashes"), ArgumentMatchers.anyBoolean());
        verify(mockConfiguration).options();
        verifyNoMoreInteractions(mockConfiguration);
        verify(mockOptions).copyDefaults(true);
    }

    @Test
    void MapConfigurationToModel__Should_Map() {
        // Arrange
        var config = new YamlConfiguration();
        config.set("verificationBaseUrl", "https://example.org/x/y/z");
        config.set("tokenSigningKey", "*$$$$$$$$$$@@@@@@@@@@!!!!!!!!!!*");
        config.set("tokenExpiryInMinutes", 567);
        config.set("replaceJwtDotsWithSlashes", true);

        // Act
        var actual = ConfigHelper.MapConfigurationToModel(config);

        // Assert
        assertEquals("https://example.org/x/y/z", actual.verificationBaseUrl);
        assertEquals("*$$$$$$$$$$@@@@@@@@@@!!!!!!!!!!*", actual.tokenSigningKey);
        assertEquals(567, actual.tokenExpiryInMinutes);
        assertTrue(actual.replaceJwtDotsWithSlashes);
    }
}
