/*String matching algorithm using brute force algorithm*/

import java.util.*;
public class BFStrings{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the main String : ");
		String s1 = s.next();
		System.out.println("Enter the substring : ");
		String s2 = s.next();
		int j;
		int n = s1.length();
		int m = s2.length();
		
		char a1[] = s1.toCharArray();
		char a2[] = s2.toCharArray();
		Boolean flag = false;
		
		for(int i = 0 ; i < n-m ; i++)
		{
			j = 0;
			while(j < m && a1[i+j] == a2[j])
			{
				j++;
				if(j == m)
					flag = true;
			}
		}
		
		if(flag == true)
			System.out.println("String s2 is SubString of s1");
	}

}