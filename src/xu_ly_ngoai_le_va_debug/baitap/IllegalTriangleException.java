package xu_ly_ngoai_le_va_debug.baitap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException {
    public static void checkTheTriangle(int c1, int c2, int c3) throws IllegalArgumentException {

        if (c1 < 0 || c2 < 0 || c3 < 0) {
            throw new IllegalArgumentException ("Canh tam giac phai la so duong");
        }
        if (c1 + c2 <= c3 || c1 + c3 <= c2 || c2 + c3 <= c1) {
            throw new IllegalArgumentException ("Tong 2 canh phai lon hon canh con lai");
        }
        int p = c1 + c2 + c3;
        System.out.println("chu vi hinh tam giac: " + p);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap vao canh thu nhat: ");
            int c1 = scanner.nextInt();
            System.out.print("Nhap vao canh thu hai: ");
            int c2 = scanner.nextInt();
            System.out.print("Nhap vao canh thu ba: ");
            int c3 = scanner.nextInt();
            checkTheTriangle(c1,c2,c3);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Phai nhap vao so");
        }
    }
}
