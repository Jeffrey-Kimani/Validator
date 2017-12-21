package com.Tunes_Developers.Models;

import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/21/2017.
 */
public class WarningMessage {
    private String name;
    private String message;

    public WarningMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public static boolean hasMessage(String name, List<WarningMessage> messages) {
        for (WarningMessage message : messages) {
            if (name.equals(message.getName())) {
                return true;
            }
        }

        return false;
    }
}
