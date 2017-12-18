package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class MissingParameter extends ValidatorException{
    public MissingParameter(String rule, String field) {
        super("The rule: "+rule+" in the field: "+field+" is missing a parameter");
    }
}
