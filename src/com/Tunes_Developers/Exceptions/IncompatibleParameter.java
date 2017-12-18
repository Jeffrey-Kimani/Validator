package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class IncompatibleParameter extends ValidatorException {
    public IncompatibleParameter(String rule, String field,String parameter) {
        super("The parameter: "+parameter+" provided for the rule: "+rule+" in the field: "+field+" is of an incompatible format");
    }
}
