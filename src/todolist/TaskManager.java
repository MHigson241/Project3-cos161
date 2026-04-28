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
 */
public class TaskManager {
	public MyArrayList<Task> toDo = new MyArrayList<>();
	
	/**adds a simple task
	 * (Iris)
	 * @param title
	 * @param description
	 * @param dueDate
	 */
	public void addSimpleTask(String title, String description, LocalDate dueDate) {
		Task t = new SimpleTask(title, description, dueDate);
		toDo.add(t);
	}
	
	/**Removes a simple task given it's title
	 * (Iris)
	 * @param title the titla of the task being removed
	 */
	public Boolean removeSimpleTask(String title) {
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
	
}
