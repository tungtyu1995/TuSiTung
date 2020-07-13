package dsa_stack_queue.baitap;


import java.util.Scanner;
import java.util.Stack;

public class Bracket1 {
    public static void main(String[] args) {
        System.out.print("Input String: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        System.out.println("check: " + isValidBrackets(inputString));
    }

    private static boolean isValidBrackets(String inputString) {
        Stack<String> stack = new Stack<>();
        boolean isValid = true;
        for (int i = 0; i< inputString.length(); i++){
            String character = inputString.substring(i, i + 1);
            if (character.equals("(")){
                stack.push(character);
            } else if (character.equals(")")){
               if(stack.isEmpty()) {
                   isValid = false;
                   break;
               } else {
                   stack.pop();
               }
            }
        }
        if (!stack.isEmpty()){
           isValid = false;
        }
        return  isValid;
    }
}
