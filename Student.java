package Studenthomework;

public class Student 
{
    private String name;
    private String sex;
    private int number;
    Homework homework;
    Student(String name,String sex,int number)
    {

        setSex(sex);
        setnumber(number);
        setName(name);


    }
    Student()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSex() 
    {
        return sex;
    }

    public void setSex(String sex) 
    {
        this.sex = sex;
    }



    public int getnumber() 
    {
        return number;
    }

    public void setnumber(int number) 
    {
        this.number = number;
    }

    public String toString()
    {
        return "学生姓名:"+name+"性别"+sex+"学号"+number;
    }
}

