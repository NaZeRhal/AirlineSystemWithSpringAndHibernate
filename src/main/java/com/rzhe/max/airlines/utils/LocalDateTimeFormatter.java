package com.rzhe.max.airlines.utils;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    private String pattern;

    public LocalDateTimeFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public LocalDateTime parse(String s, Locale locale) throws ParseException {
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public String print(LocalDateTime localDateTime, Locale locale) {
        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
    }
}
