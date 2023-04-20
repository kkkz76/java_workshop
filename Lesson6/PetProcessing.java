package Lesson6;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PetProcessing {

public static void main(String[] args) {
    String filename = "pet.csv";
    ArrayList<Pet> pets = new ArrayList<Pet>();
 try {
    Scanner reader = new Scanner(new File(filename));
    String header = reader.nextLine();
    while(reader.hasNextLine()) {
        String line = reader.nextLine().trim();
        if(line.equals("")){
            continue;
        }
        System.out.println(line);
        String[] data =line.split(",");
        String Type = data[0].trim();
        String Name = data[1].trim();
        String Breed = data[2].trim();
        Double weight = Double.parseDouble(data[3].trim());

        System.out.println(Type);
        System.out.println(Name);
        System.out.println(Breed);
        System.out.println(weight);
        System.out.println();

        if(Type.equals("Dog")){
            boolean mc = Boolean.parseBoolean(data[4].trim());
            Dog dog = new Dog(Name,Breed,weight,mc);
            pets.add(dog);
        }else{
            Cat cat = new Cat(Name,Breed,weight);
            pets.add(cat);
        }
    }
 } catch (Exception e) {
    // TODO: handle exception
 }

 for(Pet pet : pets){
    pet.display();
    System.out.println();
 }

 String  outputFileNae = "pet.bin";
 try {
    FileOutputStream f = new FileOutputStream(outputFileNae);
    ObjectOutputStream s = new ObjectOutputStream(f);
    for(Pet pet : pets){
        s.writeObject(pet);
    }
    s.close();
 } catch (Exception e) {
    // TODO: handle exception
 }
}
 
}
