package Studenthomework;

import java.util.InputMismatchException;
import java.util.Scanner;
public class input 
{

    public static void input(Student student)
    {
        Scanner reader=new Scanner(System.in);
        String a,b;
        
        System.out.println("请输入你的名字");
        z:while (true) 
        {
            try 
            {
                reader = new Scanner(System.in);
               
                a=reader.next();
                student.setName(a);
                break z;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("");
            }
        }
        
        System.out.println("请输入性别");
        a:while (true) 
        {
            try 
            {
                reader = new Scanner(System.in);
                a=reader.next();
                student.setSex(a);
                break a;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("");
            }
        }

        System.out.println("请输入学号");
        v:while (true) 
        {
            try 
            {
                reader = new Scanner(System.in);
                student.setnumber(reader.nextInt());
                break v;
            } 
            catch (InputMismatchException e)
            {
                System.out.println("");
            }
        }

        
    }
    @SuppressWarnings("resource")
	public static void show(Student student)
    {
    	Scanner reader01 = new Scanner(System.in);
    	Scanner reader02 = new Scanner(System.in);
    	System.out.println("***********************************");
    	System.out.println("欢迎"+student.getName()+"来到作业处理系统!");
    	System.out.println("1.读取并处理作业");
    	System.out.println("2.统计作业中出现某个字（词）出现的次数");
    	System.out.println("3.保存作业(G:/Homework/handle.txt)");
    	System.out.println("4.查看程序使用方法");
    	System.out.println("0.退出程序");
    	System.out.println("***********************************");
    	int c = -1;
    	String f = null;
    	String g = null;
    	while (c != 0)
    	{
    		c = -1;
    		try
        	{
        		c = reader01.nextInt();
        	}
        	catch(InputMismatchException e)
        	{
        		System.out.println("请输入数字！");
        	}
    		if(c == 1)
    		{
    			student.homework.Homework("G://输入文本.txt");
    			System.out.println("读取作业成功！");
    			txthandle.handle(student.homework.c);
    			System.out.println(txthandle.m);
    			System.out.println("整理完毕！");
    		}
    		if(c == 2)
    		{
    		  if(txthandle.m.equals(null))
    		  {
    			  System.out.println("请先读取作业！！");
    		  }
    		  else
    		  {
    			  h:while(true)
        		  {
        			  System.out.println("请输入要查看出现次数的词语:");
          			  g = reader02.next();
          			  Statistics.statistics(student.homework.c, g);
          			  break h;
        		  }
    		  }
    		}
    		if(c == 3)
    		{
    			f = txthandle.m+"\n"+"姓名:"+student.getName()+"\n"+"性别:"+student.getSex()+"\n"+"学号:"+student.getnumber();
    			Out.out(f);
    			System.out.println("输出成功，结果已保存到G:/Homework/handle.txt");
    		}
    		if(c == 4)
    		{
    			System.out.println("请将要处理的作业内容，输入在指定目录下的输入文本.txt里（G:/输入文本.txt）");
    			System.out.println("然后运行本程序，选择需要的处理方式，最后选择3后作业自动保存到G:/Homework/handle.txt");
    		}
    	}
    }
}
