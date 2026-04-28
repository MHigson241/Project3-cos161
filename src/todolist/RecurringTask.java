package todolist;

/**Recurring Task
 * (Maddy)
 * 
 * A task that will repeat on a specified interval
 */
public class RecurringTask extends Task implements Recurring
{
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
