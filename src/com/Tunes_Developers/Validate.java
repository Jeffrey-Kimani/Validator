package com.Tunes_Developers;

import com.Tunes_Developers.PolenException.PolenException;

import java.sql.ResultSet;

/**
 * Created by Geoffrey-Kimani on 6/13/2017.
 */
public class Validate {
    private static Pollen pollen = new Pollen();

    public static boolean alpha(String data) {
        data = data.toLowerCase();
        char[] alpha = {
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (_data[i] == alpha[j]) {
                    break;
                }
                if (j == alpha.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean alphaSpaced(String data) {
        data = data.toLowerCase();
        char[] alphaSpaced = {
                ' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < alphaSpaced.length; j++) {
                if (_data[i] == alphaSpaced[j]) {
                    break;
                }
                if (j == alphaSpaced.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean alphaNumeric(String data) {
        data = data.toLowerCase();
        char[] alphaNumeric = {
                '1','2','3','4','5','6','7','8','9','0',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < alphaNumeric.length; j++) {
                if (_data[i] == alphaNumeric[j]) {
                    break;
                }
                if (j == alphaNumeric.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean alphaDash(String data) {
        data = data.toLowerCase();
        char[] alphaDash = {
                '-','_','1','2','3','4','5','6','7','8','9','0',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < alphaDash.length; j++) {
                if (_data[i] == alphaDash[j]) {
                    break;
                }
                if (j == alphaDash.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean alphaEmail(String data) {
        char[] alphaDash = {
                '-','_','.','@','1','2','3','4','5','6','7','8','9','0',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < alphaDash.length; j++) {
                if (_data[i] == alphaDash[j]) {
                    break;
                }
                if (j == alphaDash.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean numeric(String data) {
        char[] numeric = {
                '1','2','3','4','5','6','7','8','9','0'
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < numeric.length; j++) {
                if (_data[i] == numeric[j]) {
                    break;
                }
                if (j == numeric.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean numericFormatted(String data) {
        char[] numericFormatted = {
                '1','2','3','4','5','6','7','8','9','0','-','(',')',' '
        };
        char[] _data = data.toCharArray();
        boolean results = false;

        for (int i = 0; i < _data.length; i++) {
            for (int j = 0; j < numericFormatted.length; j++) {
                if (_data[i] == numericFormatted[j]) {
                    break;
                }
                if (j == numericFormatted.length - 1) {
                    return results;
                }
            }
            if (i == _data.length-1) {
                results = true;
            }
        }
        return results;
    }

    public static boolean ipv4(String data) {
        char[] _data = data.toCharArray();
        int dotPositions [] = new int[3];
        int numberDots = 0;
        for (int i=0; i<_data.length; i++) {
            if (_data[i] == '.') {
                dotPositions[numberDots] = i;
                numberDots++;
            }
            if (_data[i] == _data.length - 1 && numberDots != 4) {
                return false;
            }
        }

        for (int i=0;i<dotPositions.length;i++) {
            int ipNumber;
            if (i == 0) {
                ipNumber = Integer.parseInt(data.substring(0, dotPositions[i]));
            } else {
                ipNumber = Integer.parseInt(data.substring(dotPositions[i - 1]+1, dotPositions[i]));
            }
            if (i == 2) {
                ipNumber = Integer.parseInt(data.substring(dotPositions[2]+1,data.length()));
            }

            if (i == dotPositions.length - 1) {
                if (ipNumber< 1 || ipNumber > 255) {
                    return false;
                }
            }else{
                if (ipNumber< 0 || ipNumber > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBeforeDateTime(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateTime(baseDate);
            test = pollen.isBeforeDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isAfterDateTime(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateTime(baseDate);
            test = pollen.isAfterDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isEqualToDateTime(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateTime(baseDate);
            test = pollen.isEqualToDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isBeforeDateTime(String dateFormat,String timeFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setTimeFormat(timeFormat);
            pollen.setDateTime(baseDate);
            test = pollen.isBeforeDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isAfterDateTime(String dateFormat,String timeFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setTimeFormat(timeFormat);
            pollen.setDateTime(baseDate);
            test = pollen.isAfterDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isEqualToDateTime(String dateFormat,String timeFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setTimeFormat(timeFormat);
            pollen.setDateTime(baseDate);
            test = pollen.isEqualToDateTime(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isBeforeDate(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDate(baseDate);
            test = pollen.isBeforeDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isAfterDate(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDate(baseDate);
            test = pollen.isAfterDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isEqualToDate(String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDate(baseDate);
            test = pollen.isEqualToDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isBeforeDate(String dateFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setDate(baseDate);
            test = pollen.isBeforeDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isAfterDate(String dateFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setDate(baseDate);
            test = pollen.isAfterDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isEqualToDate(String dateFormat,String baseDate, String testDate) {
        boolean test = false;
        try {
            pollen.setDateFormat(dateFormat);
            pollen.setDate(baseDate);
            test = pollen.isEqualToDate(testDate);
        } catch (PolenException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static boolean isEmpty(String data) {
        if (data.length() == 0) {
            return true;
        } else {
            char [] _data = data.toCharArray();

            for (int i = 0; i < _data.length; i++) {
                if (_data[i] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean maxChar(int maxCharacters, String data) {
        if (data.length() >= maxCharacters) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean minChar(int minChracters, String data) {
        if (data.length() <= minChracters) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean charBetween(int minCharacters, int maxCharacters, String data) {
        if (data.length() >= minCharacters && data.length() <= maxCharacters) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean digitsBetween(int nbMinDigits, int nbMaxDigits, String data) {
        if (numeric(data)) {
            if (data.length() >= nbMinDigits && data.length() <= nbMaxDigits) {
                return true;
            }
        }
        return false;
    }

    public static boolean exists(String table, String column, String data) throws Exception {
        ResultSet rs = DB.table(table).where(column,data).get();
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public static boolean unique(String table, String column, String data) throws Exception {
        ResultSet rs = DB.table(table).where(column,data).get();
        while (rs.next()) {
            return false;
        }
        return true;
    }

    public static boolean in(String [] items, String data) {
        for (String item : items) {
            if (item.equals(data)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notIn(String [] items, String data) {
        for (int i=0;i<items.length;i++) {
            if (items[i].equals(data)) {
                return false;
            }
        }
        return true;
    }

    public static boolean same(String test, String data) {
        if (test.equals(data)) {
            return true;
        }
        return false;
    }

    public static boolean email(String data) {
        data = data.toLowerCase();
        if (data.contains("@")) {
            int atPosition = data.indexOf('@');
            String domain = data.substring(atPosition+1);

            if (alphaEmail(data) && domain.contains(".")) {
                return true;
            }
        }
        return false;
    }
}
