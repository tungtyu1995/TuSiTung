package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraChiSoCanNang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double canNang, chieuCao, bmi;
        System.out.println("Nhập vào chỉ số cân nặng (kg)");
        canNang = scanner.nextDouble();
        System.out.println("Nhập vào chỉ số chiều cao (m)");
        chieuCao = scanner.nextDouble();
        bmi = canNang / Math.pow(chieuCao, 2);

        if (bmi < 18)
            System.out.print(bmi + " Thiếu cân ");
        else if (bmi < 25.0)
            System.out.print(bmi + " Vừa đẹp ");
        else if (bmi < 30.0)
            System.out.print(bmi + " Hơi thừa cân ");
        else
            System.out.print(bmi + " Béo như heo ");

    }
}
