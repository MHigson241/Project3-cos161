package todolist;

/**Prioritizable
 * (Iris)
 * 
 * Methods:
 * -setPriority 
 * -getPriority returns the priority of the task 0-10
 */
public interface Prioritizable {
	public int priority = 0;
	
	/**sets the value of priority
	 * (Iris)
	 * 
	 * @param priority the value used to set the priority of a 
	 */
	public void setPriority(int priority);
	
	/**returns the priority of the task 0-10
	 * (Iris)
	 * 
	 * @return	the int priority of the task
	 */
	public int getPriority();
	}
