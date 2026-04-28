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
 * 
 * Methods:
 * 	-markComplete()			Sets complete to true
 * 	-toString()				Returns all attributes compiled into a string
 * 	-getTaskType()			Returns the type of task as a string
 * 	-getDetails()			Returns the task type and the output of the toString() method
 * 	-(Getters and setters for all attributes)
 */
public abstract class Task implements Comparable<Task>
{
	protected String title;
	protected String description;
	protected boolean completed = false;
	protected LocalDate dueDate;
	
	@Override
    public int compareTo(Task other) {
		if(this.dueDate.getDayOfYear() < other.dueDate.getDayOfYear()) {
			return -1;
		}else if(this.dueDate.getDayOfYear() > other.dueDate.getDayOfYear()) {
			return 1;
		}else {
			return 0;
		}
	}
	
	protected Task(String title, String description, LocalDate dueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
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
	
	public String toString()
	{
		String str = title+"\n";
		str += description+"\n";
		str += "Due "+dueDate+"\n";
//		str += "Priority: "+priority+"\n";
		if (completed) str += "Completed";
		else str += "Pending";
		
		return str;
	}
	
	public abstract String getTaskType();
	
	public abstract String getDetails();
	
}
