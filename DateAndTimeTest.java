public class DateAndTimeTest
{
	public static void main(String[] args)
	{
		Date d1=new Date(12,31,2000);
		Time2 t1=new Time2(23,59,59);
		
		DateAndTime dayTime=new DateAndTime(d1,t1);
		
		System.out.printf("%nBefore increment:%nWith Standard Time:%n%s%n",dayTime.toString());
		System.out.printf("%nWith Universal Time:%n%s%n",dayTime.toUniversalString());
		
		t1.tick();
		if (t1.getHour()==0)
			d1.nextDay();
		
		System.out.printf("%nAfter increment:%nWith Standard Time:%n%s%n",dayTime.toString());
		System.out.printf("%nWith Universal Time:%n%s%n",dayTime.toUniversalString());
	}
}

class Time2
{
	private int hour;
	private int minute;
	private int second;
	
	public Time2()
	{
		this(0 , 0 , 0);
	}
	public Time2(int hour)
	{
		this(hour , 0 , 0);
	}
	public Time2(int hour , int minute)
	{
		this(hour , minute , 0);
	}
	public Time2(int hour , int minute , int second)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public Time2(Time2 time)
	{
		this(time.getHour() , time.getMinute() , time.getSecond());
	}
	
	public void setTime(int hour , int minute , int second)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public void setHour(int hour)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		this.hour = hour;
	}
	public void setMinute(int minute)
	{
		if (minute < 0 && minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		this.minute = minute;
	}
	public void setSecond(int second)
	{
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		this.second = second;
	}
	
	public int getHour()
	{
		return hour;
	}
	public int getMinute()
	{
		return minute;
	}
	public int getSecond()
	{
		return second;
	}
	
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d" , getHour() , getMinute() , getSecond());
	}
	public String toString()
	{
		return String.format("%d:%02d:%02d %s", ( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ) ,
												   getMinute() , getSecond() , (getHour() < 12 ? "AM" : "PM") );
	}
	
	public void tick()
	{
		++this.second;
		if (second==60){
			incrementMinute();
			second=0;
		}
	}
	public void incrementMinute()
	{
		++this.minute;
		if (minute==60){
			incrementHour();
			minute=0;
		}
	}
	public void incrementHour()
	{
		++this.hour;
		if (hour==24){
			hour=0;
		}
	}
}

class Date
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

class DateAndTime
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
		return String.format("Date:\t\tTime:%n%s\t%s",d,t.toString());
	}
	public String toUniversalString()
	{
		return String.format("Date:\t\tTime:%n%s\t%s",d,t.toUniversalString());
	}
}