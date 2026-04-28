package todolist;

import java.time.LocalDate;

/**Simple Task
 * (Maddy)
 * 
 * A basic task with no additional functionality
 */
public class SimpleTask extends Task
{
	public SimpleTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
	}
	@Override
	public String getTaskType() {
		return "Basic Task";
	}

	@Override
	public String getDetails() {
		return "Basic Task\n"+this.toString();
	}

}
