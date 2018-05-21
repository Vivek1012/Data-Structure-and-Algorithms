import java.util.*;

public class binarySubarrayOddEven
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Emter the size of array:");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		System.out.println("Enter the number of queries : ");
		int m = s.nextInt();
		
		for(int i = 0 ; i < m ; i++)
		{
			System.out.println("Enter the range <l,r> :" );
			int l = s.nextInt();
			int r = s.nextInt();
			
			if(arr[r] == 1)
				System.out.println("The number is Odd !");
			else
				System.out.println("The number is even !");
		}
	}
}
