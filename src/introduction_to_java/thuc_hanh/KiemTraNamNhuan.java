package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Nhập vào năm cần kiểm tra: ");
        year = scanner.nextInt();
        boolean isLeapYear = false;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.print( year+" Là năm nhuận ");
        } else {
            System.out.print(year+ " Không phải là năm nhuận");
        }
    }
}
