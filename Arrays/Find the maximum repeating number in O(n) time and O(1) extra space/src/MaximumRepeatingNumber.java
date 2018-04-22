//https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/

import java.util.*;

public class MaximumRepeatingNumber
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("enter the value of K such that all the elements must be smaller than k , k<=n :");
		int k = s.nextInt();
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[arr[i] % k] = arr[arr[i] % k] + k;
		}
		
		int max = arr[0];
		int pos = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(max < arr[i])
			{
				max = arr[i];
				pos = i;
			}
		}
		
		System.out.println("The number which apears maximum number of times = " + pos);
	}
}