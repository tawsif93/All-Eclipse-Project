package deitel.exercise.chapter20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		List<Time> list = new ArrayList<>();

		list.add( new Time( 12, 50, 49));
		list.add( new Time( 1, 59, 44));
		list.add( new Time( 12, 49, 50));

		System.out.println( "Unsorted Element : " + list);

		Collections.sort( list, new TimeComparator());

		System.out.println( "Sorted List: " + list);

	}

}

class TimeComparator implements Comparator<Time>
{

	@Override
	public int compare(Time arg0, Time arg1)
	{
		// TODO Auto-generated method stub
		int hourCompare = arg0.getHour() - arg1.getHour();

		if (hourCompare != 0)
			return hourCompare;

		int minuteCompare = arg0.getMinute() - arg1.getMinute();

		if (minuteCompare != 0)
			return minuteCompare;

		int secondComapre = arg0.getSecond() - arg1.getSecond();

		if (secondComapre != 0)
			return secondComapre;
		return 0;

	}

}

class Time
{
	private int second, minute, hour;

	public Time(int hour, int minute, int second) {
		super();
		this.second = second;
		this.minute = minute;
		this.hour = hour;
	}

	public int getSecond()
	{
		return second;
	}

	public void setSecond(int second)
	{
		this.second = second;
	}

	public int getMinute()
	{
		return minute;
	}

	public void setMinute(int minute)
	{
		this.minute = minute;
	}

	public int getHour()
	{
		return hour;
	}

	public void setHour(int hour)
	{
		this.hour = hour;
	}

	@Override
	public String toString()
	{
		return " [ " + hour + ":" + minute + ":" + second + "]";
	}

}