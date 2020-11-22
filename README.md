# java-project-5
Java实验5代码仓库

## 实验目的
   1.掌握字符串String及其方法的使用
   
   2.掌握文件的读取/写入方法
   
   3.掌握异常处理结构


## 实验要求
   在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
   文件A包括两部分内容：
   一是学生的基本信息；
   二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

   1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
   2.允许提供输入参数，统计古诗中某个字或词出现的次数
   3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
   4.考虑操作中可能出现的异常，在程序中设计异常处理程序

   输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>

   输出：
   汉皇重色思倾国，御宇多年求不得。
   杨家有女初长成，养在深闺人未识。
   天生丽质难自弃，一朝选在君王侧。
   回眸一笑百媚生，六宫粉黛无颜色。
   春寒赐浴华清池，温泉水滑洗凝脂。
   侍儿扶起娇无力，始是新承恩泽时。
   云鬓花颜金步摇，芙蓉帐暖度春宵。
   春宵苦短日高起，从此君王不早朝。
   …………

   设计学生类（可利用之前的）；
   采用交互式方式实例化某学生；
   设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。


 ## 实验过程
   1.Student类
     这一类主要是写出一个学生应该所具有的属性（名字,性别,学号,作业）并且写出给这些属性赋值的函数.
   2.Homework类
     这一类是为学生类里的作业属性而创建的类,该类里主要用于读取作业并存放到字符串里.
     首先,在这个读取的方法当中,应当有一个形参为String类型,来接收学生作业的文件路径,在本程序中为固定路径，学生需要把自己的作业放到指定路径下,程序方可自动读取该作业.
     其次开始考虑如何读取作业,用File file = new File(filename)来创建一个File类的对象file,并且将刚才设计的形参filename作为输入流的指向,也就是说该程序之后会在该形参的值里读取路径输入给这个路径.
     然后InputStreamReader Reader创建一个Reader对象来读取文件的内容,作为一个程序要处理的文件大小不定,所以用上了缓冲区Bufferedreader,用上while循环把读取的内容存放到字符串中.
   3.input类
     该类主要作用是将整个程序需要用于输出的方法都写在该类当中.
     例如学生的姓名,性别,学号,还有这个作业处理程序的主菜单.
   4.txthandle类
     该类是用于处理作业的类.
     在读取完作业的内容之后,字符串里的内容是没被整理过的,以本程序的输入文本.txt为例,它里面的内容是没有排版的古诗,要将它整理成有标点符号且整齐的古诗,需要每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”,即实验的要求1.
   5.Out类
     该类为输出类,里面的方法可以将整理好的字符串输出到G磁盘下Homework文件夹里的handle.txt文档里
   6.Statistics类
     该类的方法用来做词频统计.
     利用indexOf()方法来索引某个词或字配合上while循环直到它的返回值为-1为止,每次索引后,令index的值+1这样下次可以排除索引重复,每循环一次count加一,最后count为词频.
   7.Test类
     该类为主类,用于结合其他所有类来测试该程序.
     
 ## 核心代码
 ```
 1.
	public static String Homework(String filename)
	{
		try
		{
			File file = new File (filename);//输入流指向
			if(file.isFile() && file.exists())
			{
				InputStreamReader Reader;
				
					Reader = new InputStreamReader(new FileInputStream(file), "utf-8");
					BufferedReader buffreader = new BufferedReader(Reader);//缓冲区防止程序运行太慢
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
		return c;//返回读取的内容
	}


```
```
2.public static void show(Student student)//程序的主菜单及其判断函数
    {
    	Scanner reader01 = new Scanner(System.in);
    	Scanner reader02 = new Scanner(System.in);
    	System.out.println("***********************************");//输出主菜单
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
    			student.homework.Homework("G://输入文本.txt");//读取G盘下的文档内容
    			System.out.println("读取作业成功！");
    			txthandle.handle(student.homework.c);//处理文本内容
    			System.out.println(txthandle.m);//输出整理后的文本内容
    			System.out.println("整理完毕！");
    		}
    		if(c == 2)
    		{
    		  if(txthandle.m.equals(null))
    		  {
    			  System.out.println("请先读取作业！！");//2选项为词频统计,所以必须有这一项判断来防止学生不读取内容直接进行统计
    		  }
    		  else
    		  {
    			  h:while(true)
        		  {
        			  System.out.println("请输入要查看出现次数的词语:");
          			  g = reader02.next();//接收词语(字)
          			  Statistics.statistics(student.homework.c, g);
          			  break h;
        		  }
    		  }
    		}
    		if(c == 3)
    		{
    			f = txthandle.m+"\n"+"姓名:"+student.getName()+"\n"+"性别:"+student.getSex()+"\n"+"学号:"+student.getnumber();
    			Out.out(f);//输出方法调用
    			System.out.println("输出成功，结果已保存到G:/Homework/handle.txt");
    		}
    		if(c == 4)
    		{
    			System.out.println("请将要处理的作业内容，输入在指定目录下的输入文本.txt里（G:/输入文本.txt）");
    			System.out.println("然后运行本程序，选择需要的处理方式，最后选择3后作业自动保存到G:/Homework/handle.txt");
    		}
    	}
    }
```
```
3.public static void out(String a)
	{
		a.replace("null", "");//清空null防止输出出现null
		byte [] b = a.getBytes();//字符串的字节存放到数组b中
		try
		{
			FileOutputStream out = new FileOutputStream("G://Homework//handle.txt");
			out.write(b);//输出数组b到G:/Homework/handle.txt
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("File write error:"+e);
		}
	}
```
```
4.	public static int statistics(String work, String find)
	{
        int count = 0;
        int index = 0;
        while ((index = work.indexOf(find, index)) != -1) //用indexOf方法检索字符的位置
        {

        	index = index + 1;//字符位置+1防止重复检索
            count++; //每次发现一个find,就+1,以count作为词频.
        }
        System.out.println("该字（词）语在此作业中出现的次数为："+count);//输出词频
        return count;
        
    }
```


## 系统运行截图
1.输入文本截图，通过此txt文件来向程序输入要处理的文本
![result](https://github.com/Gh0st-arch/Java-project-5/blob/main/image/20201122170545.png)
2.程序运行截图
![result](https://github.com/Gh0st-arch/Java-project-5/blob/main/image/20201122170258.png)
3.程序输出结果
![result](https://github.com/Gh0st-arch/Java-project-5/blob/main/image/20201122170404.png)
## 编程感想
   通过本次实验编程,我掌握字符串String及其方法的使用,能够灵活运用字符串和数组,掌握了输入和输出的方法,在这过程中用异常处理结构来避免输入的错误,完整的实现学生作业处理程序.

