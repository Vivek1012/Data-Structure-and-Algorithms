import java.util.*;

public class AnBnString
{
	public static void main(String args[])
	{
		Stack<Integer> st = new Stack<Integer>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string :");
		String str = s.next();
		
		int n = str.length();
		int i = 0;
		for(i = 0 ; i < n ; i++)
		{
			if(str.charAt(i) == '1')
				st.push(1);
			else
			{
				if(st.isEmpty())
					{
						System.out.println("This is invalid string:");
						break;
					}
			}
		}
		if(i == n)
			System.out.println("This is valid string!");
		
	}
}
