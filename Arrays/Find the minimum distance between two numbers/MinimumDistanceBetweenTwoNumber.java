//https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

import java.util.*;

public class MinimumDistanceBetweenTwoNumber
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
		
		System.out.println("Enter the value of X and Y :");
		int x = s.nextInt();
		int y = s.nextInt();
		int pos = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] == x || arr[i] == y)
			{
				pos = i;
				break;
			}
		}
		int minval = Integer.MAX_VALUE;
		for(int i = pos+1 ; i < n ; i++)
		{
			if(arr[i] == x || arr[i] == y)
			{
				if(arr[i] != arr[pos] && minval > (i-pos))
					minval = i-pos;
					
					pos = i;
			}
		}
		
		System.out.println(minval);
	}
}