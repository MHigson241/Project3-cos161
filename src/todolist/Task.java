package todolist;

import java.time.LocalDate;

/**Task
 * (Maddy)
 * 
 * Attributes:
 * 	-String title			The name of the task
 * 	-String description		A description of the task
 * 	-boolean completed		True if completed, false if pending
 * 	-LocalDate dueDate		The date the task should be completed by
 * 	-int priority			The priority level of the task (Lower number means more urgent)
 * 
 * Methods:
 * 	-markComplete()			Sets complete to true
 * 	-toString()				Returns all attributes compiled into a string
 * 	-getTaskType()			Returns the type of task as a string
 * 	-getDetails()			Returns the task type and the output of the toString() method
 * 	-(Getters and setters for all attributes)
 */
public abstract class Task 
{
	private String title;
	private String description;
	private boolean completed = false;
	private LocalDate dueDate;
	private int priority;
	
	public void markComplete()
	{
		completed = true;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public boolean getCompleted()
	{
		return completed;
	}

	public LocalDate getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate)
	{
		this.dueDate = dueDate;
	}

	public int getPriority()
	{
		return priority;
	}

	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
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
	
	public abstract String getTaskType();
	
	public abstract String getDetails();
	
}
