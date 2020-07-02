package mang_trong_java.baitap;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so hang:");
        int row = sc.nextInt();
        System.out.print("Nhap so cot:");
        int col = sc.nextInt();
        int[][] array = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                float random = (float) (Math.random()*100);
                array[i][j] = Math.round(random);
            }
        }
        for ( row = 0; row < array.length; row++) {
            for (col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col]+ " ");
            }
            System.out.println();
        }

            while (true) {
                System.out.print("Ban muon tinh tong cot nao:");
                int choice = sc.nextInt();
                int sum = 0;
                for (int i = 0; i < row; i++) {
                    sum += array[i][choice];
                }
                System.out.println("Tong Cot " + choice + ":" + sum);
                System.out.println("Continue? (Yes/No): ");
                sc.nextLine();
                String choice1 = sc.nextLine();
                if (choice1.equals("Yes")) {
                    break;
                }
                System.out.println(sum);
            }

        }
    }
