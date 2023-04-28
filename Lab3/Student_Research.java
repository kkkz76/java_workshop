public class Student_Research extends Student{

    private Unit_Research unit;

    
    public Student_Research(String firstName, String lastName, String id) {
        super(firstName, lastName, id, "R");
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
        finalGrade = "Research incomplete";
    }
    return finalGrade;
    }

    public void setUnit(Unit unit) {
        this.unit =(Unit_Research) unit;
    }
  
    
    public String getCSVString() {
    	return this.getId()+","+this.getFinalGrade();
    }
}
