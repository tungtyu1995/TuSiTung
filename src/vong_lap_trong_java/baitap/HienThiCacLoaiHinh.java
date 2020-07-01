package vong_lap_trong_java.baitap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println(" Menu ");
            System.out.println("1. Vẽ hình chữ nhật");
            System.out.println("2. Vẽ hình tam giác");
            System.out.println("3. Vẽ hình tam giác");
            System.out.println("4. Vẽ hình tam giác cân");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        System.out.println();
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        System.out.println();
                        for (int j = 0; j < i; j++) {
                            System.out.print("* ");
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    for (int i = 5; i > 0; i--) {
                        System.out.println();
                        for (int j = 0; j < i; j++) {
                            System.out.print("* ");
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    for (int i=0; i<7; i++) {
                        for (int j=0; j < 7-i; j++) {
                            System.out.print(" ");
                        }
                        for (int j=7-i ; j<7 ; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Không có sự lựa chọn!");
            }
        }
    }
}