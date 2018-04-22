import java.util.*;

public class FixedPoint
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		// binary search with the index goes here 
		System.out.println("The array elements with same index = " + BinaryIndexSearch(arr));
		
	}
	
	public static int BinaryIndexSearch(int a[])
	{
		int n = a.length;
		int l = 0; 
		int r = n-1;
		int mid = (l+r)/2;
		
		while(l<=r)
		{
			mid = (l+r)/2;
			
			if(mid == a[mid])
				return mid;
			else if(a[mid] > mid)
				r = mid - 1;
			else if(a[mid] < mid)
				l = mid + 1;
		}
		return -1;
	}
}