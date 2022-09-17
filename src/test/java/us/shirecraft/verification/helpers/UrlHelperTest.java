package us.shirecraft.verification.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlHelperTest {
    @Test
    void buildUrlForToken__should_() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken("https://shirecraft.us/verify/", token);

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9/eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }
}
