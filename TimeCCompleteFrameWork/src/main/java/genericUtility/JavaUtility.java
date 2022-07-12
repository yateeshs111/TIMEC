package genericUtility;

import java.util.Random;

public class JavaUtility 
{
	public int getRandomNum()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;	
	}
}
