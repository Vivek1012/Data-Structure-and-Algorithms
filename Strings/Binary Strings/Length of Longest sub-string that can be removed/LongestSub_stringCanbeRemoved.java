import java.util.*;

public class LongestSub_stringCanbeRemoved
{

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string :");
		String str = s.next();
		
		String remove = "100";
		int maxlen = 0;
		int index = 0;
		int max = 0;
		int n = str.length();
		int pre = str.indexOf(remove);
		
		while(index != -1)
		{
		System.out.println(str);
		
			index = str.indexOf(remove);
			
			System.out.println(index);

			if(pre < index)
				max = 0;
					
			if(index >= 0){
				max += 3;
				pre = index;
				str = str.substring(0 , index) + str.substring(index+3 , str.length());
			}
			
			maxlen = Math.max(maxlen , max);
		}
		
		System.out.println(maxlen);
	}
}