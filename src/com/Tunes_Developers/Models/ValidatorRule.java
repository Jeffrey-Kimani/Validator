package com.Tunes_Developers.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class ValidatorRule {
    String field;
    String name;
    List<String> parameters = null;
    String data;

    public ValidatorRule(String field, String name, String data) {
        this.field = field;
        this.name = name;
        this.data = data;
    }

    public ValidatorRule(String field, String name, List<String> parameters, String data) {
        this.field = field;
        this.name = name;
        this.parameters = parameters;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
