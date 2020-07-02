package lop_va_doi_tuong.thuchanh;


import java.util.Scanner;
class HinhChuNhat {
    double width, height;

    public HinhChuNhat(double width, double height) {
        this.width = width;
        this.height = height;

    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
public class LopHinhChuNHat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai:");
        double width = scanner.nextDouble();
        System.out.print("Nhap chieu rong:");
        double height = scanner.nextDouble();
        HinhChuNhat rectangle = new HinhChuNhat(width, height);
        System.out.println("Hinh chu nhat co: \n" + rectangle.display());
        System.out.println("Chu vi hinh chu nhat: " + rectangle.getPerimeter());
        System.out.println("Dien tich hinh chu nhat: " + rectangle.getArea());
    }
}


