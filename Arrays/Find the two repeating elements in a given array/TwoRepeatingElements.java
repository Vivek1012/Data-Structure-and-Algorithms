import java.util.*;

public class TwoRepeatingElements
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements for array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		//now we know that the number's are in the range of 1 to n-1
		
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] < 0)
				System.out.println(Math.abs(arr[i]));
			else
			{
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}
	}
}