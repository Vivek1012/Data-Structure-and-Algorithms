//https://www.geeksforgeeks.org/majority-element/

import java.util.*;

public class MajorityElement
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
		
		int count = 1;
		int maj_index = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[maj_index] == arr[i])
			{
				count++;
			}
			else
				count--;
				
			if(count == 0)
			{
				maj_index = i;
				count = 1;
			}
		}
		count = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[maj_index] == arr[i])
				count++;
		}
		
		if(count >= n/2)
			System.out.println(arr[maj_index]);
		else
			System.out.println("No majority element exist in array !");		
	}
	
}