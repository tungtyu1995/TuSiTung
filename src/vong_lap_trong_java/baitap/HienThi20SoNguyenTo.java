package vong_lap_trong_java.baitap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        int number;
        String stringNumber = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố cần in ra");
        number = scanner.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                stringNumber += n + ",";
                count++;
            }
            n++;
        }
        System.out.println(number+" Số nguyên tố đầu tiên là : "+ stringNumber);
    }
}
