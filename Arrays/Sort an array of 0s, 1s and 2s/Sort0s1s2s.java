import java.util.*;

public class Sort0s1s2s
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
		
		int low = 0 ,mid = 0, high = n-1;
		int temp = 0;
		while(mid <= high)
		{
			switch(arr[mid])
			{
				case 0 : //swap arr[mid] and arr[low]
						 temp = arr[mid];
						 arr[mid] = arr[low];
						 arr[low] = temp;
						 
						 low++;
						 mid++;
						 break;
						 
				case 1 : mid++;
						 break;
						 
				case 2 : //swap arr[mid] and arr[high]
						 temp = arr[mid];
						 arr[mid] = arr[high];
						 arr[high] = temp;
						 
						 high--;
						 break;
			}
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}
	
}