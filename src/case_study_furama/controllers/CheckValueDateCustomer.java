package case_study_furama.controllers;

import case_study_furama.commons.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckValueDateCustomer {
    private static final String NAME_CUSTOMER = "^([A-Z][a-z]{1,}[\\s])[A-Z][a-z]*(([\\s][A-Z][a-z]*){0,4})";
    private static final String EMAIL = "^[\\w]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private static final String ID_CUSTOMER = "[\\d]{9}";
    private static final String BIRTHDAY_CUSTOMER = "^([0-2][\\d]|[3][0-1])/(0[1-9]|10|11|12)/(19[\\d]{2}|200[1-5])$";
    static Scanner scanner = new Scanner(System.in);

    //check Name
    public static String checkNameCustomer() {
        try {
            System.out.print("Enter name customer :");
            String nameCustomer = scanner.nextLine();
            if (Pattern.compile(NAME_CUSTOMER).matcher(nameCustomer).matches()) {
                return nameCustomer;
            } else {
                throw new NameException("Name is not syntax");
            }
        } catch (NameException e) {
            System.out.println(e);
            return checkNameCustomer();
        }
    }

    //check Email
    public static String checkEmailCustomer() {
        try {
            System.out.print("Enter email customer : ");
            String mailCustomer = scanner.nextLine();
            if (Pattern.compile(EMAIL).matcher(mailCustomer).matches()) {
                return mailCustomer;
            } else {
                throw new EmailException("Mail is not syntax");
            }
        } catch (EmailException e) {
            System.out.println(e);
            return checkEmailCustomer();
        }
    }

    //check Gender
    public static String checkGender() {
        try {
            System.out.print("Enter gender customer : ");
            String genderCustomer = scanner.nextLine();
            String genderTemp = genderCustomer.toLowerCase();
            if (genderTemp.equals("male")) {
                return "Male";
            } else if (genderTemp.equals("female")) {
                return "Female";
            } else if (genderTemp.equals("unknown")) {
                return "Unknown";
            } else {
                throw new GenderException("Input not right");
            }
        } catch (GenderException e) {
            System.out.println(e);
            return checkGender();
        }
    }

    //check Id
    public static String checkIdCustomer() {
        try {
            System.out.print("Enter id customer : ");
            String idCustomer = scanner.nextLine();
            if (Pattern.compile(ID_CUSTOMER).matcher(idCustomer).matches()) {
                return idCustomer;
            } else {
                throw new IdException("Id  must be nice number ");
            }
        } catch (IdException e) {
            System.out.println(e);
            return checkIdCustomer();
        }
    }

    //check DayOfBirth
    public static String checkDayOfBirthCustomer() {
        System.out.print("Enter birthday customer : ");
        try {
            String dayOfBirth = scanner.nextLine();
            if (Pattern.compile(BIRTHDAY_CUSTOMER).matcher(dayOfBirth).matches()) {
                return dayOfBirth;
            } else {
                throw new BirthdayException("Input must be DD/MM/YYYY");
            }
        } catch (BirthdayException e) {
            System.out.println(e);
            return checkDayOfBirthCustomer();
        }
    }
}
