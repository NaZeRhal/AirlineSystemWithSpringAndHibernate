package com.rzhe.max.airlines.utils;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    @Override
    public LocalDateTime parse(String s, Locale locale) throws ParseException {
        return LocalDateTime.parse(s, getFormatter());
    }

    @Override
    public String print(LocalDateTime localDateTime, Locale locale) {
        return getFormatter().format(localDateTime);
    }

    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd--MM--yyyy HH:mm");
    }
}
