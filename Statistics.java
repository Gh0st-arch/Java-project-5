package Studenthomework;

public class Statistics 
{
	public static int statistics(String work, String find)
	{
        int count = 0;
        int index = 0;
        while ((index = work.indexOf(find, index)) != -1) 
        {

        	index = index + 1;
            count++; 
        }
        System.out.println("该字（词）语在此作业中出现的次数为："+count);
        return count;
        
    }

}
