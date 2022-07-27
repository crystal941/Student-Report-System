
public class Student {

	// Attributes
	public int id;
	public String firstName, lastName;
	public AssessmentMarks mathsMarks;
	public AssessmentMarks englishMarks;
	
	// Constructor
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Public getter method
	// get student's full name
	public String getFullName() {
		String fullName = firstName + " " + lastName; 
		return fullName;
	}

} // end of Class 