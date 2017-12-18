package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class ValidationMessage {
    private String accepted = "";
    private String alpha = "The ${1:attribute} should only contain characters";
    private String alphaDash = "The ${1:attribute} should only contain characters and dashes";
    private String alphaNumeric = "The ${1:attribute} should only contain characters and numbers";
    private String alphaSpaced = "The ${1:attribute} should only contain characters, numbers and spaces";
    private String numeric = "The ${1:attribute} should be a number";
    private String numericFormatted = "The ${1:attribute} can only accept numbers and - ( ) characters";
    private String ip = "The ${1:attribute} is not a valid ip";
    private String beforeDate = "The ${1:attribute} should be before ${2:17-12-2017}";
    private String afterDate = "The ${1:attribute} should be after ${2:17-12-2017}";
    private String equalToDate = "The ${1:attribute} should be equal to ${2:17-12-2017}";
    private String maxChar = "The ${1:attribute} should not be more than ${2:10} characters";
    private String minChar = "The ${1:attribute} should not be less than ${2:10} characters";
    private String charBetween = "The ${1:attribute} should not be between ${2:5} and ${3:10} characters";
    private String digitsBetween = "The ${1:attribute} should contain digits between ${2:5} and ${3:10}";
    private String email = "The ${1:attribute} is not a valid email";
    private String exists = "The ${1:attribute} already exists in the database";
    private String in = "This ${1:attribute} is invalid";
    private String notIn = "This ${1:attribute} is invalid";
    private String same = "This ${1:attribute} and ${2:other} must match";

    public String getAccepted() {
        return accepted;
    }

    public String getAlpha() {
        return alpha;
    }

    public String getAlphaDash() {
        return alphaDash;
    }

    public String getAlphaNumeric() {
        return alphaNumeric;
    }

    public String getAlphaSpaced() {
        return alphaSpaced;
    }

    public String getNumeric() {
        return numeric;
    }

    public String getNumericFormatted() {
        return numericFormatted;
    }

    public String getIp() {
        return ip;
    }

    public String getBeforeDate() {
        return beforeDate;
    }

    public String getAfterDate() {
        return afterDate;
    }

    public String getEqualToDate() {
        return equalToDate;
    }

    public String getMaxChar() {
        return maxChar;
    }

    public String getMinChar() {
        return minChar;
    }

    public String getCharBetween() {
        return charBetween;
    }

    public String getDigitsBetween() {
        return digitsBetween;
    }

    public String getEmail() {
        return email;
    }

    public String getExists() {
        return exists;
    }

    public String getIn() {
        return in;
    }

    public String getNotIn() {
        return notIn;
    }

    public String getSame() {
        return same;
    }
}
