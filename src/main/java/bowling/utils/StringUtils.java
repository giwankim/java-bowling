package bowling.utils;

import java.util.Collections;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String repeat(int count, String string) {
        return String.join("", Collections.nCopies(count, string));
    }
}
