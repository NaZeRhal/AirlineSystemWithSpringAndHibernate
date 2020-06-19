package com.rzhe.max.airlines.utils;

import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String s, Locale locale) {
        return LocalDate.parse(s, getFormatter());
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return getFormatter().format(localDate);
    }

    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }
}
