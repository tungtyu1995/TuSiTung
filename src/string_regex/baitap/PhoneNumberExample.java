package string_regex.baitap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    public static final String REGEX_PHONE_NUMBER = "^\\d{2}-\\d{10}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Nhap vao so dien thoai: ");
        String phoneNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            System.out.println("OK");
        } else {
            System.out.println("NG");
        }
    }
}