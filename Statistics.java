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
        System.out.println("���֣��ʣ����ڴ���ҵ�г��ֵĴ���Ϊ��"+count);
        return count;
        
    }

}
