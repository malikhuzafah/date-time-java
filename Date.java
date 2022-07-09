public class Date
{
	private int month;
	private int day;
	private int year;
	
	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int month, int day, int year)
	{
		if (month<=0||month>12)
			throw new IllegalArgumentException("month ("+month+") must be 1-12");
		
		if (day<=0||(day>daysPerMonth[month]&&!(month==2&&day==29)))
			throw new IllegalArgumentException("day ("+day+") out-of-range for the specified month and year");
		if (year>2020||year<=0)
			throw new IllegalArgumentException("year ("+year+") must be 1-2020");
		
		this.month=month;
		this.day=day;
		this.year=year;
	}
	
	public String toString()
	{
		return String.format("%d/%d/%d",month,day,year);
	}
	
	public void nextDay()
	{
		++this.day;
		if (day>daysPerMonth[month]&&!(month==2&&day==29)) {
			this.month++;
			this.day=1;
		}
		if (month==13) {
			this.year++;
			this.month=1;
		}
	}
	public int getMonth()
	{
		return this.month;
	}
}