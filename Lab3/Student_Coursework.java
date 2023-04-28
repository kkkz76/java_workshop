public class Student_Coursework extends Student{

    private Unit_Coursework unit;

    
    public Student_Coursework(String firstName, String lastName, String id) {
        super(firstName, lastName, id,"C");
    }

  

    public void setUnit(Unit unit) {
        this.unit =(Unit_Coursework)unit;
    }
 
    public String getFinalGrade(){
    	//TODO: return the student final grade
    
    	String finalGrade = "";
    try {
        if (unit != null) {
            finalGrade = unit.getFinalGrade();
        } else {
            throw new NullPointerException();
        }
    } catch (NullPointerException e) {
        finalGrade = "No unit attempt";
    }
    return finalGrade;
    }

   
    public String getCSVString() {
    	return this.getId()+","+this.getFinalGrade();
    }
    
}
