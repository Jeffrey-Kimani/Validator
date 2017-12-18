package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class ValidatorItem {
    private String name;
    private String data;
    private String validatorRules;

    public ValidatorItem(String name, String data, String validatorRules) {
        this.name = name;
        this.data = data;
        this.validatorRules = validatorRules;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getValidatorRules() {
        return validatorRules+"|";
    }
}
