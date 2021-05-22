package az.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {
    public static List<String> myWordList = new LinkedList<>();

    public static void addNewWord() {
        System.out.println("Please enter the word which you want to add:");
        Scanner scanner = new Scanner(System.in);
        String newWord = scanner.nextLine();
        myWordList.add(newWord);
        stabilizeWordList();
    }

    public static void showAllWords() {
        System.out.println("All the words in the dictionary are:");
        System.out.println("---------------------");
        int count = 0;
        for (String word : myWordList) {
            count++;
            System.out.print(word + " ; ");
            if (count % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n---------------------");
    }

    public static void searchWordFromDictionary() {
        System.out.println("Enter the word part, that you want to search :");
        Scanner scanner = new Scanner(System.in);
        String wordPart = scanner.nextLine();
        List<String> foundedWords = searchWord(wordPart);
        if (foundedWords.size() != 0) {
            System.out.println("Founded results from the dictionary for '" + wordPart +
                    "' prefix are below:");
            System.out.println("---------------------");
            for (String word : foundedWords) {
                System.out.print(word + " ; ");
            }
            System.out.println("\n---------------------");
        }

    }

    public static void createDictionaryFile() {
        try {
            File myFile = new File("dictionary.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeListToFile(List<String> list) {
        try {
            FileWriter myWriter = new FileWriter("dictionary.txt");
            for (String word : list) {
                myWriter.write(word + "\n");
            }
            myWriter.close();
            System.out.println("List was written to the file, successfully");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<String> readListFromFile() {
        List<String> dictionaryWords = new LinkedList<>();
        try (Stream<String> lines = Files.lines(Paths.get("dictionary.txt"))) {
            dictionaryWords = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dictionaryWords;
    }


    public static List<String> searchWord(String word) {
        List<String> foundWords = new LinkedList<>();
        int count = 0;
        for (String existedWord : myWordList) {
            count++;
            if (existedWord.startsWith(word)) {
                count--;
                foundWords.add(existedWord);
            } else if (count == myWordList.size()) {
                System.out.println("There is not such word starting with '"
                        + word + "' prefix");
                System.out.println("Do you want to add '" + word + "' to the dictionary?");
                System.out.println("If yes, click 'y' or 'Y'");
                System.out.println("If no, click any other key (preferably Enter key) to continue");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                if ("y".equalsIgnoreCase(choice)) {
                    myWordList.add(word);
                    stabilizeWordList();
                    break;
                } else {
                    break;
                }
            }
        }
        return foundWords;
    }

    public static void addWord(String word) {
        myWordList.add(word);
        stabilizeWordList();
    }


    public static void stabilizeWordList() {
        sortWordList();
        for (int i = 1; i < myWordList.size(); i++) {
            if (myWordList.get(i).equals(myWordList.get(i - 1))) {
                myWordList.add(i + 1, myWordList.get(i));
                myWordList.remove(myWordList.get(i));
                myWordList.remove(myWordList.get(i - 1));
                continue;
            }
        }
        sortWordList();
    }


    public static void sortWordList() {
        Collections.sort(myWordList, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return (int) (word1.compareTo(word2));
            }
        });
    }

    public static List<String> convertArrayToList(String[] array) {
        List<String> list = new LinkedList<String>();
        for (String item : array) {
            list.add(item);
        }
        return list;
    }

}
