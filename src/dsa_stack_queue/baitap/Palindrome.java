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
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
            queue.offer(charArray[i]);
        }
        boolean check = false;
        for (int i = 0; i < stack.size(); i++) {
            Character a = stack.pop();
            Character b = queue.poll();

            if (a == b) {
                check = true;
            } else {
                check = false;
                break;
            }

        }
        if (check) {
            System.out.println(inputString + " la chuoi Palindrome ");
        } else {
            System.out.println(inputString + " khong phai la chuoi Palindrome");
        }
    }
}
