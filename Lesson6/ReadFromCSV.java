package Lesson6;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromCSV {
    public static void main(String[] args) {
        String filename = "result.csv";
        String OutputFileName = "Grade.csv";
        ArrayList<Student>Students = new ArrayList<Student>();
        try {
            PrintWriter pw = new PrintWriter(OutputFileName);
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            String header = reader.nextLine();
            while(reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if(line.equals("")){
                    continue;
                }
                String[] data = line.split(",");
                String StudentNumber = data[0].trim();
                String firstNmae = data[1].trim();
                String lastName = data[2].trim();
                double score = Double.parseDouble(data[3].trim());
                System.out.println(line);

                // System.out.println(StudentNumber);
                // System.out.println(firstNmae);
                // System.out.println(lastName);
                // System.out.println(score);

                Student s1 = new Student(StudentNumber,firstNmae,lastName,score);
                Students.add(s1);
            }
            reader.close();

            for(Student student: Students){
                pw.write(student.toCSVString()+"\n");
            }pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
