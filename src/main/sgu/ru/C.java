package main.sgu.ru;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    public void main() {
        String file = System.console().readLine("Enter file name: ");
        try
        {
            System.out.println("Processed lines:");
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try
                {    
                    System.out.println(processingLine(line));
                }
                catch (Exception ex) {
                    System.out.println("Unable to process line " + line);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException ex)  {
            System.out.println("File " + file + " not exist!");
        }
    }

    private String processingLine(String line) throws Exception {
        String[] data = Arrays.copyOfRange(line.split(" "), 0, 3);
        for(int i = 0; i < data.length; i++) {
            if (!spellCheck(data[i])) {
                throw new Exception("Unexpected method");
            }
        }
        return data[1] + " " + data[0].charAt(0) + ". " + data[2].charAt(0) + ".";
    }
    
    private boolean spellCheck(String word) {
        for (int j = 0; j < word.length(); j++) {
            if (!Character.isLetter(word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
