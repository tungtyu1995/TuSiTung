package dsa_stack_queue.baitap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Input String :");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        char[] charArray = inputString.toCharArray();
//        System.out.println(charArray);

        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
            queue.offer(charArray[i]);
        }
        boolean check = stack == queue;
        if(check){
            System.out.println(inputString + " la chuoi Palindrome ");
        }else {
            System.out.println(inputString + " khong phai la chuoi Palindrome");
        }
    }
}