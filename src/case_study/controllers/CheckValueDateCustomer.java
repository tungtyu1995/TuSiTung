package case_study.controllers;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckValueDateCustomer {
    private static final String NAME_CUSTOMER = "^([A-Z][a-z]{1,}[\\s])[A-Z][a-z]*(([\\s][A-Z][a-z]*){0,4})";
    private static final String EMAIL = "^[\\w]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private static final String ID_CUSTOMER = "[\\d]{9}";
    private static final String BIRTHDAY_CUSTOMER = "^([0-2][\\d]|[3][0-1])/(0[1-9]|10|11|12)/(19[\\d]{2}|200[1-5])$";
    static Scanner scanner = new Scanner(System.in);

    public static String checkNameCustomer() {
        String nameCustomer = scanner.nextLine();
        if (Pattern.compile(NAME_CUSTOMER).matcher(nameCustomer).matches()) {
            return nameCustomer;
        } else {
            System.out.println("Wrong Name");
            return checkNameCustomer();
        }
    }

    public static String checkEmailCustomer() {
        String mailCustomer = scanner.nextLine();
        if (Pattern.compile(EMAIL).matcher(mailCustomer).matches()) {
            return mailCustomer;
        } else {
            System.out.println("Wrong Name");
            return checkEmailCustomer();
        }
    }

    public static String checkGender() {

        String genderCustomer = scanner.nextLine().toLowerCase();
        if (genderCustomer.equals("male")) {
            return "Male";
        } else if (genderCustomer.equals("female")) {
            return "Female";

        } else if (genderCustomer.equals("unknown")) {
            return "Unknown";
        } else
            System.out.println("Wrong gender");
        return checkGender();
    }

    public static String checkIdCustomer() {
        String idCustomer = scanner.nextLine();
        if (Pattern.compile(ID_CUSTOMER).matcher(idCustomer).matches()) {
            return idCustomer;
        } else {
            System.out.println("Wrong Id");
            return checkIdCustomer();
        }
    }
    public static String checkDayOfBirthCustomer(){
        String dayOfBirth = scanner.nextLine();
        if (Pattern.compile(BIRTHDAY_CUSTOMER).matcher(dayOfBirth).matches()) {
            return dayOfBirth;
        } else {
            System.out.println("Wrong Birthday");
            return checkDayOfBirthCustomer();
        }
    }
}
