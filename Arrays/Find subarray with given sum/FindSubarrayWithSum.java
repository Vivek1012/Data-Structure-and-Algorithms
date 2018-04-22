import java.util.*;

public class FindSubarrayWithSum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements in array:");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the sum you want to find :");
		int sum = s.nextInt();
		
		int i = 0; 
		int j = 0;
		int val = 0;
		
		
		
		while(val < sum)
		{
			val = val + arr[j];
			j++;
		}
		while(j <= n-1)
		{
			val = val - arr[i];
			i++;
			
			if(val == sum)
			{
				j--;
				break;
			}
				
			if(val < sum)		
			{
				val = val + arr[j];
				j++;
			}
		}
		
		if(i == n && j == n)
		{
			if(val == sum && sum != 0)
				System.out.println(i + "\t" + j);
			else
				System.out.println("No sub array found");
		}
		
		System.out.println(i + "\t" + j);
		
		
	}
}