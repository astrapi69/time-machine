package io.github.astrapi69.time;

import io.github.astrapi69.time.enums.DatePattern;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalTimeExtensionsTest {

    @Test
    void toDateString() {
        String actual;
        String expected;
        LocalTime input;
        // new scenario
        input = LocalTime.of(12, 9, 1);
        actual = LocalTimeExtensions.toDateString(input, DatePattern.UHH_MM_SS.getPattern());
        expected = "12:09:01";
        assertEquals(expected, actual);
    }
}
