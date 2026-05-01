package todolist;

/**Action
 * (Maddy)
 * 
 * An action to hold in the recent actions stack for undo functionality
 * 
 * Attributes:
 * -Task task	The task being acted upon
 * -int type	The type of action taken (1 = add task, 2 = remove task, 3 = mark task completed)
 * 
 * Methods:
 * (Just the constructor and a getter for each attribute)
 */
public class Action {
	
	private Task task;
	private int type;
	
	public Action(Task task, int type)
	{
		this.task = task;
		this.type = type;
	}
	
	public Task getTask()
	{
		return task;
	}
	
	public int getType()
	{
		return type;
	}
}
