package introduction_to_java.bai_tap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên của bạn");
        String name = scanner.nextLine();
        System.out.print("Chào " + name);
    }
}
