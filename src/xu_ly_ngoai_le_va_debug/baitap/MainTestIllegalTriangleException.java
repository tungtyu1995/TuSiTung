package xu_ly_ngoai_le_va_debug.baitap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTestIllegalTriangleException {
    public static void CalculateTheCircumference(int c1,int c2,int c3){
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
            TestIllegalTriangleException.checkTheTriangle(c1,c2,c3);
            CalculateTheCircumference(c1,c2,c3);
        } catch (InputMismatchException e) {
            System.out.println("Phai nhap vao so");
        } catch (TestIllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}

