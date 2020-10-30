package string_regex.baitap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
    public static final String REGEX_CLASS_NAME = "^[CAP]\\d{4}[GHIKLM]$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Nhap vao ten lop: ");
        String phoneNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile(REGEX_CLASS_NAME);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            System.out.println("OK");
        } else {
            System.out.println("NG");
        }
    }
}
