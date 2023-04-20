package Lesson6;
import java.io.*;


public class WriteToTextFile {
    public static void main(String[] args) {
        String filename = "fruit.txt";
        try {
            PrintWriter pw = new PrintWriter(filename);
            pw.write("apple");
            pw.write("banana");
            pw.write("cherry");
            pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
