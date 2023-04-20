package Lesson6;


public class Student {
    private String student_number;
    private String first_name;
    private String last_name;
    private double score;

    public Student(String student_number, String first_name, String last_name,Double score){
        this.student_number = student_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.score = score;
    }
    public void display(){
        System.out.println("Student number: " + student_number);
        System.out.println("First name: " + first_name);
        System.out.println("Last name: " + last_name);
        System.out.println("Score: " + score);
        System.out.println("Grade:"+computeGrade(this.score));
    }

    public String toCSVString(){
        return this.student_number+","+computeGrade(this.score);
    }
    public static String computeGrade(double score){
        String grade = "F";
        if(score >= 85){
            grade= "HD";
        }else if(score >= 75){
            grade= "H";

        }else if(score >= 65){
            grade= "C";
        }else if(score >= 50){
            grade= "F";
        }
        return grade;
    }
}
