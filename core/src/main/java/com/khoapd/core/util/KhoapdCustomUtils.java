package com.khoapd.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class KhoapdCustomUtils {

    private KhoapdCustomUtils() {
    }

    public static Throwable getCauseEx(Throwable cause) {
        return cause == null ? null : cause.getCause();
    }
    public static String getStackTrace(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        printWriter.close();

        try {
            stringWriter.close();
        } catch (IOException ex) {
            log.error(getMessageEx(ex));
        }

        return stringWriter.toString();
    }
    public static String getMessageEx(Throwable cause) {
        return cause.getMessage();
    }
}
