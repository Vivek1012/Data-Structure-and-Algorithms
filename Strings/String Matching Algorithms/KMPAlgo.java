/*KMP implementation for String matchin algorithm*/
//Example Strings
/*Main String s1 = "bacbabababacaca"
Patter String s2 = "ababaca" */

import java.util.*;
public class KMPAlgo{

	public static int[] PreSuffTable;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the main String : ");
		String s1 = s.next();
		System.out.println("Enter the substring : ");
		String s2 = s.next();
		int i,j;
		int n = s1.length();
		int m = s2.length();
		
		char a1[] = s1.toCharArray(); //Converted the String to an array of characters the main String 
		char a2[] = s2.toCharArray(); //Converted the String to an array of characters the pattern String 
		
		PreSuffTable = new int[m];
		int position = KMPFinder(a1 , n , a2 , m);
		System.out.println("The pattern String matches from the index = " + position) ;
		
	}

		public static void PrefixSuffixTable(char a[] ,int m)
		{	
			int i = 1; 
			int j = 0;
			PreSuffTable[0] = 0;
			
			while(i < m)
			{
			System.out.println("i = " + i);
			System.out.println("j = " + j);
				if(a[i] == a[j])
				{
					PreSuffTable[i] = j+1;
					j++;
					i++;
				}
				else if(j > 0)
				{
					j = PreSuffTable[j-1];
				}
				else
				{
					PreSuffTable[i] = 0;
					i++;
				}
			}
		}
		
		public static int KMPFinder(char s[] , int n , char a[] , int m)
		{
		
			PrefixSuffixTable(a , m);
			int i = 0;
			int j = 0;
			
			while(i < n)
			{
				if(s[i] == a[j])
				{
					if(j == m-1)
						return i-j;
					else 
					{
						i++;
						j++;
					}
				}
				else if(j > 0)
				{
					j = PreSuffTable[j-1];
				}
				else
					i++;
			}
			return -1;
		}
}
