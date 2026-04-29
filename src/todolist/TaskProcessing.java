package todolist;

import java.util.LinkedList;
import java.util.Queue;

/**Task Processing
 * (Iris)
 * 
 * Attributes:
 * -TaskManager t	A instance of TaskManager
 * -Queue<Task> tasks	A queue for holding recurring tasks
 * Methods:
 * -viewTasks()	Loads all recurring tasks for into the queue
 * -loadTasks()	gives all items in the queue
 * - 
 */
public class TaskProcessing {
	public Queue<Task> tasks = new LinkedList<Task>();
	TaskManager t = new TaskManager();
	
	/**Loads all recurring tasks for into the queue
	 * (Iris)
	 */
	public void loadTasks() {
		tasks = new LinkedList<Task>();
		for(int i = 0; i < t.toDo.size()-1; i++) {
			if(t.toDo.get(i).getTaskType().equals("Recurring Task")) {
				tasks.offer(t.toDo.get(i));
			}
		}
	}
	/**gives all items in the queue
	 * (Iris)
	 * 
	 * @return	a string of all items in queue
	 */
	public String viewTasks() {
		String str = "";
		Queue<Task> view = tasks;
		for(int i = 0; i < view.size()-1; i++) {
			str += view.remove().toString() + "\n ---------------------";
		}
		return str;
	}
	
}
