package az.code;

import static az.code.Dictionary.*;

/**
 * Documentation for Dictionary App
 * This project consists of three classes:
 * <p>
 * 1)DictionaryMenu class which provides links to the operations
 * <p>
 * 2)Dictionary class which consists of the methods for main operations
 * <p>
 * 3)Main class which is used to add initial words (then I comment this part) and start the program
 * <p>
 * Note: Only run main method of Main class to start program. <b>Don't touch comments, they are used by me
 * during the configuration of Dictionary Application and for creating & initializing dictionary.txt file.</b>
 */

public class Main {
    public static void main(String[] args) {

        // Adding java keywords to the list and text file (only added first time)
//        String javaKeywords[] = { "abstract", "assert", "boolean",
//                "break", "byte", "case", "catch", "char", "class", "const",
//                "continue", "default", "do", "double", "else", "extends", "false",
//                "final", "finally", "float", "for", "goto", "if", "implements",
//                "import", "instanceof", "int", "interface", "long", "native",
//                "new", "null", "package", "private", "protected", "public",
//                "return", "short", "static", "strictfp", "super", "switch",
//                "synchronized", "this", "throw", "throws", "transient", "true",
//                "try", "void", "volatile", "while" };
//        myWordList = convertArrayToList(javaKeywords);

        // Adding initial words to my dictionary (only initialized first time)
//        addWord("final");
//        addWord("class");
//        addWord("add");
//        addWord("additional");
//        addWord("dictionary");
//        addWord("custom");
//        addWord("Asadullah");
//        addWord("Jamalov");
//        addWord("java");
//        addWord("programming");

        // Creating dictionary file (only created first time)
//        createDictionaryFile();

        // Adding initial words to the file (only added first time)
//        writeListToFile(myWordList);


        // Reading words from dictionary.txt
        // (every time you run program, last version of dictionary will be transferred to the list)
        myWordList = readListFromFile();

        // Starting the Dictionary Console App
        DictionaryMenu.showDictionaryMenu();
    }
}
