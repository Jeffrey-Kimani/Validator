package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class ValidationData {
    private boolean test;
    private String message;

    public ValidationData(boolean test, String message) {
        this.test = test;
        this.message = message;
    }

    public boolean isTrue() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
