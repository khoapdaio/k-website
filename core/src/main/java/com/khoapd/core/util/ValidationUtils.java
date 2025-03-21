package com.khoapd.core.util;

import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.regex.Pattern;

@UtilityClass
public class ValidationUtils {

    public boolean isValidEmail(String email) {
        if (!StringUtils.hasText(email)) {
            return false;
        }
        return Pattern.compile(RegexConstants.EMAIL_PATTERN)
                .matcher(email)
                .matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        if (!StringUtils.hasText(phoneNumber)) {
            return false;
        }
        return Pattern.compile(RegexConstants.PHONE_PATTERN)
                .matcher(phoneNumber)
                .matches();
    }

    public boolean isValidVietnamesePhoneNumber(String phoneNumber) {
        if (!StringUtils.hasText(phoneNumber)) {
            return false;
        }
        return Pattern.compile(RegexConstants.VN_PHONE_PATTERN)
                .matcher(phoneNumber)
                .matches();
    }

    public boolean isValidPassword(String password) {
        if (!StringUtils.hasText(password)) {
            return false;
        }
        return Pattern.compile(RegexConstants.PASSWORD_PATTERN)
                .matcher(password)
                .matches();
    }

    public boolean isValidUsername(String username) {
        if (!StringUtils.hasText(username)) {
            return false;
        }
        return Pattern.compile(RegexConstants.USERNAME_PATTERN)
                .matcher(username)
                .matches();
    }

    public boolean isValidUrl(String url) {
        if (!StringUtils.hasText(url)) {
            return false;
        }
        return Pattern.compile(RegexConstants.URL_PATTERN)
                .matcher(url)
                .matches();
    }

    public boolean isValidDate(String date) {
        if (!StringUtils.hasText(date)) {
            return false;
        }
        return Pattern.compile(RegexConstants.DATE_PATTERN)
                .matcher(date)
                .matches();
    }

    public boolean isValidDateTime(String dateTime) {
        if (!StringUtils.hasText(dateTime)) {
            return false;
        }
        return Pattern.compile(RegexConstants.DATETIME_PATTERN)
                .matcher(dateTime)
                .matches();
    }

    public boolean isValidImageFile(String fileName) {
        if (!StringUtils.hasText(fileName)) {
            return false;
        }
        return Pattern.compile(RegexConstants.IMAGE_FILE_PATTERN, Pattern.CASE_INSENSITIVE)
                .matcher(fileName)
                .matches();
    }

    public boolean isValidDocumentFile(String fileName) {
        if (!StringUtils.hasText(fileName)) {
            return false;
        }
        return Pattern.compile(RegexConstants.DOCUMENT_FILE_PATTERN, Pattern.CASE_INSENSITIVE)
                .matcher(fileName)
                .matches();
    }

    public boolean isValidIPv4(String ip) {
        if (!StringUtils.hasText(ip)) {
            return false;
        }
        return Pattern.compile(RegexConstants.IPV4_PATTERN)
                .matcher(ip)
                .matches();
    }

    public boolean isValidIPv6(String ip) {
        if (!StringUtils.hasText(ip)) {
            return false;
        }
        return Pattern.compile(RegexConstants.IPV6_PATTERN)
                .matcher(ip)
                .matches();
    }

    public boolean isNullOrEmpty(String str) {
        return !StringUtils.hasText(str);
    }

    public boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public boolean isValidLength(String str, int minLength, int maxLength) {
        if (!StringUtils.hasText(str)) {
            return false;
        }
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }

    public boolean isNumeric(String str) {
        if (!StringUtils.hasText(str)) {
            return false;
        }
        return str.matches("\\d+");
    }

    public boolean isAlphabetic(String str) {
        if (!StringUtils.hasText(str)) {
            return false;
        }
        return str.matches("[a-zA-Z]+");
    }

    public boolean isAlphanumeric(String str) {
        if (!StringUtils.hasText(str)) {
            return false;
        }
        return str.matches("[a-zA-Z0-9]+");
    }
} 