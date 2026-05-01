package todolist;

import java.time.LocalDate;
import java.util.Scanner;

import myds.MyArrayList;

public class UserInterface {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scnr = new Scanner(System.in);
		TaskManager taskManagment = new TaskManager();
		TaskProcessing taskProcess = new TaskProcessing();
		String title = "";
		String pattern = "Daily";
		String description = "";
		LocalDate dueDate = LocalDate.now();
		int days = 0;
		int priority = 0;
		String str= "";
		int options = 10;
		MyArrayList<Task> filter = null;
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
			if(str.equals("1")) {//add task
				printAddOptions();
				str = scnr.next();
				options = 4;
				//checks valid input
				if(!checkMenu(str, options)) {
					System.out.println("Invalid input");
					continue;
				}
				if(str.equals("1")) {//simple
					System.out.println("Enter the name of the Task:");
					title = scnr.next();
					System.out.println("Enter a description for the Task:");
					description = scnr.next();
					System.out.println("Enter in how many days you want the Task to be due:");
					if(scnr.hasNextInt()) {
						days = scnr.nextInt();
					}else {
						System.out.println("Please try again with a real number");
						scnr.next();
						continue;
					}
					Task t = new SimpleTask(title, description, dueDate.plusDays(days));
					taskManagment.toDo.add(t);
				}else if(str.equals("2")) {//recurring
					System.out.println("Enter the name of the Task:");
					title = scnr.next();
					System.out.println("Enter a description for the Task:");
					description = scnr.next();
					System.out.println("Enter in how many days you want the Task to be due:");
					if(scnr.hasNextInt()) {
						days = scnr.nextInt();
					}else {
						System.out.println("Please try again with a real number");
						scnr.next();
						continue;
					}
					System.out.println("Enter 1-3 coresponding with the option you want:\n"
							+ "1. Daily\n"
							+ "2. Weekly\n"
							+ "3. Monthly");
					str = scnr.next();
					if(str.equals(1 + "")) {
						pattern = "Daily";
					}else if(str.equals(2 + "")) {
						pattern = "Weekly";
					}else if(str.equals(3 + "")) {
						pattern = "Monthly";
					}else {
						System.out.println("Invalid input");
					}
					Task t = new RecurringTask(title, description, dueDate.plusDays(days), pattern);
					taskManagment.toDo.add(t);
				}else if(str.equals("3")) {//priority
					System.out.println("Enter the name of the Task:");
					title = scnr.next();
					System.out.println("Enter a description for the Task:");
					description = scnr.next();
					System.out.println("Enter in how many days you want the Task to be due:");
					if(scnr.hasNextInt()) {
						days = scnr.nextInt();
					}else {
						System.out.println("Please try again with a real number");
						scnr.next();
						continue;
					}
					System.out.println("Enter a number 1-10 for the priority:");
					if(scnr.hasNextInt()) {
						priority = scnr.nextInt();
					}else {
						System.out.println("Please try again with a real number");
						scnr.next();
						continue;
					}
					if (priority >=1 && priority <= 10) {
						Task t = new PriorityTask(title, description, dueDate.plusDays(days), priority);
						taskManagment.toDo.add(t);
					}else {
						System.out.println("Invalid input");
					}
				}else if(str.equals("4")) {//exit to main menu
					System.out.println("Exiting to main menu");
					continue;
				}
			}else if(str.equals("2")) {//view tasks
				if(taskManagment.toDo.size() == 0) {
					System.out.println("No tasks to display");
				}
				taskManagment.displayTasks();
				run = continueMenu(scnr);
			}else if(str.equals("3")) {//complete task
				if(taskManagment.toDo.size()==0) {
					System.out.println("No tasks found");
					continue;
				}
				System.out.println("Enter the name of the Task you wish to mark completed:");
				str = scnr.next();
				if(taskManagment.findTask(str) == null) {
					System.out.println("Invalid task name.");
					continue;
				}
				taskManagment.completed(str);
				System.out.println("The task " + str + " was completed.");
				run = continueMenu(scnr);
			}else if(str.equals("4")) {//remove task
				if(taskManagment.toDo.size()==0) {
					System.out.println("No tasks found");
					continue;
				}
				System.out.println("Enter the name of the Task you wish to remove:");
				str = scnr.next();
				if(taskManagment.removeTask(str) == true) {
					System.out.println("Task Removed");
				}else {
					System.out.println("Invalid task name.");
				}
				run = continueMenu(scnr);
				continue;
			}else if(str.equals("5")) {//undo action
				taskManagment.undo();
				run = continueMenu(scnr);
			}else if(str.equals("6")) {//load todays tasks
				taskProcess.loadTasks();
				if(taskProcess.tasks.size() == 0) {
					System.out.println("No Tasks loaded");
					continue;
				}else {
					System.out.println("Tasks loaded");
				}
				run = continueMenu(scnr);
			}else if(str.equals("7")) {//view tasks for today
				if(taskProcess.tasks.size() == 0) {
					System.out.println("No Tasks to view");
					continue;
				}
				taskProcess.viewTasks();
				run = continueMenu(scnr);
			}else if(str.equals("8")) {//process next task
				if(taskProcess.tasks.size() == 0) {
					System.out.println("No Tasks to process");
					continue;
				}
				System.out.println("Enter 1 to mark task complete enter anything but 1 to continue:");
				str = scnr.next();
				if(str.equals(1 + "")) {
					taskProcess.processTask(true);
				}else {
					taskProcess.processTask(false);
				}
				run = continueMenu(scnr);
			}else if(str.equals("9")) {//filter tasks
				filter = null;
				System.out.println("Enter 1-3 coresponding with the option you want:\n"
						+ "1. Filter by Completed\n"
						+ "2. Filter by Priority\n"
						+ "3. Filter by Type");
				str = scnr.next();
				if(str.equals(1 + "")) {
					
					filter = taskManagment.filterByCompleted(true);
				}else if(str.equals(2 + "")) {
					System.out.println("Enter the priority 1-10 you wish to see:");
					options = 10;
					str = scnr.next();
					if(checkMenu(str, options)) {
						filter = taskManagment.filterByPriority(Integer.parseInt(str));
					}
				}else if(str.equals(3 + "")) {
					System.out.println("Enter 1-3 coresponding with the option you want:\n"
							+ "1. Simple tasks\n"
							+ "2. Priority tasks\n"
							+ "3. Recurring tasks");
					str = scnr.next();
					if(str.equals(1 + "")) {
						filter = taskManagment.filterByType(1);
					}else if(str.equals(2 + "")) {
						filter = taskManagment.filterByType(2);
					}else if(str.equals(3 + "")) {
						filter = taskManagment.filterByType(3);
					}else {
						System.out.println("Invalid Input");
					}
				}else {
					System.out.println("Invalid input");
				}
				if(filter != null) {
					for(Task t : filter) {
						System.out.println("----------------------------------------------------");
						System.out.println(t.toString());
						System.out.println("----------------------------------------------------");
					}
				}else {
					System.out.println("Error: no found filter");
				}
			}else if(str.equals("10")) {//exit
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

	/**menu for deciding where to go next
	 * 
	 * @param str	user input 1 is return to menu 2 is quit all other input errors to main menu
	 * @return	true to continue false to end
	 */
	public static Boolean continueMenu(Scanner scnr) {
		System.out.println("Enter 1-2 coresponding with the option you want:\n"
				+ "1. Return to main menu\n"
				+ "2. Exit");
		String st = scnr.next();
		if(st.equals(1 + "")) {
			return true;
		}else if(st.equals(2 + "")) {
			return false;
		}else {
			System.out.println("Invalid input: returning to main menu.");
			return true;
		}
	}
	/**checks to make sure the input is a # relevant to the options
	 * (Iris)
	 * 
	 * @param str	the text input
	 * @param options	the number of options for any given menu
	 * @return	true if valid input
	 */
	public static Boolean checkMenu(String str, int options) {
		for(int i = 1; i <= options; i++) {
			if(str.equals(i + "")) {
				return true;
			}
		}
		return false;
	}

}
