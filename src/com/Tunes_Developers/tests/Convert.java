package com.Tunes_Developers.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/20/2017.
 */
public class Convert {
    public static void main(String[] args) {
        String equation =  "w*(x+y)/z";

        char[] equationAray = equation.toCharArray();
        char[] symbols = {'+','-','/','*','%',};
        List<String> variables = new ArrayList<>();
        List<String> foundSymbols = new ArrayList<>();

        for (char c : equationAray) {
            if (c != '(' && c != ')') {
                if (isSymbol(c, symbols)) {
                    foundSymbols.add(c+"");
                }else{
                    variables.add(c+"");
                }
            }
        }

        String postFixEquation = "";
        for (String s : variables) {
            postFixEquation+=s;
        }

        postFixEquation+="  ";

        for (String s : foundSymbols) {
            postFixEquation+=s;
        }

        System.out.println(postFixEquation);
     }

    public static boolean isSymbol(char c, char[] symbols) {
        for (char oneChar : symbols) {
            if (oneChar == c) {
                return true;
            }
        }

        return false;
    }
}
