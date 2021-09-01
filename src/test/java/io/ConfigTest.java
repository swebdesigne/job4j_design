package io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Igor Sivolobov"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairHasCommentsAndEmptyStrings() {
        String path = "./data/pair_has_comments_and_empty_strings.properties";
        Config config = new Config(path);
        config.load();
        assertTrue(config.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairHasDisturbanceBetweenKeyAndValue() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
    }
}