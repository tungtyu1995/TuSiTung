package java_collection_framework.baitap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    //xoa san pham
    public static void deleteProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham can xoa: ");
        int deleteID = scanner.nextInt();
        Product temp = null;
        boolean check = false;
        for (Product product : productArrayList) {
            if (product.getId() == deleteID) {
                temp = product;
                check = true;
                break;
            }
        }
        if (check) {
            productArrayList.remove(temp);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Id san pham khong ton tai !!!");
        }
        displayProduct(productArrayList);
    }

    //sua san pham
    public static void editProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham can sua: ");
        int editID = scanner.nextInt();

        boolean check = false;
        for (Product product : productArrayList) {
            if (product.getId() == editID) {
                System.out.println(product);
                System.out.print("nhap vao ten san pham: ");
                product.setName(scanner.nextLine());
                product.setName(scanner.nextLine());
                System.out.print("nhap vao gia san pham: ");
                product.setPrice(scanner.nextDouble());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("ID khong ton tai!!!");
        }
        displayProduct(productArrayList);
    }

    //them san pham
    public static void addProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        int id;
        boolean checkID = true;
        do {
            System.out.print("nhap vao id san pham: ");
            id = scanner.nextInt();
            for (Product product : productArrayList) {
                if (id == product.getId()) {
                    System.out.println("ID ban nhap da ton tai !!!");
                    checkID = false;
                    break;
                } else if (id < 0 ) {
                    System.out.println("Id bạn nhap bi sai");
                    checkID = false;
                    break;
                } else {
                    checkID = true;
                }
            }
        }while (!checkID);

        scanner.nextLine();
        System.out.print("nhap vao ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("nhap vao gia san pham: ");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        productArrayList.add(product);
        displayProduct(productArrayList);
    }

    //hien thi danh sach san pham
    public static void displayProduct(ArrayList<Product> productArrayList) {
        System.out.println("___Danh sach san pham___");
        if(productArrayList.isEmpty()){
            System.out.println("Danh sach trong. Vui long nhap them san pham !!!");
            addProduct(productArrayList);
        }else {
            for (Product prd : productArrayList) {
                System.out.println(prd);
            }
        }


    }

    //tim san pham theo ten
    public static void searchProduct(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham:");
        String nameSearch = scanner.nextLine();

        boolean check = false;
        for (Product product : productArrayList) {
            if (nameSearch.equals(product.getName())) {
                System.out.println(product.toString());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Ten san pham khong ton tai!!!");
        }
    }

    //sap xep theo gia
    public static void sortByPrice(ArrayList<Product> productArrayList) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println(" 1.Sap xep theo thu tu gia tang dan " +
                " \n " + "2.Sap xep theo thu tu gia giam dan");
        choice = scanner.nextInt();
//        sap xep gia tang dan
        if (choice == 1) {
            ProductSortByPriceIncrease sortByPriceIncrease = new ProductSortByPriceIncrease();
            Collections.sort(productArrayList, sortByPriceIncrease);
            System.out.println("Danh sach san pham theo thu tu gia tang dan:");
            for (int i = 0; i < productArrayList.size(); i++) {
                System.out.println(productArrayList.get(i));
            }
//            sap xep gia giam dan
        } else if (choice == 2) {
            ProductSortByPriceReduction sortByPriceReduction = new ProductSortByPriceReduction();
            Collections.sort(productArrayList, sortByPriceReduction);
            System.out.println("Danh sach san pham theo thu tu gia giam dan:");
            for (Product product : productArrayList) {
                System.out.println(product);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(new Product(1, "Tivi", 150.5));
        productArrayList.add(new Product(2, "Tu Lanh", 200.3));
        productArrayList.add(new Product(3, "Noi Com Dien", 30.3));
        productArrayList.add(new Product(4, "Quat May", 30.2));
        productArrayList.add(new Product(5, "May Bom", 100.2));
//Menu
        int choice ;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("________MENU_________");
            System.out.println("1.Them san phan" +
                    "\n" + "2.Sua san pham" +
                    "\n" + "3.Xoa san pham" +
                    "\n" + "4.Hien thi" +
                    "\n" + "5.Tim kiem san pham" +
                    "\n" + "6.Sap xep" +
                    "\n" + "0. Thoat Menu");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct(productArrayList);
                    break;
                case 2:
                    displayProduct(productArrayList);
                    editProduct(productArrayList);
                    break;
                case 3:
                    displayProduct(productArrayList);
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