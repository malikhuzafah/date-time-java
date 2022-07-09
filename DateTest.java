public class DateTest
{
	public static void main(String[] args)
	{
		Date d1=new Date(11,29,2000);
		System.out.printf("Date is:%n%s%n",d1);
		while(d1.getMonth()!=2) {
			d1.nextDay();
			System.out.printf("Date is:%n%s%n",d1);
		}
	}
}