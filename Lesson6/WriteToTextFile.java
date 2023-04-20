package Lesson6;
import java.io.*;


public class WriteToTextFile {
    public static void main(String[] args) {
        String filename = "fruit.txt";
        try {
            PrintWriter pw = new PrintWriter(filename);
            pw.write("\napple");
            pw.write("\n\nbanana");
            pw.write("\ncherry");
            pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
