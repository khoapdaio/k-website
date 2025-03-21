package com.khoapd.core.util;

public class RegexConstants {
    // Email pattern - RFC 5322 standard
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    // Phone patterns
    public static final String PHONE_PATTERN = "^\\+?[1-9][0-9]{7,14}$";
    public static final String VN_PHONE_PATTERN = "^(\\+84|0)[35789][0-9]{8}$";

    // Password pattern - At least 8 characters, one uppercase, one lowercase, one number, one special character
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    // Username pattern - Alphanumeric and underscore, 3-20 characters
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,20}$";

    // URL pattern
    public static final String URL_PATTERN = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";

    // Date patterns
    public static final String DATE_PATTERN = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
    public static final String DATETIME_PATTERN = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(\\.\\d+)?(Z|[+-][01]\\d:[0-5]\\d)?$";

    // Common patterns
    public static final String NUMERIC_PATTERN = "^\\d+$";
    public static final String DECIMAL_PATTERN = "^\\d*\\.?\\d+$";
    public static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]*$";
    public static final String ALPHABETIC_PATTERN = "^[a-zA-Z]*$";

    // File patterns
    public static final String IMAGE_FILE_PATTERN = ".*\\.(jpg|jpeg|png|gif|bmp)$";
    public static final String DOCUMENT_FILE_PATTERN = ".*\\.(pdf|doc|docx|xls|xlsx|txt)$";

    // IP address patterns
    public static final String IPV4_PATTERN = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    public static final String IPV6_PATTERN = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";

    private RegexConstants() {
        throw new IllegalStateException("Constants class");
    }
} 