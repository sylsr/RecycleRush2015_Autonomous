package org.usfirst.frc.team1891.robot;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class AverageInfraredData extends LinkedList<Integer>
{
	static int accumulator=0;
	final int AVERAGE_MAX=10;
	public void add(int i)
	{
		if (this.size() >= AVERAGE_MAX)
		{
			if(this.size()==AVERAGE_MAX)
			{
				
				accumulator-=super.removeFirst();
				super.removeFirst();
			}	
			super.addFirst(i);
			accumulator +=i;
		}
		
		
	}
	public int getAverage()
	{
		return accumulator/AVERAGE_MAX;
	}
	
}
