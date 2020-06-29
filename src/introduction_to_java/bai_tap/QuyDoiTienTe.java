package introduction_to_java.bai_tap;

import java.util.Scanner;

public class QuyDoiTienTe {
    public static void main(String[] args) {
        int usd;
        int vnd = 23000;
        int quyDoi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số tiền USD cần quy đổi");
        usd = scanner.nextInt();
        quyDoi = usd * vnd;
        System.out.println(usd + " USD " + " bằng " + quyDoi + " VND ");
    }
}
