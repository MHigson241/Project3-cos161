package todolist;

import java.time.LocalDate;

/**Priority Task
 * (Maddy)
 * 
 * A task with that can have a specific priority level (Lower number means more urgent)
 */
public class PriorityTask extends Task implements Prioritizable
{
	private int priority;
	
	public PriorityTask(String title, String description, LocalDate dueDate, int priority) {
		super(title, description, dueDate);
		this.priority = priority;
	}
	
	@Override
	public String getTaskType() {
		return "Priority Task";
	}

	@Override
	public String getDetails() {
		return "Priority Task\n"+this.toString();
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public int getPriority()
	{
		return priority;
	}

}
