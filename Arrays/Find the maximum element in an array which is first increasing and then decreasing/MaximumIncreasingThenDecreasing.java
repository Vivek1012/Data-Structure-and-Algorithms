//https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

import java.util.*;

public class MaximumIncreasingThenDecreasing
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
		
		int l = 0; 
		int r = n-1;
		int mid = (l+r)/2;
		
		while(l<=r)
		{
			mid = (l+r)/2;
			
			if(l == r)
			{
				mid = l;
				break;
			}
			if(l+1 == r)
			{
				mid = (arr[l] > arr[r] ? l : r);
				break;
			}
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
				break;
			else if(arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1])
				l = mid+1;
			else if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1])
				r = mid-1; 
		}
		
		System.out.println(arr[mid]);
		
	}
}