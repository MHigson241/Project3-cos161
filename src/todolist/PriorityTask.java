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
	
	@Override
	public String toString()
	{
		String str = title+"\n";
		str += description+"\n";
		str += "Due "+dueDate+"\n";
		str += "Priority: "+priority+"\n";
		if (completed) str += "Completed";
		else str += "Pending";
		
		return str;
	}
	
	@Override
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	@Override
	public int getPriority()
	{
		return priority;
	}

}
