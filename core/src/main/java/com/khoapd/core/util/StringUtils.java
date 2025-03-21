package com.khoapd.core.util;

import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

@UtilityClass
public class StringUtils {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final String EMPTY = "";
    private static final Random RANDOM = new Random();

    public boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public boolean isAnyEmpty(String... strings) {
        if (strings == null) return true;
        for (String str : strings) {
            if (isEmpty(str)) return true;
        }
        return false;
    }

    public boolean isAllEmpty(String... strings) {
        if (strings == null) return true;
        for (String str : strings) {
            if (isNotEmpty(str)) return false;
        }
        return true;
    }

    public String toSlug(String input) {
        if (isEmpty(input)) return EMPTY;

        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll(EMPTY);
        return slug.toLowerCase();
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String generateRandomString(int length) {
        if (length < 1) return EMPTY;

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public String join(Collection<?> collection, String separator) {
        if (CollectionUtils.isEmpty(collection)) return EMPTY;
        return String.join(separator, collection.stream()
                .map(Object::toString)
                .toList());
    }

    public String truncate(String str, int maxLength) {
        if (isEmpty(str) || maxLength < 1) return EMPTY;
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength) + "...";
    }

    public String capitalize(String str) {
        if (isEmpty(str)) return EMPTY;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String reverse(String str) {
        if (isEmpty(str)) return EMPTY;
        return new StringBuilder(str).reverse().toString();
    }

    public String removeAccents(String str) {
        if (isEmpty(str)) return EMPTY;
        String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
        return Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
                .matcher(temp)
                .replaceAll(EMPTY);
    }

    public String maskEmail(String email) {
        if (isEmpty(email)) return EMPTY;
        String[] parts = email.split("@");
        if (parts.length != 2) return email;

        String name = parts[0];
        String domain = parts[1];

        if (name.length() <= 2) return email;
        return name.charAt(0) +
                "*".repeat(name.length() - 2) +
                name.charAt(name.length() - 1) +
                "@" + domain;
    }

    public String maskPhoneNumber(String phoneNumber) {
        if (isEmpty(phoneNumber)) return EMPTY;
        if (phoneNumber.length() <= 4) return phoneNumber;

        return "*".repeat(phoneNumber.length() - 4) +
                phoneNumber.substring(phoneNumber.length() - 4);
    }

    public String extractNumbers(String str) {
        if (isEmpty(str)) return EMPTY;
        return str.replaceAll("[^0-9]", EMPTY);
    }

    public String extractLetters(String str) {
        if (isEmpty(str)) return EMPTY;
        return str.replaceAll("[^a-zA-Z]", EMPTY);
    }
} 