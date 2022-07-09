public class Time2Test
{
	public static void main(String[] args)
	{
		Time2 t1=new Time2(0,0,59);
		Time2 t2=new Time2(7,59,0);
		Time2 t3=new Time2(23,0,0);
		
		System.out.println("Incrementing into next minute:");
		displayTime("Before increment:",t1);
		t1.tick();
		displayTime("After increment:",t1);
		
		System.out.println("Incrementing into next hour:");
		displayTime("Before increment:",t2);
		t2.incrementMinute();
		displayTime("After increment:",t2);
		
		System.out.println("Incrementing into next day:");
		displayTime("Before increment:",t3);
		t3.incrementHour();
		displayTime("After increment:",t3);
		
		try
		{
			Time2 t6=new Time2(27,74,99);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("%nException while initializing t6: %s%n",e.getMessage());
		}
	}
	
	private static void displayTime(String header,Time2 t)
	{
		System.out.printf("%s%n  %s%n  %s%n",header,t.toUniversalString(),t.toString()); 
	}
}