package lab7;

public class Student {

	//Name
	//Student ID
	//Credits
	//GPA

	private String firstName;
	private String lastName;
	private int stuID;
	private int credits;
	private double GPA;
	private double score;
	
	
	
	
	

	public Student(String firstName, String lastName, int stuID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.stuID = stuID;
		this.credits = 0;
		this.GPA = 0;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	public int getStudentID() {
		return stuID;
	}

	public int getCredits() {
		return credits;
	}

	public double getGPA() {
		return GPA;
	}

	public double getScore() {
		return score;
	}

	public String getClassStanding(){
		if (this.credits < 30){
			return "Freshman";
		}
		else if (this.credits < 60){
			return "Sophomore";
		}
		else if (this.credits < 90){
			return "Junior";
		}
		else{
			return "Senior";
		}
	}

	public void submitGrade(double grade, int creds){
		double score = (grade*creds);
		this.credits = this.credits + creds;
		this.score = this.score + score;
		this.GPA = ((double)(Math.round(1000*(this.score/this.credits))))/1000.0;
	}
	
	public Student createLegacy(Student s2){
		String babyFirstName = this.getName();
		String babyLastName = s2.getName();
		Student baby = new Student(babyFirstName, babyLastName, this.stuID);
		baby.setStudentID(this.getStudentID() + s2.getStudentID());
		baby.setGPA((this.getGPA() + s2.getGPA())/2);
		if (this.getCredits() > s2.getCredits()){
			baby.setCredits(this.credits);
		}
		else{
			baby.setCredits(s2.credits);
		}
		return baby;
	}
	
	private void setStudentID(int i) {
		this.stuID = i;
	}

	private void setCredits(int credits2) {
		this.credits = credits2;
		
	}

	private void setGPA(double d) {
		this.GPA = d;
	}

	public String toString(){
		return "Student Name: " + this.firstName + " h" + this.lastName + "ID: " + this.stuID;
	}



public static void main(String[] args){
Student s1 = new Student("Ron", "Cytron", 12345);
}
}





