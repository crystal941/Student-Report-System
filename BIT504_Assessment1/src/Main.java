import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	
	// Attributes
	public static LinkedList<Student> allStudents;

	// Main method
	public static void main(String[] args) {
		
		// Initialise the allStudents LinkedList
		allStudents = new LinkedList<Student>();
		
		// Read the source file
		if(readFile("./studentdata.txt")) {
			boolean exit = false;
			while (!exit) {
				displayMenu();
				switch (selectMenuOption()) {
				case 1: {
					displayReportByMarks();
					break;
				}
				case 2: {
					displayReportByGrades();
					break;
				}
				case 3: {
					addNewStudent();
					break;
				}
				case 4: {
					removeStudent();
					break;
				}
				case 5: {
					System.out.println("Thank you for using the Student Report System. Goodbye!");
					exit = true;
					break;
				}
				} // end of switch
			}

		}
		else {
			// Provide an error message if the readFile() method returns false
			System.out.println("Failed to read the file. Please ensure the file is in the correct location.");
		}
	} // end of Main Method

	// Other methods
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static boolean readFile(String fileName) {
		
		// Access the file "studentdata.txt" in the same directory as the program
		File file = new File("./studentdata.txt");
		
		try {
			// Scan the source file by creating a Scanner object
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				// Declare a "words" array with the file data separated by commas
				String[] words = scanner.nextLine().split(",");
				
				// Declare variables with indexed elements in the array
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String secondName = words[2];
				int mathsMark1 = Integer.parseInt(words[3]);
				int mathsMark2 = Integer.parseInt(words[4]);
				int mathsMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				
				//Calling the addStudent method and passing the variable values
				addStudent(id, firstName, secondName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3);
			}
			scanner.close();
			return true;
		} 
		// Provide a message when catch an error that the file is not found
		catch (FileNotFoundException e) {
			return false;
		}
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void addStudent(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3) {
		
		// Create a new Student object and assign the values
		Student aStudent = new Student(id, firstName, lastName);
		
		// Create two AssessmentMarks objects for Maths and English
		AssessmentMarks maths = new AssessmentMarks("Maths", mathsMark1, mathsMark2, mathsMark3);
		AssessmentMarks english = new AssessmentMarks("English", englishMark1, englishMark2, englishMark3);
		
		// Passing the values of AssessmentMarks objects to the Student object
		aStudent.mathsMarks = maths;
		aStudent.englishMarks = english;
		
		// Add the Student object to the allStudents LinkedList
		allStudents.add(aStudent);
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void displayReportByMarks() {
		
		System.out.println("ID\tStudent Name\t Course\t A1\tA2\tA3\tAverage\t\tCourse\t A1\tA2\tA3\tAverage");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
		// use an enhanced for loop to iterate through the allStudents LinkedList and display the data
		for(Student s : allStudents) {
			System.out.println(s.id+"\t"+s.getFullName()+"\t "+s.mathsMarks.getCourseName()+"\t "+s.mathsMarks.getMark(1)+"\t"+s.mathsMarks.getMark(2)+"\t"+s.mathsMarks.getMark(3)+"\t"+ s.mathsMarks.getAverageMark()+"\t\t"+ s.englishMarks.getCourseName()+ "\t "+s.englishMarks.getMark(1)+"\t"+s.englishMarks.getMark(2)+"\t"+s.englishMarks.getMark(3)+"\t"+s.englishMarks.getAverageMark());
		}
		
	} 
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void displayReportByGrades() {
		System.out.println("ID\tStudent Name\t Course\t A1\tA2\tA3\tAverage\t\tCourse\t A1\tA2\tA3\tAverage");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
		// use an enhanced for loop to iterate through the allStudents LinkedList and display the data
		for(Student s : allStudents) {
			System.out.println(s.id+"\t"+s.getFullName()+"\t "+s.mathsMarks.getCourseName()+"\t "+s.mathsMarks.getGrade(1)+"\t"+s.mathsMarks.getGrade(2)+"\t"+s.mathsMarks.getGrade(3)+"\t"+ s.mathsMarks.getAverageGrade()+"\t\t"+s.englishMarks.getCourseName()+"\t "+s.englishMarks.getGrade(1)+"\t"+s.englishMarks.getGrade(2)+"\t"+s.englishMarks.getGrade(3)+"\t"+s.englishMarks.getAverageGrade());
		}
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void displayMenu() {
		System.out.println("----------------------------\nStudent Report System\n----------------------------");
		System.out.println("1) Display student marks\n2) Display student grades\n3) Add new student\n4) Remove student\n5) Exit");
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static int selectMenuOption() {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		boolean menu = false;
		do {
			System.out.print("----------------------------\nPlease enter your option:");
			option = scanner.nextInt();
			menu = true;
			
			// Validate user input and provide an error message			
			if (option < 1 || option > 5) {
				System.out.println("Invalid input. Please try again.");
			}
		}
			while (!menu);
			return option;
	}  
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void addNewStudent() {
		
		// Create and initialise the variables
		int mathsMark1 = 0, mathsMark2 = 0, mathsMark3 = 0, englishMark1 = 0, englishMark2 = 0, englishMark3 = 0;
		
		// Scan the user input and create variables
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the student's id:");
		int id = scanner.nextInt();
		System.out.println("Please enter the student's first name:");
		String firstName = scanner.next();
		System.out.println("Please enter the student's last name:");
		String lastName = scanner.next();
		
		// Create a new Student object and assign the values
		Student aStudent = new Student(id, firstName, lastName);
		
		// Create two AssessmentMarks objects for Maths and English
		AssessmentMarks maths = new AssessmentMarks("Maths", mathsMark1, mathsMark2, mathsMark3);
		AssessmentMarks english = new AssessmentMarks("English", englishMark1, englishMark2, englishMark3);
		
		// Scan the user input and use the Setter to assign the values to the variables
		System.out.println("Please enter the student's mark for Maths Assessment1:");
		mathsMark1 = scanner.nextInt();
		maths.setMark(1, mathsMark1);
		System.out.println("Please enter the student's mark for Maths Assessment2:");
		mathsMark2 = scanner.nextInt();
		maths.setMark(2, mathsMark2);
		System.out.println("Please enter the student's mark for Maths Assessment3:");
		mathsMark3 = scanner.nextInt();
		maths.setMark(3, mathsMark3);
		System.out.println("Please enter the student's mark for English Assessment1:");
		englishMark1 = scanner.nextInt();
		english.setMark(1, englishMark1);
		System.out.println("Please enter the student's mark for English Assessment2:");
		englishMark2 = scanner.nextInt();
		english.setMark(2, englishMark2);
		System.out.println("Please enter the student's mark for English Assessment3:");
		englishMark3 = scanner.nextInt();
		english.setMark(3, englishMark3);

		// Passing the values of AssessmentMarks objects to the Student object
		aStudent.mathsMarks = maths;
		aStudent.englishMarks = english;
		
		// Add the Student object to the allStudents LinkedList
		allStudents.add(aStudent);
		
		// Provide a confirmation message for the user
		System.out.println("You have successfully added the student: "+firstName+" "+lastName+"\nThank you!");
	}
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void removeStudent() {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		boolean delete = false;
		do {
			System.out.println("Please enter the student's id that you want to remove:");
			int id = scanner.nextInt();
			
			// Iterate through the LinkedList to find the student by matching the student ID
			for (int i = 0; i < allStudents.size(); i++) {
				if (id == allStudents.get(i).id) {
					name = allStudents.get(i).getFullName();
					
					// Provide a message for the user to confirm to delete
					System.out.println("Warning! Are you sure to delete the student: " + name + "? Y/N");
					String option = scanner.next();
					
					// Delete the student from the LinkedList when user confirms
					if (option.equals("Y")|| option.equals("y")) {
						allStudents.remove(i);
						System.out.println("You have successfully deleted the student: " + name +"\nThank you!");
						delete = true;
					}
					else {
						delete = false;
					}
				}
			}
		}
				while (!delete);							
	}
	
}// end of Class





