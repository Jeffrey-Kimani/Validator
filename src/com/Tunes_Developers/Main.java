package com.Tunes_Developers;

import com.Tunes_Developers.Fake.Faker;

public class Main {

    public static void main(String[] args) throws Exception {
        Faker faker = new Faker("en_US");
        String ip = faker.ipv4();

//        System.out.println(Validate.alpha("Makena")+"  "+Validate.alpha("King'ori"));
//        System.out.println(Validate.alphaSpaced("Makena Waithera")+"  "+Validate.alpha("King'ori"));
//        System.out.println(Validate.alphaNumeric("Geoffrey003")+"  "+Validate.alphaNumeric("Makena-003"));
//        System.out.println(Validate.alphaDash("Makena-003")+"  "+Validate.alphaDash("capale_omondi%"));
//        System.out.println(Validate.numeric("0908398098209823948809182")+"  "+Validate.numericFormatted("(87) 328-8723"));

//        System.out.println(ip+":  "+Validate.ipv4(ip));
//
//        String dateNow = faker.dateNow();
//        String dateOld = faker.date();
//
//        System.out.println(dateNow+" "+dateOld+" Date Now > date Old "+Validate.isAfterDate(dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Now < date Old "+Validate.isBeforeDate(dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Old > date Now "+Validate.isAfterDate(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old < date Now "+Validate.isBeforeDate(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Now "+Validate.isEqualToDate(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Old "+Validate.isEqualToDate(dateOld,dateOld));
//
//        dateNow = faker.dateTimeNow();
//        dateOld = faker.dateTime();
//
//        System.out.println(dateNow+" "+dateOld+" Date Now > date Old "+Validate.isAfterDateTime(dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Now < date Old "+Validate.isBeforeDateTime(dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Old > date Now "+Validate.isAfterDateTime(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old < date Now "+Validate.isBeforeDateTime(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Now "+Validate.isEqualToDateTime(dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Old "+Validate.isEqualToDateTime(dateOld,dateOld));
//
//        dateNow = "15-06-2017";
//        dateOld = "14-02-1935";
//
//        System.out.println(dateNow+" "+dateOld+" Date Now > date Old "+Validate.isAfterDate("dd-mm-yyyy",dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Now < date Old "+Validate.isBeforeDate("dd-mm-yyyy",dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Old > date Now "+Validate.isAfterDate("dd-mm-yyyy",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old < date Now "+Validate.isBeforeDate("dd-mm-yyyy",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Now "+Validate.isEqualToDate("dd-mm-yyyy",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Old "+Validate.isEqualToDate("dd-mm-yyyy",dateOld,dateOld));
//
//        dateNow = "15-06-2017 15:52";
//        dateOld = "14-02-1935 17:39";
//
//        System.out.println(dateNow+" "+dateOld+" Date Now > date Old "+Validate.isAfterDateTime("dd-mm-yyyy","hh:mm",dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Now < date Old "+Validate.isBeforeDateTime("dd-mm-yyyy","hh:mm",dateOld,dateNow));
//        System.out.println(dateNow+" "+dateOld+" Date Old > date Now "+Validate.isAfterDateTime("dd-mm-yyyy","hh:mm",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old < date Now "+Validate.isBeforeDateTime("dd-mm-yyyy","hh:mm",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Now "+Validate.isEqualToDateTime("dd-mm-yyyy","hh:mm",dateNow,dateOld));
//        System.out.println(dateNow+" "+dateOld+" Date Old = date Old "+Validate.isEqualToDateTime("dd-mm-yyyy","hh:mm",dateOld,dateOld));

//        System.out.println(Validate.isEmpty("           ")+"-----------"+Validate.isEmpty("               d")+"-----------"+
//                Validate.isEmpty("Hello")+"------------"+Validate.isEmpty(""));
//        System.out.println(Validate.charBetween(4,8,"Geoffrey"));
//        System.out.println(Validate.digitsBetween(2,6,"897y"));
//        System.out.println(Validate.exists("students","name","Daisy"));
//        System.out.println(Validate.in(new String[]{"apple","pineapple","avocado","pears","passion","banana"},"banana"));
//        System.out.println(Validate.notIn(new String[]{"apple","pineapple","avocado","pears","passion","banana"},"apple"));
        System.out.println(Validate.email("johndoe@examaple.com"));
    }
}
