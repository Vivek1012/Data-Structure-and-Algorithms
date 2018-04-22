import java.util.*;

public class MinimumLengthUnsortedSubarray
{
	public static void main(String args[])
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = ss.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = ss.nextInt();
		}
		
		int s = 0, e = n-1;
		//find first element which is out of order form left to right
		for(int i = 0 ; i < n-1 ; i++)
		{
			if(arr[i] > arr[i+1])
				{
					s = i;
					break;
				}
		}
		
		System.out.println("s = " + s);
		//find last element which is out of order from right to left
		for(int i = n-1 ; i > 0 ; i--)
		{
			if(arr[i] < arr[i-1])
				{
					e = i;
					break;
				}
		}
		System.out.println("e = " + e);
		
		//now find the min and max elements 
		int min = arr[s], max = arr[s];
		
		for(int i = s+1 ; i <= e ; i++)
		{
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		System.out.println("min = " + min + "\t max = " + max);
		
		for(int i = 0; i <= s ; i++)
		{
			if(min < arr[i])
			{
				s = i;
				break;
			}
		}
		
		for(int i = n-1 ; i >= e ; i--)
		{
			if(max > arr[i])
			{
				e = i;
				break;
			}
		}
		
		
		System.out.println(s +"\t"+ e);
	}
}
