package mang_trong_java.baitap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Nhập giá trị của mảng!");
        for (int i = 0; i < size ; i++) {
            System.out.print("Nhập phần tử thứ: "+(i+1)+":");
            array[i] = scanner.nextInt();
        }

        if (size > 0) {
            int min = array[0];
            for (int index: array) {
                if (index < min) {
                    min = index;
                }
            }
            System.out.println("Giá  trị nhỏ nhất cảu mảng:"+min);
        }
        else {
            System.out.println("Có gì đâu mà so sánh");
        }
    }
}
