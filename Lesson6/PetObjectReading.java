package Lesson6;


import java.io.*;
import java.util.*;

public class PetObjectReading {

    public static void main(String[] args) {
        String filename = "pets.bin";
        ArrayList<Pet> pets = new ArrayList<Pet>();

    try {
        FileInputStream f =new FileInputStream(filename);
        ObjectInputStream s = new ObjectInputStream(f);
        boolean endOfFile = false;
        while(!endOfFile){
            try {
                Pet pet = (Pet)s.readObject();
                pets.add(pet);
            } catch (EOFException ex) {
                endOfFile = true;
                // TODO: handle exception
            }
        }
    } catch (ClassNotFoundException ex) {
    } catch(FileNotFoundException ex) {
    }catch(IOException ex) {

    }
    for(Pet pet : pets){
        pet.display();
        pet.sound();
        pet.eat();
        if(pet instanceof Dog){
            Dog dog = (Dog)pet;
            dog.eat("bone");
        }
        System.out.println();
    }
    }
    
}
