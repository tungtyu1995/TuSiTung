package dsa_stack_queue.baitap;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        System.out.print("Input String: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println( isValidBrackets(inputString));
    }

    private static boolean isValidBrackets(String inputString) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        boolean isValid;
        for (int i = 0; i < inputString.length(); i++) {
            String character = inputString.substring(i, i + 1);
            if (character.equals("(")) {
                stack1.push(character);
            } else if (character.equals(")")) {
                if (!stack1.isEmpty() && (stack1.size() - stack2.size() > 0)){
                    stack2.push(character);
                }
            }
        }
        isValid = stack1.size() == stack2.size() && stack1.size() != 0;

        return isValid;
    }
}
