package vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class TimUocChungLonNhat {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số a");
        a = scanner.nextInt();
        System.out.println("Nhập vào số b");
        b = scanner.nextInt();
        if (a == 0 || b == 0)
            System.out.println("Hai số không có ước chung lớn nhất");
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }

        }
        System.out.println("Greatest common factor: " + a);
    }
}
