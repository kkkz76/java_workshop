public class Unit_Coursework extends Unit{

    private String unitCode;
    private double a1;
    private double a2;
    private double exam;

    public Unit_Coursework(String studentID, String unitCode, double a1, double a2, double exam) {
        super(studentID,"CW");
        this.unitCode = unitCode;
        this.a1 = a1;
        this.a2 = a2;
        this.exam = exam;
    }
    
    public double getOverallMarks(){
        double total = 0.0;
        total = (this.a1*0.2)+(this.a2*0.3)+(this.exam*0.5);
        //TODO: calculate coursework overall marks;
        return total;
    }
    
    public String getFinalGrade(){
        return Helper.computeCWGrade(getOverallMarks());
    }
    
    public String getCSVString() {
    	//TODO: return a string in the following format
    	//studentID,unitCode,a1,a2,exam
    	return this.getStudentID()+","+this.unitCode+","+this.a1+","+this.a2+","+this.exam;
    }
}
