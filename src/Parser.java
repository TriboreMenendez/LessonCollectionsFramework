import java.io.*;

public class Parser {

    public void parser(File file, String Word) throws IOException {

        BufferedReader reader = null;
        int resultWord = 0;
        String searchWord ="";

        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = reader.readLine();
        if (Word.length()>3) searchWord = Word.substring(0,Word.length()-2);

        while (line != null) {
            if (line.toLowerCase().contains(searchWord.toLowerCase()))
                ++resultWord;
            line = reader.readLine();
        }

        System.out.println("Количество вхождений слова " + Word + ": " + resultWord);
    }
}
