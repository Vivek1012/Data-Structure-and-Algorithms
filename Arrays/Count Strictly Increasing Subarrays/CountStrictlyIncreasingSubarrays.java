import java.util.*;

public class CountStrictlyIncreasingSubarrays
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
		
		int sum = 0;
		int count = 1;
		for(int i = 0 ; i < n-1 ; i++)
		{
			if(arr[i]<arr[i+1])
				count++;
			else
			{
				if (count > 1)
				{
					sum = sum + getCombinations(count , 2);
					count = 1;
				}
			}
			
			if(i == (n-2) && count > 1)
			{
				sum = sum + getCombinations(count , 2);
			}
		}
		
		System.out.println(sum);
	}
	
	
	public static int getCombinations(int n, int r) {
		// TODO Auto-generated method stub
		// using the property (n-1)C(r) + (n-1)C(r-1) = (n-1)C(r)

		if(r == 0 || r == n)
			return 1;
		
		return getCombinations(n-1 , r-1) + getCombinations(n-1 , r);
	}
}