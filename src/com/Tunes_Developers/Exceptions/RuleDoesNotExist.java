package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class RuleDoesNotExist extends ValidatorException {
    public RuleDoesNotExist(String rule, String field) {
        super("This rule: " + rule + " in the field: " + field + " does not exist");
    }
}
