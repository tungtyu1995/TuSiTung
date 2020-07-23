package io_binaryfile_serialization.baitap.quan_li_san_pham_nhiphan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add New Product");
            System.out.println("2. Show Information");
            System.out.println("3. Search Information");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    ProductManage.addProduct();
                    break;
                case 2:
                    ProductManage.displayProduct();
                    break;
                case 3:
                    ProductManage.seachProduct();
                    break;
                case 4:
                    ProductManage.writeFile();
                    ProductManage.readFile();
                    System.exit(0);
                default:
                    System.out.println("Invalid value !!!");
            }
        }
    }

}
