package az.code;

import java.util.Scanner;

import static az.code.Dictionary.*;

public class DictionaryMenu {
    public static void showDictionaryMenu() {
        OUT:
        while (true) {
            System.out.println("*****************************");
            System.out.println("Choose one of the choices in the Dictionary Menu: ");
            System.out.println("1)Add new word");
            System.out.println("2)Show all words");
            System.out.println("3)Search word from dictionary");
            System.out.println("4)Write updated words to the dictionary.txt and Exit");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                switch (choice) {
                    case "1":
                        addNewWord();
                        break;
                    case "2":
                        showAllWords();
                        break;
                    case "3":
                        searchWordFromDictionary();
                        break;
                    case "4":
                        writeListToFile(myWordList);
                        break OUT;
                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-4");
                continue;
            }


        }

    }
}
