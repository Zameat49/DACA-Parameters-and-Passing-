// YOUR NAME: 
// COLLABORATORS: 
// DATE: 
import jdk.jshell.execution.Util;

import java.util.Scanner;
public class Main {
    //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
    static final String ASCII_ART_0 = "    .----.    .----.  ",
            ASCII_ART_1 = "   (  --  \\  /  --  )",
            ASCII_ART_2 = "          |  |        ",
            ASCII_ART_3 = "         _/  \\_      ",
            ASCII_ART_4 = "        (_    _)      ",
            ASCII_ART_5 = "     ,    `--`    ,   ",
            ASCII_ART_6 = "     \\'-.______.-'/  ",
            ASCII_ART_7 = "      \\          /   ",
            ASCII_ART_8 = "       '.--..--.'     ",
            ASCII_ART_9 = "         `\"\"\"\"\"` ",
            ASCII_CREDIT = "   ascii art by: jgs    ";

    static final String TITLE_USA = "UNITED STATES OF AMERICA",
            TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
    static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
            LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
            LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
            LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
            LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";

    public static void main(String[] args) {
        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        surname = UtilityBelt.readString("Enter surname: ", 1 , 50);
        givenName = UtilityBelt.readString("Enter given name: ", 1 , 50);
        uscisNum1 = UtilityBelt.readInt("Enter USCIS number 1: ", 0 , 999);
        uscisNum2 = UtilityBelt.readInt("Enter USCIS number 2: ", 0 , 999);
        uscisNum3 = UtilityBelt.readInt("Enter USCIS number 3: ", 0 , 999);
        category = UtilityBelt.readString("Enter Category: ", 1 , 3);
        cardNum = UtilityBelt.readString("Enter Card Number: SRC", 1 , 10);
        birthCountry = UtilityBelt.readString("Enter birth country: ", 1 , 100);
        termsAndConditions = UtilityBelt.readString("Enter Terms and Conditions: ",1 , 50);

        birthDay = UtilityBelt.readInt("Enter day of Birth: ", 1, 31);
        birthMonth = UtilityBelt.readString("Enter Month of Birth: ", 3 , 3);
        birthYear = UtilityBelt.readInt("Enter year of Birth: ", 1 , 2026);

        sex = UtilityBelt.readChar("Enter sex: ", "M F"); //note single quotes

        validMonth = UtilityBelt.readInt("Enter valid Month: ", 1 , 12);
        validDay = UtilityBelt.readInt("Enter valid Day: ", 1 , 31);
        validYear = UtilityBelt.readInt("Enter valid Year: ", 2020 , 2026);

        expireMonth = UtilityBelt.readInt("Enter Month of Expiration: ", 1 , 12);
        expireDay = UtilityBelt.readInt("Enter Day of Expiration: ", 1 , 31);
        expireYear = UtilityBelt.readInt("Enter Year of Expiration: ", 2020, 3000);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        validDate = Main.formatDate(validMonth, validDay, validYear);
        expireDate = Main.formatDate(expireMonth, expireDay, expireYear);


        //INPUT + CALCULATION SECTION
        //N/A

        //OUTPUT SECTION

        System.out.println(Main.formatCard(surname, givenName,
                category, cardNum, birthCountry,
                termsAndConditions, sex, uscisNum,
                dateOfBirth, validDate, expireDate));
    }

    // Method used for the basic card formatting
    public static String formatCard(String surname, String givenName,
                                    String category, String cardNum, String birthCountry,
                                    String termsAndConditions, char sex, String uscisNum,
                                    String dateOfBirth, String validDate, String expireDate) {

        String card;

        card = String.format("╔══════════════════════════════════════════════════════════════════════╗%n");
        card += String.format("║%35s%35s║%n", TITLE_USA, "");
        card += String.format("║%60s%10s║%n", TITLE_EAC, "");
        card += String.format("║%-25s%-45s║%n", "", LABEL_SURNAME);
        card += String.format("║%-25s%-45s║%n", "", surname);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName);
        card += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM);
        card += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions);
        card += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX);
        card += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex);
        card += String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate);
        card += String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate);
        card += String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
        card += String.format("╚══════════════════════════════════════════════════════════════════════╝%n");

        return card;

    }

    public static String formatDate(int month, int day, int year) {
        return String.format("%02d/%02d/%4d", day, month, year);
    }

}

