package com.Tunes_Developers.tests;

import com.Tunes_Developers.Validator;
import com.Tunes_Developers.Models.ValidatorItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class TestValidator {
    public static void main(String[] args) throws Exception {
        List<ValidatorItem> items = new ArrayList<ValidatorItem>(){};
        items.add(new ValidatorItem("name", "Geoffrey Kimani","alphaDash|maxChar:10|minChar:5"));
        items.add(new ValidatorItem("email","geoffreykariithi@hotmail","maxChar:150|minChar:10|email"));

        List<String> messages = Validator.validate(items);

        for (String message : messages) {
            System.out.println(message);
        }
    }
}
