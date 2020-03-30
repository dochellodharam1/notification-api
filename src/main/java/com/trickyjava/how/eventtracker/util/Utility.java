package com.trickyjava.how.eventtracker.util;

import java.util.UUID;

public interface Utility {
    static String hash(String... input) {
        String str = String.join(",", input);
        return UUID.nameUUIDFromBytes(str.getBytes()).toString();
    }
}
