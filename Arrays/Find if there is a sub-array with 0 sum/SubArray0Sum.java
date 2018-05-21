import java.util.*;

public class SubArray0Sum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		int sum = 0;
		int i = 0;
		for(i = 0 ; i < n ; i++)
		{
			sum = sum + arr[i];
			if(arr[i] == 0 || sum == 0 || hm.get(sum) != null)
				{
					System.out.println("Sum is 0");
					break;
				}
				
			hm.put(sum , i);
		}
		if(i == n)
			System.out.println("No subarray exist with sum 0 ");
	}
}
