import java.util.ArrayList;

import java.util.*;
import java.io.*;

public class ResultProcessSystem {

	//Constant for file name - do not change.
	private final static String STUDENTS_DATA_FILE_NAME = "students.csv";
	private final static String UNITS_RESULT_DATA_FILE_NAME = "units_result.csv";
	private final static String RESULTS_RELEASE__OUTPUT_FILENAME = "results_release.csv";
	private final static String UNMATCH_UNITS_RESULT_FILENAME = "unmatch_units_result.csv";
	
	//One ArrayList to store both Coursework and Research Student and
	//one Arraylist to store both Unit
	//make use of Polymorphism!
	private static ArrayList<Student> students;
	private static ArrayList<Unit> units;
	
	public static void run() {
		students = new ArrayList<Student>();
		units = new ArrayList<Unit>();
		readInStudentsDataFromCSVFile();
		readInStudentsUnitResultFromCSVFile();
		matchUnitToStudent();
		sortStudentsArrayListByStudentID();
		printStudentArrayListToResultReleaseCSV();
		printUnitsWithNoStudentsMatchToCSV();
	}
	
	private static void readInStudentsDataFromCSVFile() {
		
		try {
			Scanner file = new Scanner(new File(STUDENTS_DATA_FILE_NAME ));
			while(file.hasNextLine()) {
				//TODO: convert each record to a student object
				//add student object to ArrayList students
				String line = file.nextLine().trim();
				if(line.equals("")){
					continue;
				}
				String[] data = line.split(",");
				String UnitType = data[0].trim();
				String firstName = data[1].trim();
				String lastName = data[2].trim();
				String StudentId = data[3].trim();

				if(UnitType.equals("C")){
					students.add(new Student_Coursework(firstName, lastName, StudentId));
				}else if(UnitType.equals("R")){
					students.add(new Student_Research(firstName, lastName, StudentId));
				}
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Student data file not found");
		}
	}
	
	private static void readInStudentsUnitResultFromCSVFile() {
		try {
			Scanner file = new Scanner(new File(UNITS_RESULT_DATA_FILE_NAME));
			while(file.hasNextLine()) {
				//TODO: convert each record to either a Unit_Coursework
				//or Unit_Research object and add it to ArrayList units.
				String line = file.nextLine().trim();
				if(line.equals("")){
					continue;
				}
				String[] data = line.split(",");
				String StudentId = data[0].trim();

				if(StudentId.substring(0, 1).equals("C")){
					String unitCode = data[1].trim();
					double a1 =Double.parseDouble(data[2].trim());
					double a2 = Double.parseDouble(data[3].trim());
					double exam = Double.parseDouble(data[4].trim());

					units.add(new Unit_Coursework(StudentId,unitCode,a1,a2,exam));

				}else if(StudentId.substring(0, 1).equals("R")){
					double m1 =Double.parseDouble(data[1].trim());
					double m2 = Double.parseDouble(data[2].trim());

					units.add(new Unit_Research(StudentId, m1, m2));
				}
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println(UNITS_RESULT_DATA_FILE_NAME+" file not found");
		}
	}

	private static void matchUnitToStudent() {
		//TODO: look for each student object unit results in units ArrayList
		//assign the unit into the student object
		//remove the assigned unit from units ArrayList
		for(Student std:students){
			for(int i =0; i<units.size();i++){
				Unit unit = units.get(i);
				if(std.getId().equals(unit.getStudentID())){
					std.setUnit(unit);
					units.remove(unit);
				}
			}
		}

	}
	
	private static void sortStudentsArrayListByStudentID() {
		// TODO: sort the ArrayList students by Student ID
		boolean swap = true;
		while (swap) {
		  swap = false;
	
		  for (int i = 1; i < students.size(); i++) {
			Student id1 = students.get(i - 1);
			Student id2 = students.get(i);
	
			if (id1.studentIDMoreThan(id2)) { // reuse the method from student class
			  students.set(i - 1, id2);
			  students.set(i, id1);
			  swap = true;
	
			}
		  }
		}
	  }
	
	private static void printStudentArrayListToResultReleaseCSV() {
		
		try {
			PrintWriter pw = new PrintWriter(RESULTS_RELEASE__OUTPUT_FILENAME);
			
			//TODO: print result_release.csv
			for(Student str: students){
				pw.write(str.getCSVString()+"\n");
			}
			pw.close();
		
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open "+RESULTS_RELEASE__OUTPUT_FILENAME);
		}
	}
	
	private static void printUnitsWithNoStudentsMatchToCSV() {
		try {
			PrintWriter pw = new PrintWriter(UNMATCH_UNITS_RESULT_FILENAME);
			//TODO: print unmatch_units_result.csv
			for(Unit unmatch:units){
				pw.write(unmatch.getCSVString()+"\n");
				
			}
		
			pw.close();
		
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open "+UNMATCH_UNITS_RESULT_FILENAME);
		}
	}
	
	public static String getStudentsDataFileName() {
		return STUDENTS_DATA_FILE_NAME;
	}

	public static String getUnitsResultDataFileName() {
		return UNITS_RESULT_DATA_FILE_NAME;
	}

	public static String getResultsReleaseOutputFilename() {
		return RESULTS_RELEASE__OUTPUT_FILENAME;
	}

	public static String getUnmatchUnitsResultFilename() {
		return UNMATCH_UNITS_RESULT_FILENAME;
	}

	public static void main(String[] args) {
		
		run();
		
	
		
	}
}


