package puzzle.model.notification;

public class MovedEmptySlot extends Notification
{
	private int start, end;
	
	public MovedEmptySlot(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	public int getStart()
	{
		return this.start;
	}
	
	public int getEnd()
	{
		return this.end;
	}
}
