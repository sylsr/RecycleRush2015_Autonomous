package org.usfirst.frc.team1891.robot;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class AverageInfraredData2 extends LinkedList<Integer>
{
	static int accumulator=0;
	final int AVERAGE_MAX=10;
	public void add(int infraredData)
	{
		if(this.size()>=AVERAGE_MAX)
		{
			accumulator-=super.removeLast();
		}
		super.addFirst(infraredData);
		accumulator+=infraredData;
	
		
	}
	public int getAverage()
	{
		return accumulator/AVERAGE_MAX;
	}
	
}
