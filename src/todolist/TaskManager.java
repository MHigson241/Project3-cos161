package todolist;

import java.time.LocalDate;
import myds.MyArrayList;

/**Task Manager
 * (Iris and Maddy)
 * 
 * Attributes:
 * -MyArrayList<Task> toDo the toDo list of all tasks
 * 
 * Methods:
 * -addSimpleTask(String title, String description, LocalDate dueDate)	adds a simple task
 * -addPriorityTask(String title, String description, LocalDate dueDate, int priority)	adds a priorit task
 * -addRecurringTask(String title, String description, LocalDate dueDate, String recurring) adds a recurring task
 * -removeTask(String title)	removes a task
 * -findTask(String title)	finds a task
 * -completed(String title)	marks a task as completed
 */
public class TaskManager {
	public MyArrayList<Task> toDo = new MyArrayList<>();
	
	/**adds a simple task
	 * (Iris)
	 * @param title			name of task
	 * @param description	task description
	 * @param dueDate		the date that the task is due
	 */
	public void addSimpleTask(String title, String description, LocalDate dueDate) {
		Task t = new SimpleTask(title, description, dueDate);
		toDo.add(t);
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
	}
}
