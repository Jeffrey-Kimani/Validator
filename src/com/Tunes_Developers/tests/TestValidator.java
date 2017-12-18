package com.Tunes_Developers.tests;

import com.Tunes_Developers.Validator;
import com.Tunes_Developers.Models.ValidatorItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class TestValidator {
    public static void main(String[] args) throws Exception {
        ObservableList<ValidatorItem> items = FXCollections.observableArrayList(
                new ValidatorItem("name", "Daisy Wanjiru",
                        "required|alpha_space|max_char:30|min_char:5|unique:students,name"),
                new ValidatorItem("email","geoffreykariithi@hotmail.com",
                        "required|max_char:150|min_char:10|email"),
                new ValidatorItem("ip address","127.300.0.1",
                        "required|ip"),
                new ValidatorItem("phone number","07",
                        "required_with_all:name,email|numeric|digits_between:10,150"),
                new ValidatorItem("password","secret",
                        "required|alpha_dash|char_between:5,20"),
                new ValidatorItem("password_confirmation","secre",
                        "required_with:password|same:password"),
                new ValidatorItem("date","2017-12-26",
                        "required|after_date:2017-12-12|before_date:2017-12-25|equal_to_date:2017-12-14"),
                new ValidatorItem("datetime","2017-12-12 03:17:36",
                        "required|after_date_time:2017-12-12 05:17:36|before_date_time:2017-12-12 16:17:36|equal_to_date_time:2017-12-12 08:17:32"),
                new ValidatorItem("fruit","water melon",
                        "required_with:name,email|not_in:mango,grapes,apple,peach,water melon,banana")
        );

        List<String> messages = Validator.validate(items);

        for (String message : messages) {
            System.out.println(message);
        }
    }
}
