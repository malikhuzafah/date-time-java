public class DateAndTime
{
	private Date d;
	private Time2 t;
	
	public DateAndTime(Date date,Time2 time)
	{
		this.d=date;
		this.t=time;
	}
	
	public String toString()
	{
		return String.format("Date: %s%nTime: %s",d,t.toString());
	}
	public String toUniversalString()
	{
		return String.format("Date: %s%nTime: %s",d,t.toUniversalString());
	}
}