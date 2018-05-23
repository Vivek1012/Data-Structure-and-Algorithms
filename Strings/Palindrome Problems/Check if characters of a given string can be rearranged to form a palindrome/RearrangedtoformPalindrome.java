import java.util.*;

public class RearrangedtoformPalindrome
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str = s.next();
		int n = str.length();
		
		HashMap<Character , Integer> hm = new HashMap<Character , Integer>();
		
		for(int i = 0 ; i < n ; i++)
		{
			char ch = str.charAt(i);
			if(hm.containsKey(ch))
				hm.put(ch , hm.get(ch) + 1);
			else
				hm.put(ch , 1);
		}
		
		int isodd = 0;
		for(int i : hm.values())
		{
			if(i%2 == 1)
			{				
					isodd++;
			}
		}
		
		if(isodd > 1)
			System.out.println("the given string can't be arranged in palindrome !");
		else
			System.out.println("The given string can be arranged in palindrome !");
		
	}
}