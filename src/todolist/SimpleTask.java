package todolist;

/**Simple Task
 * (Maddy)
 * 
 * A basic task with no additional functionality
 */
public class SimpleTask extends Task
{

	@Override
	public String getTaskType() {
		return "Basic Task";
	}

	@Override
	public String getDetails() {
		return "Basic Task\n"+this.toString();
	}

}
