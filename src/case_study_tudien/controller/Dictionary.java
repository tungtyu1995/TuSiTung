package case_study_tudien.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    static final String FILE_PATH = "D:\\C0520G1-Tung\\src\\case_study_tudien\\data\\Dictionary.txt";
    static List<Word> wordList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    //_________________________________________________________________
    public static void readFile() {
        boolean check = true;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
            while (check) {
                Word word = (Word) objectInputStream.readObject();
                if (word != null) {
                    wordList.add(word);
                } else {
                    check = false;
                }
                objectInputStream.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //   ______________________________________________________________________________
    public static void writeFile(String filePath) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < wordList.size(); i++) {
                objectOutputStream.writeObject(wordList.get(i));
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void lookup(String keyword) {
        readFile();
        if (wordList.size() == 0) {
            System.out.println("Dictionary is empty !!! please enter new word ");
            addNewWord();
        } else {
            for (int i = 0; i < wordList.size(); i++) {
                if (keyword.equals(wordList.get(i).getAction())) {
                    System.out.println(wordList.get(i).toString());
                    break;
                } else if (i == wordList.size() - 1) {
                    System.out.println("Not word found");
                    System.out.println("Do you want add the word" + "\n1.Yes" + "\n2.No");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            addNewWord();
                            break;
                        case 2:
                            break;
                    }
                }
            }
        }
    }

    //_______________________________________________________

    private static void addNewWord() {

        String string;
        System.out.println("Enter word: ");
        String stringWord = scanner.nextLine();
        System.out.println("Enter pronoun: ");
        String pronoun = scanner.nextLine();
        System.out.println("Enter adjective: ");
        String adjective = "";
        string = scanner.nextLine();
        while (!string.equals("exit")) {
            adjective += string + "\n";
            string = scanner.nextLine();
        }
        System.out.println("Enter noun: ");
        String noun = "";
        string = scanner.nextLine();
        while (!string.equals("exit")) {
            noun += string + "\n";
            string = scanner.nextLine();
        }
        System.out.println("Enter verb: ");
        String verb = "";
        string = scanner.nextLine();
        while (!string.equals("exit")) {
            verb += string + "\n";
            string = scanner.nextLine();
        }
        System.out.println("Enter synonymous: ");
        String synonymous = "";
        string = scanner.nextLine();
        while (!string.equals("exit")) {
            synonymous += string + "\n";
            string = scanner.nextLine();
        }
        Word word = new Word(stringWord, pronoun, adjective, noun, verb, synonymous);
        wordList.add(word);
        writeFile(FILE_PATH);
        wordList.clear();
    }

    //__________________________________________________________________________________________
    public static void define(String keyWord, String key) {
        readFile();
        List<String> stringList = new ArrayList<>();
        String string ="";
        String definition = "";
        String noun = "";
        String verb = "";
        String synonymous = "";
        Word word = null;
        for (int i = 0; i < wordList.size(); i++) {
            if (keyWord.equals(wordList.get(i).getAction())) {
                word = wordList.get(i);
                wordList.remove(i);
            }else {
                System.out.println("Not word found. Please enter new word !!!");
                addNewWord();
            }
        }
        switch (key) {
            case "adjective":
                System.out.println("Enter more adjective (end by the word: exit): ");
                string = scanner.nextLine();
                while (!string.equals("exit")) {
                    stringList.add(string);
                    string = scanner.nextLine();
                }
                for (int j = 0; j < stringList.size(); j++) {
                    definition += stringList.get(j) + "\n";
                }
                word.setAdjective(definition);
                wordList.add(word);
                break;
            case "noun":
                System.out.println("Enter more noun (end by the word: exit): ");
                string = scanner.nextLine();
                while (!string.equals("exit")) {
                    stringList.add(string);
                    string = scanner.nextLine();
                }
                for (int j = 0; j < stringList.size(); j++) {
                    noun += stringList.get(j) + "\n";
                }
                word.setNoun(noun);
                wordList.add(word);
                break;
            case "verb":
                System.out.println("Enter more verb (end by the word: exit): ");
                string = scanner.nextLine();
                while (!string.equals("exit")) {
                    stringList.add(string);
                    string = scanner.nextLine();
                }
                for (int j = 0; j < stringList.size(); j++) {
                    verb += stringList.get(j) + "\n";
                }
                word.setVerb(verb);
                wordList.add(word);
                break;
            case "synonymous":
                System.out.println("Enter more synonymous (end by the word: exit): ");
                string = scanner.nextLine();
                while (!string.equals("exit")) {
                    stringList.add(string);
                    string = scanner.nextLine();
                }
                for (int j = 0; j < stringList.size(); j++) {
                    synonymous += stringList.get(j) + "\n";
                }
                word.setSynonymous(synonymous);
                wordList.add(word);
                break;
        }
        writeFile(FILE_PATH);
        wordList.clear();
    }

    //    ____________________________________________________________________
    public static void drop(String word) {
        readFile();
        for (int i = 0; i < wordList.size(); i++) {
            if (word.equals(wordList.get(i).getAction())) {
                wordList.remove(i);
                System.out.println("@" + word + "dropped");
            } else if (i == wordList.size() - 1) {
                System.out.println("Not word found");
            }
        }
        writeFile(FILE_PATH);
        wordList.clear();
    }

    public static void export(String filePath) {
        readFile();
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Exporting 10%..20%..30%..40%..50%..60%..70%..80%..90%..Done!");
            } else {
                System.out.println("\"File already exists..\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(filePath);
    }

    public static void displayMainDictionary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_________DICTIONARY__________");
        System.out.println("Enter a word according to the format: (lookup/define/drop/export) word");
        System.out.println("Action: ");
        String word = scanner.nextLine();
        String[] strings = word.split(" ");
        switch (strings[0]) {
            case "lookup":
                Dictionary.lookup(strings[1]);
                displayMainDictionary();
                break;
            case "define":
                Dictionary.define(strings[1],strings[2]);
                displayMainDictionary();
                break;
            case "drop":
                Dictionary.drop(strings[1]);
                displayMainDictionary();
                break;
            case "export":
                Dictionary.export(strings[1]);
                break;
        }
    }

}
