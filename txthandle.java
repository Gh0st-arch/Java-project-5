package Studenthomework;

public class txthandle 
{
    static String m=null;
    public static String handle(String filename)

    {
        



        for (int i = 0; i<filename.length(); i = i+7) 
        {
        	

            if( i%2 == 0 )
            {
                String split = filename.substring(i, i+7);

                m=m+split+ ",";
            }
            if( i%2 == 1 )
            {
                String split = filename.substring(i, i+7);
                

                m=m+split+ "." + "\n";
            }

        }
        m=m.replaceAll("null","");
        return m;
    }

}