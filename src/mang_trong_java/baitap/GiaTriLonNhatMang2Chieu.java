package mang_trong_java.baitap;

import java.util.Scanner;

public class GiaTriLonNhatMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng (row) của mảng:");
        int row  = scanner.nextInt();
        System.out.print("Nhập vào số cột (col) của mảng:");
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
//        --------------------------------------
        int max = 0;
        int goal1 = 0,goal2 = 0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print("Nhập vào phần tử thứ ("+(i+1)+","+(j+1)+"):");
                array[i][j] = scanner.nextInt();
                if (i==0&&j==0) {
                    max = array[i][j];
                } else if(array[i][j]>max) {
                    max = array[i][j];
                    goal1 = i;goal2 = j;
                }
            }
        }

        System.out.println("Mảng hai chiều:");
        for ( row = 0; row < array.length; row++) {
            for (col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("Phần tử lớn nhất trong mảng:"+max+" ở vị trí ("+(goal1+1)+","+(goal2+1)+")");
    }
}
