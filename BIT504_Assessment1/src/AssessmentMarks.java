import java.util.Scanner;

public class AssessmentMarks {

	// Attributes
	private String courseName;
	private int assessment1, assessment2, assessment3;
	
	// Constructor
	public AssessmentMarks (String courseName, int mark1, int mark2, int mark3) {
		this.courseName = courseName;
		this.assessment1 = mark1;
		this.assessment2 = mark2;
		this.assessment3 = mark3;
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public setter methods
	// a setter that is used to update value of assessment variables by using assessmentNumber as conditions
	public void setMark (int assessmentNumber, int mark) {
		
		// validate the user's input
		while (mark < 0 || mark > 100) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Invalid input. Please try again.");
			mark = scanner.nextInt();
		}
		
		// assign the values to the variables if the input is between 0 and 100
			switch(assessmentNumber){
			case 1: {
				assessment1 = mark;
				break;
			}
			case 2: {
				assessment2 = mark;
				break;
			}
			case 3: {
				assessment3 = mark;
				break;
			}
			}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// a setter that is used to update value of courseName variable
	public void setCourseName (String name) {
		this.courseName = name;
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public getter methods
	// a getter to retrieve the value of courseName variable
	public String getCourseName () {
		return courseName;
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// a getter to retrieve the value of assessment variables by providing assessmentNumber
	public int getMark(int assessmentNumber) {
		switch(assessmentNumber) {
		case 1: {
			return assessment1;
		}
		case 2: {
			return assessment2;
		}
		case 3: {
			return assessment3;
		}
		default: {
			return 0;
		}
		}
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Other methods
	// Calculate average mark for the course
	public double getAverageMark() {
		double averageMark = (assessment1+assessment2+assessment3)/3;
		return averageMark;
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// a method to get the grade for an assessment by providing the assessmentNumber
	public String getGrade(int assessmentNumber) {
		
		// get the mark of an assessment by using getMark method
		// get the grade of the mark by using the markToGrade method
		switch(assessmentNumber) {
		case 1: {
			return markToGrade(getMark(1));
		}
		case 2: {
			return markToGrade(getMark(2));
		}
		case 3: {
			return markToGrade(getMark(3));
		}
		default: {
			return "Invalid Input.Please try again.";
		}
		}
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// a method to get the average grade for the course
	public String getAverageGrade() {
		// get the average mark of the course
		double averageMark = getAverageMark();
		// round the average mark to an integer 
		int roundMark = (int) Math.round(averageMark);
		// get the grade of the average mark by using the markToGrade method
		return markToGrade(roundMark);
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// a method to return the grade based on the mark given
	public String markToGrade(int mark) {
		String grade;
		if (mark >= 95 && mark <= 100) {
			grade = "A+";
		}
		else if (mark >= 90) {
			grade = "A";
		}
		else if (mark >= 85) {
			grade = "A-";
		}
		else if (mark >= 80) {
			grade = "B+";
		}
		else if (mark >= 75) {
			grade = "B";
		}
		else if (mark >= 70) {
			grade = "B-";
		}
		else if (mark >= 60) {
			grade = "C+";
		}
		else if (mark >= 50) {
			grade = "C";
		}
		else if (mark >= 41) {
			grade = "C-";
		}
		else {
			grade = "D";
		}
		return grade;
	}
}
