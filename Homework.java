package Studenthomework;
import java.io.*;
import java.util.*;
public class Homework 
{
	static String c = null;
	static String[] a= new String[1000000];
	//String LJ = null;
	public static String Homework(String filename)
	{
		try
		{
			File file = new File (filename);
			if(file.isFile() && file.exists())
			{
				InputStreamReader Reader;
				
					Reader = new InputStreamReader(new FileInputStream(file), "utf-8");
					BufferedReader buffreader = new BufferedReader(Reader);
					List<String> strings = new ArrayList<String>();
					String stringline = null;
					while ((stringline = buffreader.readLine()) != null) 
					{
	                    strings.add(stringline);
	                    c=c+stringline;
	                    
	                }

	                buffreader.close();
				
			}
		}
		catch(Exception e)
		{
			System.out.println("!");
		}
		c=c.replaceAll("null","");
		return c;
	}
}
