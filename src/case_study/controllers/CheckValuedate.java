package case_study.controllers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValuedate {
    private static final String VALUE_NAME_SERVICE = "^[A-Z]{2}([V][L]|[R][O]|[H][O])-[\\d]{4}$";
    private static final String VALUE_AREA = "^[3-9][\\d]|[1-9][\\d]{2,}$";
    private static final String VALUE_COST = "^[1-9]([\\d]*)$";
    private static final String VALUE_NUMBER_CUSTOMER = "^[1-9]|([1][\\d])|(20)$|0[\\d]$";
    private static final String VALUE_ENCLOSED = "^[3][\\d]|[1-9][\\d]{2,}$";
    private static final String VALUE_TYPE_RENT = "";
    //    private static final String  = "^[SV][VL|HO|RO][\\d]{4}$";
    static Scanner scanner = new Scanner(System.in);

    public static String checkNameService(String nameService) {

        Pattern pattern = Pattern.compile(VALUE_NAME_SERVICE);
        Matcher matcher = pattern.matcher(nameService);

        if (matcher.matches()) {
            return nameService;
        } else {
            System.out.println("Wrong name service");
            System.out.print("Enter name service again : ");
            String name = scanner.nextLine();
            return checkNameService(name);
        }
    }

    public static double checkArea() {
        String area = scanner.nextLine();

        if (Pattern.compile(VALUE_AREA).matcher(area).matches()) {
            return Double.parseDouble(area);
        } else {
            System.out.println("Wrong area");
            System.out.print("Enter area again : ");
            return checkArea();
        }
    }

    public static double checkCost() {
        String cost = scanner.nextLine();

        if (Pattern.compile(VALUE_COST).matcher(cost).matches()) {
            return Double.parseDouble(cost);
        } else {
            System.out.println("Wrong price");
            System.out.print("Enter again :");
            return checkCost();
        }

    }

    public static int checkFloor() {
        String cost = scanner.nextLine();

        if (Pattern.compile(VALUE_COST).matcher(cost).matches()) {
            return Integer.parseInt(cost);
        } else {
            System.out.println("Wrong price");
            System.out.print("Enter again :");
            return checkFloor();
        }

    }

    public static int maxCustomer(){
        String number = scanner.nextLine();

        if (Pattern.compile(VALUE_NUMBER_CUSTOMER).matcher(number).matches()) {
            return Integer.parseInt(number);
        }
        else {
            System.out.println("Wrong");
            System.out.print("Enter again : ");
            return maxCustomer();
        }
    }
}
