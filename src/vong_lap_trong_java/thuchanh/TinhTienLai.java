package vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class TinhTienLai {
    public static void main(String[] args) {
        double tienGui = 1.0;
        double laiSuat = 1.0;
        int thang = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số tiền gửi");
        tienGui = scanner.nextDouble();
        System.out.println("Nhập vào lãi suất");
        laiSuat = scanner.nextDouble();
        System.out.println("Nhập vào số tháng gửi tiền");
        thang = scanner.nextInt();
        double tongTienLai = 0;

        tongTienLai = tienGui * ((laiSuat / 100) / 12) * thang;

        System.out.println("Tổng số tiền lãi: " + tongTienLai);
    }
}
