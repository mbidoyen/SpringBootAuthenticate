package fr.mathieu.SpringBootAuthentication.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger log = LoggerFactory.getLogger(LoggerUtil.class);

    public static void logSuccess(String message) {
        log.info("\u001B[32m[SUCCESS]\u001B[0m {}", message);
    }
}
