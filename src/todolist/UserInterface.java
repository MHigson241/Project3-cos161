package todolist;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scnr = new Scanner(System.in);
		TaskManager taskManagment = new TaskManager();
		String str= "";
		int options = 10;
		while(run){
			printOptions();
			str = scnr.next();
			options = 10;
			//checks valid input
			if(!checkMenu(str, options)) {
				System.out.println("Invalid input");
				continue;
			}
			//what occurs for options 1-10
			if(str.equals("1")) {
				printAddOptions();
				str = scnr.next();
				options = 4;
				//checks valid input
				if(!checkMenu(str, options)) {
					System.out.println("Invalid input");
					continue;
				}
				if(str.equals("1")) {
					
				}else if(str.equals("2")) {
					
				}else if(str.equals("3")) {
					
				}else if(str.equals("4")) {
					System.out.println("Exiting to main menu");
					continue;
				}
			}else if(str.equals("2")) {
				
			}else if(str.equals("3")) {
				System.out.println("Enter the name of the Task you wish to mark completed:");
				str = scnr.next();
				if(taskManagment.findTask(str) == null) {
					System.out.println("Invalid task name.");
					continue;
				}
				taskManagment.completed(str);
				System.out.println("The task " + str + " was completed.");
			}else if(str.equals("4")) {
				System.out.println("Enter the name of the Task you wish to remove:");
				str = scnr.next();
				if(taskManagment.removeTask(str) == false) {
					System.out.println("Task Removed");
					continue;
				}
				System.out.println("Invalid task name.");
			}else if(str.equals("5")) {
				
			}else if(str.equals("6")) {
				
			}else if(str.equals("7")) {
				
			}else if(str.equals("8")) {
				
			}else if(str.equals("9")) {
				
			}else if(str.equals("10")) {
				System.out.println("Exiting program...");
				run = false;
			}		
		}
		scnr.close();
	}
	
	/**Prints the main menu options
	 * (Iris)
	 */
	public static void printOptions() {
		System.out.println("Enter 1-10 coresponding with the option you want:\n"
				+ "1. Add Task\n"
				+ "2. View All Tasks\n"
				+ "3. Complete Task\n"
				+ "4. Remove Task\n"
				+ "5. Undo Last Action\n"
				+ "6. Load Today’s Tasks (populate queue)\n"
				+ "7. View Task Queue\n"
				+ "8. Process Next Task\n"
				+ "9. Filter Tasks\n"
				+ "10. Exit");
	}
	/**prints out the add options menu
	 * (Iris)
	 */
	public static void printAddOptions() {
		System.out.println("Enter 1-4 coresponding with the option you want:\n"
				+ "1. Add Simple Task\n"
				+ "2. Add Recurring Task\n"
				+ "3. Add priority Task\n"
				+ "4. Exit");
	}

	
	/**checks to make sure the input is a # relevant to the options
	 * (Iris)
	 * 
	 * @param str	the text input
	 * @param options	the number of options for any given menu
	 * @return	true if valid input
	 */
	public static Boolean checkMenu(String str, int options) {
		for(int i = 1; i < options; i++) {
			if(str.equals(options + "")) {
				return true;
			}
		}
		return false;
	}

}
