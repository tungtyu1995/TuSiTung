package dsa_stack_queue.baitap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PracticeUsingTreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a text");
        String string = scanner.nextLine();

        String[] string1 = string.split(" ");
        Map<String, Integer> treeMap = new TreeMap<>();

        for (int i=0; i<string1.length;i++){
            int count=1;

            for(int j=0;j<i;j++){
//                string1[i].toLowerCase();
                if(string1[i].equals(string1[j])){
                    count++;
                }
            }
            treeMap.put(string1[i],count);
        }
        System.out.println(treeMap);
    }
}
