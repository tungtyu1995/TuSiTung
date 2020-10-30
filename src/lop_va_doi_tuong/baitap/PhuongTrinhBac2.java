package lop_va_doi_tuong.baitap;

import java.util.Scanner;

public class PhuongTrinhBac2 {
   public class QuadraticEquation {
        double a, b, c;

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public void setA(double a) {
            this.a = a;
        }

        public void setB(double b) {
            this.b = b;
        }

        public void setC(double c) {
            this.c = c;
        }

        double getDenTa() {
            return (b * b) - (4 * a * c);
        }

        double getNghiem1() {
            return (-b + Math.sqrt(this.getDenTa())) / (2 * a);
        }

        double getNghiem2() {
            return (-b - Math.sqrt(this.getDenTa())) / (2 * a);
        }
    }

   public void main1(double a, double b, double c) {
       QuadraticEquation obj = new QuadraticEquation();
       obj.setA(a);
       obj.setB(b);
       obj.setC(c);
       double delta = obj.getDenTa();
       if (a != 0) {
           if (delta > 0) {
               System.out.println("Nghiem thu 1:" + obj.getNghiem1());
               System.out.println("Nghiem thu 2:" + obj.getNghiem2());
           } else if (delta == 0) {
               System.out.println("Nghiem duy nhat:" + obj.getNghiem1());
           } else if (delta < 0) {
               System.out.println("Phuong trinh vo nghiem!!");
           }
       }else {
           System.out.println("Ban phai nhap a khac 0!!!");
       }
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a:");
        double a = sc.nextDouble();
        System.out.print("Nhap b:");
        double b = sc.nextDouble();
        System.out.print("Nhap c:");
        double c = sc.nextDouble();
        PhuongTrinhBac2 ptb2 = new PhuongTrinhBac2();
        ptb2.main1(a, b, c);
    }

}



