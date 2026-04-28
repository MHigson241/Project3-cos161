package todolist;

/**Recurring
 * (Maddy)
 * 
 * Methods:
 * 	-setRecurrencePattern(String pattern)	Sets the interval the task should repeat on
 * 	-getRecurrencePattern()					Returns the recurrence pattern as a String
 */
public interface Recurring 
{
	public void setRecurrencePattern(String pattern);
	
	public String getRecurrencePattern();
}
