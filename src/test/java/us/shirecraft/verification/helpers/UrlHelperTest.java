package us.shirecraft.verification.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlHelperTest {
    @Test
    void buildUrlForToken__should_build_url_from_token_with_slashes_as_jwt_delimiter() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
            "https://shirecraft.us/verify/",
            token,
            true,
            false,
            false
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9/eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }

    @Test
    void buildUrlForToken__should_build_url_from_token_with_slash_delimiter_and_skip_header() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
            "https://shirecraft.us/verify/",
            token,
            true,
            true,
            false
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }

    @Test
    void buildUrlForToken__should_build_url_from_token_with_dots_as_jwt_delimiter() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
            "https://shirecraft.us/verify/",
            token,
            false,
            false,
            false
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }

    @Test
    void buildUrlForToken__should_build_url_from_token_with_dot_delimiter_and_skip_header() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
            "https://shirecraft.us/verify/",
            token,
            false,
            true,
            false
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }

    @Test
    void buildUrlForToken__should_build_url_with_slash_delimiter_and_strip_eyj_prefix() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
                "https://shirecraft.us/verify/",
                token,
                true,
                false,
                true
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/hbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9/zdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }


    @Test
    void buildUrlForToken__should_build_url_with_slash_delimiter_and_omit_header_and_strip_eyj_prefix() {
        // Arrange
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0.5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ";

        // Act
        var actual = UrlHelper.buildUrlForToken(
                "https://shirecraft.us/verify/",
                token,
                true,
                true,
                true
        );

        // Assert
        assertEquals("https://shirecraft.us/verify/zdWIiOiIxIiwibmFtZSI6IkJvYiIsImlhdCI6MH0/5Z9_8Jtfjkh1A67VrPQzgeJ2_bhzwhc0KcWo0jvvkMQ", actual);
    }
}
