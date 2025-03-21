package com.khoapd.core.util;

import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@UtilityClass
public class DateTimeUtils {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    public LocalDateTime nowAtZone(String zoneId) {
        return LocalDateTime.now(ZoneId.of(zoneId));
    }

    public LocalDate today() {
        return LocalDate.now();
    }

    public String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    public String formatDate(LocalDate date, String pattern) {
        if (date == null) return null;
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        if (dateTimeStr == null) return null;
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public LocalDate parseDate(String dateStr, String pattern) {
        if (dateStr == null) return null;
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public long getDaysBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.DAYS.between(start, end);
    }

    public long getHoursBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.HOURS.between(start, end);
    }

    public long getMinutesBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.MINUTES.between(start, end);
    }

    public LocalDateTime addDays(LocalDateTime dateTime, long days) {
        if (dateTime == null) return null;
        return dateTime.plusDays(days);
    }

    public LocalDateTime subtractDays(LocalDateTime dateTime, long days) {
        if (dateTime == null) return null;
        return dateTime.minusDays(days);
    }

    public boolean isDateInRange(LocalDateTime date, LocalDateTime start, LocalDateTime end) {
        if (date == null || start == null || end == null) return false;
        return !date.isBefore(start) && !date.isAfter(end);
    }

    public LocalDateTime getStartOfDay(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.toLocalDate().atStartOfDay();
    }

    public LocalDateTime getEndOfDay(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    public LocalDateTime getStartOfMonth(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.withDayOfMonth(1).toLocalDate().atStartOfDay();
    }

    public LocalDateTime getEndOfMonth(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.withDayOfMonth(dateTime.toLocalDate().lengthOfMonth())
                .toLocalDate().atTime(LocalTime.MAX);
    }

    public boolean isWeekend(LocalDateTime dateTime) {
        if (dateTime == null) return false;
        DayOfWeek day = dateTime.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public int getAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
} 