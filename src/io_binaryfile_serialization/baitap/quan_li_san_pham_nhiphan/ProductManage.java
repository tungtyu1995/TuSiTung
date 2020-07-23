package io_binaryfile_serialization.baitap.quan_li_san_pham_nhiphan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static List<Product> productList = new ArrayList<>();
    public static final String FILE_PATH = "src/io_binaryfile_serialization/baitap/quan_li_san_pham_nhiphan/quanlysanpham.txt";

    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        int productCode = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap ten san pham: ");
        String productName = scanner.nextLine();
        System.out.println("Nhap hang san xuat: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhap gia san pham: ");
        Double productPrince = scanner.nextDouble();
        Product product = new Product(productCode,productName,manufacturer,productPrince);
        productList.add(product);
        writeFile();
        System.out.println("Them moi san pham thanh cong");
    }

    public static void displayProduct(){
        System.out.println("___Danh sach san pham___");
        if(productList.isEmpty()){
            System.out.println("Danh sach trong. Vui long nhap them san pham !!!");

        }else {
//            for (Product prd : productList) {
//                System.out.println(prd);
//}
            readFile();
        }
    }
    public static void seachProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham:");
        String nameSearch = scanner.nextLine();

        boolean check = false;
        for (Product product: productList) {
            if (nameSearch.equals(product.getProductName())) {
                System.out.println(product.toString());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Ten san pham khong ton tai!!!");
        }
    }
    public static void writeFile(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(){
        File file = new File(FILE_PATH);
        if(!file.exists()){
            System.out.println("File khong ton tai");
        }else {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);

                List<Product> productList = (List<Product>) objectInputStream.readObject();
                for (Product product : productList) {
                    System.out.println("Ma san pham: "+product.getProductCode()+" Ten san pham: "
                            +product.getProductName()+" Hang san xuat: "
                            +product.getManufacturer()+" Gia san pham: "+
                            product.getProductPrince());
                }
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
