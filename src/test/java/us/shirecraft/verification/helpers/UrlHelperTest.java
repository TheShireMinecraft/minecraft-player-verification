package us.shirecraft.verification.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlHelperTest {
    @Test
    void buildUrlForToken__should_build_url_from_token_with_slashes_as_jwt_delimiter() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken("https://shirecraft.us/verify/", token, true);

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9/eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }

    @Test
    void buildUrlForToken__should_build_url_from_token_with_dots_as_jwt_delimiter() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken("https://shirecraft.us/verify/", token, false);

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }
}
