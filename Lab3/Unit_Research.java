public class Unit_Research extends Unit{
    
    private double proposal;
    private double finalDissertation;

    public Unit_Research(String studentID, double proposal, double finalDissertation) {
        super(studentID,"R");
        this.proposal = proposal;
        this.finalDissertation = finalDissertation;
    }
    
    public double getOverallMarks(){
    	//TODO: calculate research overall marks;
        double total=0.0;
        total = (this.proposal*0.3)+(this.finalDissertation*0.7);
        return total;
    }
    
    public String getFinalGrade(){
    	return Helper.computeCWGrade(getOverallMarks());
    }
    
    public String getCSVString() {
    	//TODO: return a string in the following format
    	//studentID,proposal,finalDissertation
    	return this.getStudentID()+","+this.proposal+","+this.finalDissertation;
        
   
    }
   
}
