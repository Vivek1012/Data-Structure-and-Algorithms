import java.util.*;

public class NumberofOccurrences
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array: ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the element you want to find occurance :");
		int x = s.nextInt();
		
		int first = getFirstOccurance(arr , x);
		int last = getLastOccurance(arr , x);
		
		System.out.println(last - first + 1);
	}
	
	public static int getFirstOccurance(int a[] , int x)
	{
		int n = a.length;
		int l = 0;
		int r = n-1;
		int mid = (l + r)/2;
		
		while(l <= r)
		{
		 mid = (l + r)/2;
			if(a[mid] == x && (mid == l || a[mid-1] < x ))
				return mid;
			else if(x > a[mid])
				l = mid + 1;
			else if(x <= a[mid])
				r = mid - 1;
		}
		return -1;
	}
	
	public static int getLastOccurance(int a[] , int x)
	{
		int n = a.length;
		int l = 0;
		int r = n-1;
		int mid = (l + r)/2;
		
		while(l <= r)
		{
		 mid = (l + r)/2;
			if(a[mid] == x && ( mid == r || a[mid+1] > x) )
				return mid;
			else if(x >= a[mid])
				l = mid + 1;
			else if(x < a[mid])
				r = mid - 1;
		}
		return -1;
	}
}