import java.util.*;

public class ConstanttimeRangeAdd {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n  ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the number of queries :");
		int m = s.nextInt();
		
		System.out.println("Enter the update value V :");
		int v = s.nextInt();
		
		for(int i = 0 ; i < m ; i++)
		{
			System.out.println("Enter the range <l,r>");
			int l = s.nextInt();
			int r = s.nextInt();
			
			if(l < 0 || r > n-1)
			{
				System.out.println("Range out of bounds !");
				continue;
			}
			
			arr[l] += v;
			if(r != n-1)
				arr[r+1] -= v;
		}
		
		for(int i = 1 ; i < n ; i++)
		{
			arr[i] = arr[i] + arr[i-1];
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println(arr[i]);
		}
		
		
	}
}
