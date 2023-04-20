package Lesson6;
import java.util.*;
import java.io.*;
public class ReadFromTextFIle {
    public static void main(String[] args) {
        String filename = "fruit.txt";

        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            int lineCounter = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
                lineCounter++;
            }
            System.out.println(lineCounter);
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        

    }
}
