import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<String> hangmanWords = cvsToArray();

        welcomeMsg();

        int randomWordNumber = randomNumberGenerater(hangmanWords);

        String hangmanWord = getHangmanWord(randomWordNumber, hangmanWords);

        gameEngine(hangmanWord);


    }

    public static void gameEngine(String hangmanWord){
        printGame(hangmanWord);
    }

    public static void printGame(String hangmanWord){
        System.out.println(hangmanWord);
        ArrayList<String> spaces = hangmanLines(hangmanWord);
        ArrayList<String> hangmanLines = checkLetterWithLine(hangmanWord, spaces);
        System.out.println(hangmanLines);

        System.out.println(hangmanWord);
    }

    public static char printGameMsg(){

        System.out.println("Please type the letter you want to guess");
        char letterGuessed = scanner.next().charAt(0);
        return letterGuessed;
    }

    public static ArrayList<String> checkLetterWithLine(String hangmanWord, ArrayList<String> spaces){
        char[] letters = new char[hangmanWord.length()];
        char letterGuessed = printGameMsg();

        for (int i = 0; i < hangmanWord.length(); i++) {
            letters[i] = hangmanWord.charAt(i);
        }

        for (int i = 0; i < letters.length; i++) {
            if (letterGuessed == letters[i]){
                    spaces.set(i, " " + letterGuessed + " ");
            }
        }
        return spaces;
    }

    public static ArrayList<String> hangmanLines(String hangmanWord){
        ArrayList<String> spaces = new ArrayList<>();
        String space = " __ ";

        for (int i = 0; i < hangmanWord.length(); i++) {
            spaces.add(space);
        }
        return spaces;
    }

    public static String getHangmanWord(int randomWordNumber, ArrayList<String> hangmanWords){
        return hangmanWords.get(randomWordNumber);
    }

    public static int randomNumberGenerater(ArrayList<String> hangmanWords){
        Random random = new Random();
        int upperLimit = hangmanWords.size() + 1;
        return random.nextInt(upperLimit);
    }

    public static void welcomeMsg(){
        String welcome = "\nWelcome to Hangman";
        String lineBreak = "\n";
        String rules = "The rules are simple. . . . . .";
        System.out.println(welcome + lineBreak + lineBreak +  rules + lineBreak);
    }

    public static ArrayList<String> cvsToArray(){
        ArrayList<String> hangmanWordList = new ArrayList<>();
        try{
            File wordFile = new File("resources/Words.csv");
            Scanner scanner = new Scanner(wordFile);

            while(scanner.hasNextLine()){
                String hangmanWords = scanner.nextLine();
                hangmanWordList.add(hangmanWords);
            }

        }catch(FileNotFoundException e){
            System.out.println("Could not find file");
        }
        return(hangmanWordList);
    }
}
