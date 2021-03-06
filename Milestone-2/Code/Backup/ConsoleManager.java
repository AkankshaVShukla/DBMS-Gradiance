

import java.io.IOException;
import java.util.Scanner;

class ConsoleManager {
	
	private static ConsoleManager consoleManager;
	
	private Scanner sc;
	
	private ConsoleManager(){
		// Make it singleton
		sc = new Scanner(System.in);
	}
	
	public static ConsoleManager getConsoleCreator(){
		if(consoleManager == null) consoleManager = new ConsoleManager();
		return consoleManager;
	}
	
	public void createStartConsole(){
		clearScreen();
		System.out.println("1. Login");
		System.out.println("2. Exit");
	}
	
	
	// Method stack for professor
	public void createProfessorHomeScreen(){
		clearScreen();
		System.out.println("1. View Profile");
		System.out.println("2. View/Add Courses");
		System.out.println("3. Enroll/Drop A Student");
		System.out.println("4. Search/Add questions to Question Bank");
		System.out.println("5. Logout");
	}
	
	public void showProfOrTAProfile(String fName, String lName, String eId){
		clearScreen();
		System.out.println("Press 0 to Go Back");
		System.out.println("1. First Name: " + fName);
		System.out.println("2. Last Name: " + lName);
		System.out.println("3. Employee Id: " + eId);
	}
	
	
	// Method stack for TA
	public void createTAHomeScreen(){
		clearScreen();
		System.out.println("1. View Profile");
		System.out.println("2. View/Add Courses");
		System.out.println("3. Enroll/Drop A Student");
		System.out.println("4. Logout");			
	}
	
	
	// Method stack for Student
	public void createStudentHomeScreen(){
		clearScreen();
		System.out.println("1. View/Edit Profile");
		System.out.println("2. View Courses");
		System.out.println("3. Logout");
	}
	
	public void clearScreen(){
		try {
			// Clear the screen
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int askForInput(String message){
		int choice;
		
		if (message != null){
			System.out.println(message);
		}
		
		choice = sc.nextInt();
		
		return choice;
	}
	
	@Override
	protected void finalize() throws Throwable {
	    try {
	        sc.close();
	    } finally {
	        super.finalize();
	    }
	}
	
	public void displayInvalidChoiceError(){
		System.out.println("Please select a valid option!");
	}
}
