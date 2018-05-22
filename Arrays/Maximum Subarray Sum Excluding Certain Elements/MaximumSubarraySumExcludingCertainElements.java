import java.util.*;

public class MaximumSubarraySumExcludingCertainElements
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the length of exception array :");
		int x = s.nextInt();
		
		System.out.println("Enter the elements of exception array :");
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 0 ; i < x ; i++)
		{
			ar.add(s.nextInt());
		}
		
		int maxsum = 0, sum = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(ar.contains(arr[i]))
				sum = 0;
			else
				sum = sum + arr[i];
			
			maxsum = Math.max(maxsum , sum);
		}
		System.out.println(maxsum);
		
	}
}