import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileReader {
    public static void main(String[] args){
        try{
            File wordFile = new File("resources/Words.csv");
            Scanner sc = new Scanner(wordFile);
            while(sc.hasNextLine()){
                String hangmanWords = sc.nextLine();
                System.out.println(hangmanWords);
            }
        }catch(FileNotFoundException e){
            System.out.println("Could not find file");
        }
    }
}