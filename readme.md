# Validator
Validator is a java api that equiped with validation rules to validate your data. It is comonly used in a Graphic User Interface where you need to validate input data from various fields in the User Interface.

Validating each field by itself can be very cumbersome and repetative and some times the warning and error messages returned to the users from validation rules can be the same. The validator api provides this functionality out of the box. You can validate multiple fields instantly and get warnings where these validation rules are not met.

## Table Of Contents
- [Instalation]
- [Basic Usage]
    - [Validation Rule]
        + [Rule Parameters]
        + [Chaining Validation Rules]
    - [Validating Multiple Items]
        + [Validaor Item]
    - [Validate Fields]
- [Available Rules]
- [Validate Class]

## Installation
Download the jar file from maven and add it to your project dependencies.

## Basic Usage
We are going to look at some of the basic functionalities and convenctions that make the validator api work efficiently.

## Validation Rule
A validation rule to be checked on a validation data. An example is email; a rule that checks if the provided data is an valid email. Rules are always written in small caps and if a rule contains more than one word, each word is seperated by an underscore e.g. `alpha_dashed`.

### Rule Parameters
Some rules contain parameters e.g. `max_char`. To define parameters in a rule you provide a colon immediately after the rule and then provide your parameter e.g. `max_char:20` - It takes one parameter and should be an integer, if one of the conditions is not met the parser will throw a MissingParameterException or an IncorrectParameterException respectively.

Some rules take more than one parameter e.g. `char_between` takes two parameters and `in` takes an infinate number of parameters. Parameters are seperated by a comma e.g. `char_between:10,40` or `in:banana,mango,grapes,orange,strawberry`. 

### Chaining Validation Rules
Validation rules can be chained together so that a field can be checked if it matches a number of rules. For rules to be chained together, they have to be seperated by `|` symbol. Below is an example.
```java
    String rules = "required|alpha_email|char_between:10,70|email";
```

The example above demonstrates how to chain validation rules. During the execution of rules the validation parser will start to validate an item from the first rule to the last rule. In our case the validator will begin at `required` rule and make sure that the provided item is not empty then move to the `alpha_email` rule to confirm that the item is only made up of alphabetic characters, integer values and symbols that are common in an email it will then move to the `char_between:10,70` to confirm that the item has a minimum of 10 characters and a maximum of 70 characters and finaly move to the `email` rule to confirm that the item is a valid email.

When the validation parser encounters a rule that has not been met, it will stop execution and return a warning message for that validation item. Generally, when writing validation rules it is a good practice to chain the rules as you would write them when validating an item i.e. Begin from the basic rule you want met to the most important rule or to the rule that consumes a greater execution time. e.g. Rules that confirm if an item exists in the database should always be the last ones to be executed, because they have a larger execution time.

## Validate Multiple Items
The validator api can be used to validate multiple fields at a go.

### Validator Item
For you to validate multiple fields together you will need multiple validation items. A validation item is an object that contains the name of the item you are validating, the data contained in this item and the rules you wish to check. Below are the roles played by each attribute

Item Name - It is used when returning warning messages.
Item Data - Contains data is to be validated using validation rules.
Validation rules- Contains rules that are applied on item data.

Below is an example of a validation item
```java
    ValidationItem items = new ValidationItem(
            "email","wanjiru.daisy@hotmail.com",
                    "required|char_between:150,10|email"
        );
```

To be able to validate multiple items at a go the `Validator.validate()` method is called which takes a List of ValidationItems. Below is an example of how its done.

```java
package com.Tunes_Developers.tests;

import com.Tunes_Developers.Validator;
import com.Tunes_Developers.Models.ValidatorItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ValidateData {
    public static void main(String[] args) throws Exception {
        List<String> messages = Validator.validate(
            // Define validation rule
            FXCollections.observableArrayList(
                new ValidatorItem("username", "Daisy-Wanjiru",
                        "required|alpha_dash|max_char:30|min_char:5|unique:students,name"),
                new ValidatorItem("email","wanjiru.daisy@hotmail.com",
                        "required|char_between:150,10|email"),
                new ValidatorItem("ip address","127.300.0.1",
                        "required|ip"),
                new ValidatorItem("phone number","07",
                        "required_with_all:name,email|numeric|digits_between:10,150"),
                new ValidatorItem("password","secret",
                        "required|alpha_dash|char_between:5,20"),
                new ValidatorItem("password confirmation","password",
                        "required_with:password|same:password")
                )
        );

        //Print out messages
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
```

The above example validates each item and returns a warning message for each item if a rule is not matched. The absence of an warning message with for a specific item, means that that item valid. There can only be one warning message for a specific item.

If List for warning messages is empty, it means that all the items validated are valid.

## Available Rules