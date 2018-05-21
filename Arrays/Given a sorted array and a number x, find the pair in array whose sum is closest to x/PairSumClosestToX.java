import java.util.*;

public class PairSumClosestToX
{
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
		
		System.out.println("Enter the value of x");
		int x = s.nextInt();
		
		int l = 0;
		int r = n-1;
		int diff = Integer.MAX_VALUE;
		int l_set = 0 , r_set = 0;
		
		while(l < r)
		{
			if(Math.abs((arr[r] + arr[l]) - x) < diff)
			{
				l_set = l;
				r_set = r;
				diff = Math.abs(arr[r] + arr[l] - x);
			}
			
			else if(arr[l] + arr[r] > x)
				r--;			
			else 
				l++;
		}
		System.out.println(l_set + "\t" + r_set);
	}
}