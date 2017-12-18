package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.ValidatorException;
import com.Tunes_Developers.Models.ValidationData;
import com.Tunes_Developers.Models.ValidatorItem;
import com.Tunes_Developers.Models.ValidatorRule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class Validator {
    public static List<String> validate(List<ValidatorItem> items) throws Exception {
        List<String> messages = new ArrayList<>();

        for (ValidatorItem item : items) {
            String message = decodeAndExecute(item,items);
            if (message != null) {
                messages.add(message);
            }
        }

        return messages;
    }

    public static String decodeAndExecute(ValidatorItem vItem,List<ValidatorItem> items) throws Exception {
        List<ValidatorRule> rules = decodeRule(vItem);
        String messages = null;

        for (ValidatorRule vr : rules) {
            ValidationData vd = ValidatorDecoder.decodeAndExecuteRule(vr,items);
            if (!vd.isTrue()) {
                messages = vd.getMessage();
                break;
            }
        }

        return messages;
    }

    private static List<ValidatorRule> decodeRule(ValidatorItem vItem) {
        List<ValidatorRule> rules = new ArrayList<>();

        Pattern pattern = Pattern.compile("(.*?)\\|");
        Matcher matcher = pattern.matcher(vItem.getValidatorRules());

        while (matcher.find()) {
            String rule = matcher.group();
            String name = rule.substring(0,rule.lastIndexOf('|'));

            if (rule.contains(":")) {
                int colon = name.indexOf(':');
                String parameter = name.substring(colon+1)+",";
                name = name.substring(0,colon);
                List<String> parameters = new ArrayList<>();

                Pattern pattern1 = Pattern.compile("(.*?)\\,");
                Matcher matcher1 = pattern1.matcher(parameter);

                while (matcher1.find()) {
                    String param = matcher1.group();
                    param = param.substring(0,param.length()-1);
                    parameters.add(param);
                }

                rules.add(new ValidatorRule(vItem.getName(),name,parameters,vItem.getData()));
            } else {
                rules.add(new ValidatorRule(vItem.getName(),name, vItem.getData()));
            }
        }

        return rules;
    }
}
