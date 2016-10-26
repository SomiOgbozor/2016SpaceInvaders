package lab7;

public class Course {

	public String name;
	public double credits;
	public int numSeats;
	public int seatsAvaliable;
	public Student[] stuRoster;


	public Course(String name, double credits, int numSeats) {
		this.name = name;
		this.credits = credits;
		this.numSeats = numSeats;
		this.stuRoster = new Student[numSeats];
		this.seatsAvaliable = numSeats;
	}

	public String getName() {
		return name;
	}

	public double getCredits() {
		return credits;
	}

	public int getNumSeats() {
		return numSeats;
	}
	
	public int getRemainingSeats() {
		return seatsAvaliable;
	}


	public Student[] getStuRoster() {
		return stuRoster;
	}

	public boolean addStudent(Student s1){
		for (int i=0; i < stuRoster.length; i++){
			if ( s1 == stuRoster[i]){
				return false;
			}
		}
		if (this.seatsAvaliable == 0){
			return false;
		}
		else{
			stuRoster[numSeats-seatsAvaliable] = s1;
			this.seatsAvaliable = (this.seatsAvaliable) - 1;
			return true;
		}
	}
	
	public void generateRoster(){
		for (int i=0; i < numSeats; i++){
			System.out.println(this.stuRoster[i].getName() + this.stuRoster[i].getStudentID());
		}
	}
	
	public double averageGPA(){
		double totalCredits = 0;
		double totalGPA = 0;
		for (int i=0; i < (numSeats-seatsAvaliable); i++){
			totalCredits = totalCredits + stuRoster[i].getCredits();
			totalGPA = totalGPA + (stuRoster[i].getGPA());
		}
		double averageGPA = totalGPA/(totalCredits);
		return averageGPA;
		
	}
	
	public String toString(){
		return "Course: " + this.name + "Number of credits: " + this.credits;
	}
}


