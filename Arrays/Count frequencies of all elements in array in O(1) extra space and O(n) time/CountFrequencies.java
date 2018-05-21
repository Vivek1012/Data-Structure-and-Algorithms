import java.util.*;

public class CountFrequencies
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt()-1;
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[arr[i]] += n;
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(arr[i]/n + "\t");
		}
		
	}
}
