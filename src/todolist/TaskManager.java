package todolist;

import java.time.LocalDate;
import java.util.Stack;

import myds.MyArrayList;

/**Task Manager
 * (Iris and Maddy)
 * 
 * Attributes:
 * -MyArrayList<Task> toDo the toDo list of all tasks
 * 
 * Methods:
 * -addSimpleTask(String title, String description, LocalDate dueDate)						adds a simple task
 * -addPriorityTask(String title, String description, LocalDate dueDate, int priority)		adds a priorit task
 * -addRecurringTask(String title, String description, LocalDate dueDate, String recurring) adds a recurring task
 * -removeTask(String title)	removes a task
 * -findTask(String title)		finds a task
 * -completed(String title)		marks a task as completed
 * -undo()			Undoes the last action taken
 * -displayTasks()	Displays all tasks in toDo list
 * -filterByCompleted(boolean completed)	Creates a list of all tasks matching the input completed status
 * -filterByType(int typeN)					Creates a list of all tasks matching the input type (1 = basic task, 2 = priority task, 3 = recurring task)
 * -filterByPriority(int priority)			Creates a list of all tasks matching the input priority level
 */
public class TaskManager {
	public MyArrayList<Task> toDo = new MyArrayList<>();
	public Stack<Action> recent = new Stack<>();
	
	/**adds a simple task
	 * (Iris)
	 * @param title			name of task
	 * @param description	task description
	 * @param dueDate		the date that the task is due
	 */
	public void addSimpleTask(String title, String description, LocalDate dueDate) {
		Task t = new SimpleTask(title, description, dueDate);
		toDo.add(t);
		recent.push(new Action(t, 1));	//Add to recent actions stack for undo functionality (Maddy)
	}
	/**adds a priority task
	 * 
	 * @param title			name of task
	 * @param description	taask description
	 * @param dueDate		the date that the task is due
	 * @param priority		the priority of the task 0-10
	 */
	public void addPriorityTask(String title, String description, LocalDate dueDate, int priority) {
		Task t = new PriorityTask(title, description, dueDate, priority);
		toDo.add(t);
		recent.push(new Action(t, 1));	//Add to recent actions stack for undo functionality (Maddy)
	}
	/**adds a recurring task
	 * 
	 * @param title			name of task
	 * @param description	taask description
	 * @param dueDate		the date that the task is due
	 * @param recurring		how often it occurs
	 */
	public void addRecurringTask(String title, String description, LocalDate dueDate, String recurring) {
		Task t = new RecurringTask(title, description, dueDate, recurring);
		toDo.add(t);
		recent.push(new Action(t, 1));	//Add to recent actions stack for undo functionality (Maddy)
	}
	
	/**Removes a  task given it's title
	 * (Iris)
	 * @param title the titla of the task being removed
	 */
	public Boolean removeTask(String title) {
		Task t = findTask(title);
		if(t == null) {
			return false;
		}
		toDo.remove(t);
		recent.push(new Action(t, 2));	//Add to recent actions stack for undo functionality (Maddy)
		return true;
	}
	
	/**finds a task based on title
	 * (Iris)
	 * @param title	the task being searched for
	 * @return	returns a task or null if not found
	 */
	public Task findTask(String title) {
		for(int i = 0; i < toDo.size()-1; i++) {
			if(toDo.get(i).getTitle().equals(title)) {
				return toDo.get(i);
			}
		}
		return null;
	}
	
	/**Marks a task complete
	 * (Iris)
	 * @param title	the name of the task being completed
	 */
	public void completed(String title) {
		Task t = findTask(title);
		if(t == null) {
			return;
		}
		t.markComplete();
		recent.push(new Action(t, 3));	//Add to recent actions stack for undo functionality (Maddy)
	}
	
	/**Undo
	 * (Maddy)
	 * 
	 * Undoes the most recent action added to the recent actions stack
	 */
	public void undo()
	{
		Action act = recent.pop();	//Pop most recent action off the recent actions stack
		Task t = act.getTask();		//Get the task being acted upon
		int type = act.getType();	//Get the type of action (1 = add task, 2 = remove task, 3 = mark task as complete)
		
		if (type == 1) toDo.remove(t);			//Undo add task
		
		else if (type == 2) toDo.add(t);		//Undo remove task
		
		else if (type == 3) t.undoComplete();	//Undo mark task as complete
	}
	
	/** Display Tasks
	 * (Maddy)
	 * 
	 * Prints every task in the toDo list
	 */
	public void displayTasks()
	{
		for (Task t : toDo) 
		{
			System.out.println("----------------------------------------------------");
			System.out.println(t.toString());
			System.out.println("----------------------------------------------------");
		}
	}
	
	/**Filter By Completed
	 * (Maddy)
	 * 
	 * Creates a list of all tasks matching the input completed status
	 * 
	 * @param completed						The completion status to filter for
	 * @return MyArrayList<Task> filtered	A list of all matching tasks
	 */
	public MyArrayList<Task> filterByCompleted(boolean completed)
	{
		MyArrayList<Task> filtered = new MyArrayList<>();
		
		//Add each task matching completed status to filtered list
		for (Task t : toDo)
		{
			if (t.getCompleted() == completed) filtered.add(t);
		}
		return filtered;
	}
	
	/**Filter By Type
	 * (Maddy)
	 * 
	 * Creates a list of all tasks matching the input type (1 = basic task, 2 = priority task, 3 = recurring task)
	 * 
	 * @param typeN							The type to filter for
	 * @return MyArrayList<Task> filtered	A list of all matching tasks
	 */
	public MyArrayList<Task> filterByType(int typeN)
	{
		MyArrayList<Task> filtered = new MyArrayList<>();
		
		//Get type as a string
		String type = "";
		if (typeN == 1) type = "Basic Task";
		else if (typeN == 2) type = "Priority Task";
		else if (typeN == 3) type = "Recurring Task";
		
		//Add each task matching input type to filtered list
		for (Task t : toDo)
		{
			if (t.getTaskType().equals(type)) filtered.add(t);
		}
		return filtered;
	}
	
	/**Filter By Priority
	 * (Maddy)
	 * 
	 * Creates a list of all tasks matching the input priority level
	 * 
	 * @param priority						The priority level to filter for
	 * @return MyArrayList<Task> filtered	A list of all matching tasks
	 */
	public MyArrayList<Task> filterByPriority(int priority)
	{
		MyArrayList<Task> filtered = new MyArrayList<>();
		
		for (Task t : toDo)
		{
			if (t.getTaskType().equals("Priority Task"))
			{
				PriorityTask task = (PriorityTask) t;
				if (task.getPriority() == priority) filtered.add(task);
			}
		}
		return filtered;
	}
}
