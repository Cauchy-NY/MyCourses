package cn.cauchyny.mycourses.util;

import java.util.concurrent.ThreadLocalRandom;

public class TokenUtil {

    public static String getRandomToken(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((ThreadLocalRandom.current().nextInt(0, 9)));
        }
        return builder.toString();
    }
}
