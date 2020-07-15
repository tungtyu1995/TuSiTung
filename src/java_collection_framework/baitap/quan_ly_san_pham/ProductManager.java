package java_collection_framework.baitap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    //xoa san pham
    public static void deleteProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham:");
        int deleteID = scanner.nextInt();
        Product temp = null;
        boolean isExist = false;
        for (Product product : productArrayList) {
            if (product.getId() == deleteID) {
                temp = product;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            productArrayList.remove(temp);
            System.out.print("Xoa thanh cong!!!");
        } else {
            System.out.print("Id san pham khong ton tai !!!");
        }
        displayProduct(productArrayList);
    }

    //sua san pham
    public static void editProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham:");
        int editID = scanner.nextInt();

        boolean isExist = false;
        for (Product product : productArrayList) {
            if (product.getId() == editID) {
                System.out.println(product);
                System.out.print("nhap vao ten san pham: ");
                product.setName(scanner.nextLine());
                product.setName(scanner.nextLine());
                System.out.print("nhap vao gia san pham: ");
                product.setPrice(scanner.nextInt());
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("ID khong ton tai!!!");
        }
        displayProduct(productArrayList);
    }

    //them san pham
    public static void addProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap vao id san pham: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("nhap vao ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("nhap vao gia san pham: ");
        int price = scanner.nextInt();
        Product product = new Product(id, name, price);
        productArrayList.add(product);
        displayProduct(productArrayList);
    }

    //hien thi danh sach san pham
    public static void displayProduct(ArrayList<Product> productArrayList) {
        System.out.println("___Danh sach san pham___");
        for (Product prd : productArrayList) {
            System.out.println(prd);
        }

    }

    //tim san pham theo ten
    public static void searchProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham:");
        String nameSearch = scanner.nextLine();

        boolean isExist = false;
        for (Product product : productArrayList) {
            if (nameSearch.equals(product.getName())) {
                System.out.println(product.toString());
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Ten san pham khong ton tai!!!");
        }
    }

    //sap xep gia tang dan
    public static void sortByPrice(ArrayList<Product> productArrayList) {
        ProductSortByPrice sortByPrice = new ProductSortByPrice();
        Collections.sort(productArrayList, sortByPrice);
        System.out.println("Danh sach san pham theo thu tu gia tang dan:");
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println(productArrayList.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(new Product(1, "Tivi", 300000));
        productArrayList.add(new Product(2, "Tu Lanh", 500000));
        productArrayList.add(new Product(3, "Noi Com Dien", 100000));
        productArrayList.add(new Product(4, "Quat May", 150000));
        productArrayList.add(new Product(5, "May Bom", 200000));

        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("________MENU_________");
            System.out.println("1.Them san phan" +
                    "\n" + "2.Sua san pham" +
                    "\n" + "3.Xoa san pham" +
                    "\n" + "4.Hien thi" +
                    "\n" + "5.Tim kiem san pham" +
                    "\n" + "6.Sap xep" +
                    "\n" + "0. Thoat");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct(productArrayList);
                    break;
                case 2:
                    editProduct(productArrayList);
                    break;
                case 3:
                    deleteProduct(productArrayList);
                    break;
                case 4:
                    displayProduct(productArrayList);
                    break;
                case 5:
                    searchProduct(productArrayList);
                    break;
                case 6:
                    sortByPrice(productArrayList);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Khong co su lua chon!");
            }
        }
    }
}