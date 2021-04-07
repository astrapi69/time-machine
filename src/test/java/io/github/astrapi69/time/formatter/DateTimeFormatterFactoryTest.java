package io.github.astrapi69.time.formatter;

import io.github.astrapi69.time.enums.DatePattern;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link DateTimeFormatterFactory}
 */
class DateTimeFormatterFactoryTest {

    @Test
    void newDateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatterFactory
                .newDateTimeFormatter(DatePattern.DDMM);
        assertNotNull(dateTimeFormatter);
    }
}
