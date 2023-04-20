package Lesson4;

public class Cat extends Pet {
    public Cat(String name, String breed, double weight){
        super(name,breed,weight);
    }

    @Override
    public void sound(){
        System.out.println(getName()+"Meow Meow");
    }
    @Override
    public void eat(){
        System.out.println(getName()+"food");
    }
    
}
    

