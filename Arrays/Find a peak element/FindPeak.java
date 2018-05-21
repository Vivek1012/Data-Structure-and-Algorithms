import java.util.*;

public class FindPeak{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int pos = findPeak(arr , 0 , n-1 , n);
		System.out.println("peak element is = " + pos);
	}
	
	public static int findPeak(int arr[] , int l , int r , int n)
	{
		int mid = l + (r-l)/2;
		
		if((mid == n-1 || arr[mid] >= arr[mid+1]) && (mid == 0 || arr[mid-1] <= arr[mid]))
			return mid;
		
		if(mid <= n-2 && arr[mid] > arr[mid+1])
			return findPeak(arr , l , r = mid-1 , n );

			return findPeak(arr , l = mid+1 , r , n);		
	}

}
