package Lesson6;

import java.io.FileOutputStream;
import java.io.OutputStream;


public class WriteToBinFile {
 
    public static void main(String[] args) {
        char[] characters = {'a','b','c','d'};
        int[] ints = {1,2,3};
        String fileName = "test.bin";

        try {
            OutputStream opSteam = new FileOutputStream(fileName);

            for(char c : characters){
                opSteam.write(c);
            }
            for(int i:ints){
                opSteam.write(i);
            }
            opSteam.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
