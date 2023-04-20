package Lesson6;

import java.util.ArrayList;

public class PetShelter {
    private ArrayList<Pet> pets;
    
    public PetShelter(){
        pets = new ArrayList<Pet>();
    }

    public void run(){
        Pet pet1 = new Dog("snoppy","Beagle",20,true);
        Pet pet2 = new Dog("Dice","human",50,true);
        Pet pet3 = new Dog("Nal","bastard",30,true);
        Pet pet4 = new Dog("KingDice","soutpaw",80,true);

        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);

        for(Pet pet: pets){
            pet.sound();
            pet.eat();

            if(pet instanceof Dog){
                Dog dog = (Dog)pet;
                dog.eat("bones");
            }
        }

        displayStats();


    }

    public void displayStats(){
        Pet lightest = pets.get(0);
        Pet heaviest = pets.get(0);
        double total = 0;
        for(Pet pet: pets){
            if(pet.getWeight() < lightest.getWeight()){
                lightest = pet;
            }
            if(pet.getWeight() > heaviest.getWeight()){
                heaviest = pet;
            }
            total += pet.getWeight();
        }
        System.out.println("lightest:" + lightest.getName());
        System.out.println("heaviest:"+ heaviest.getName());
        double ave = total/pets.size();
        System.out.println("ave: "+ave);
    }

    public static void main(String[] args) {
        PetShelter app = new PetShelter();
        app.run();
    }
    

}
