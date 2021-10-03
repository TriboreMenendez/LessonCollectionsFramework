import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static File file = new File("voyna.txt");
    static Scanner scanner;
    public static void main (String [] args) {

        //парсер
        Parser parser = new Parser();
        String parserWord = "страдания";

        try {
            parser.parser(file,parserWord);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //парсер с использованием Scanner
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Поиск с использованием Scanner");

        String s = parserWord.substring(0,parserWord.length()-2);
        int x =0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile(s,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                x++;
            }
        }
        System.out.println("Количество вхождений слова" + parserWord + ": " + x);


        //таблица умножения
        int [][] multi = new int[10][10];

        for (int i = 1; i<11; i++) {
            for (int j = 1; j < 11; j++){
                multi[i-1][j-1] = i*j;
                if (multi[i-1][j-1]<10) System.out.print(multi[i-1][j-1]+ "  ");
                else System.out.print(multi[i-1][j-1] + " ");
            }
            System.out.println();
        }

    }
}
