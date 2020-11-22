package Studenthomework;

import java.io.*;

public class Out 
{
	public static void out(String a)
	{
		a.replace("null", "");
		byte [] b = a.getBytes();
		try
		{
			FileOutputStream out = new FileOutputStream("G://Homework//handle.txt");
			out.write(b);
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("File write error:"+e);
		}
	}
}
	


