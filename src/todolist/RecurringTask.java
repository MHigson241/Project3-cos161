package todolist;

import java.time.LocalDate;

/**Recurring Task
 * (Maddy)
 * 
 * A task that will repeat on a specified interval
 */
public class RecurringTask extends Task implements Recurring
{
	public RecurringTask(String title, String description, LocalDate dueDate, String recurrencePattern) {
		super(title, description, dueDate);
		this.recurrencePattern = recurrencePattern;
	}
	private String recurrencePattern;
	
	@Override
	public String getTaskType()
	{
		return "Recurring Task";
	}

	@Override
	public String getDetails()
	{
		return "Recurring Task\n"+this.toString();
	}

	@Override
	public void setRecurrencePattern(String pattern) 
	{
		recurrencePattern = pattern;
	}

	@Override
	public String getRecurrencePattern()
	{
		return recurrencePattern;
	}

}
