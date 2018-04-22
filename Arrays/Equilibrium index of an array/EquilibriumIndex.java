import java.util.*;
public class EquilibriumIndex
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		int sum = 0;
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
			sum = sum + arr[i];
		}
		
		int leftSum = 0;
		int l = 0 , r = n-1;
		int i = 0;
		for(i = 0 ; i <  n ; i++)
		{
			sum = sum - arr[i];
			if(leftSum == sum)
			{
				System.out.println(i);
				break;
			}
			leftSum = leftSum + arr[i];
		}
		if(i==n)
		System.out.println(-1);
		
		
	}
}