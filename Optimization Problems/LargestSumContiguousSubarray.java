import java.util.*;

public class LargestSumContiguousSubarray{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array : ");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int curr_max = arr[0];
		int max = arr[0];
		
		for(int i = 1 ; i < n ; i++)
		{
			curr_max = Math.max(arr[i] , curr_max + arr[i]);
			max = Math.max(curr_max , max);
		}
		
		System.out.println(max);
	}
}