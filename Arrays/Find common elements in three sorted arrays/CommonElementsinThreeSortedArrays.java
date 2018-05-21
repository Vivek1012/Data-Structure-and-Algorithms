import java.util.*;

public class CommonElementsinThreeSortedArrays
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array 1:");
		int m = s.nextInt();
		
		System.out.println("Enter the elements of array : ");
		int arr1[] = new int[m];
		for(int i = 0 ; i < m ; i++)
		{
			arr1[i] = s.nextInt();
		}
		
		System.out.println("Enter the size of array 2:");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array : ");
		int arr2[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		System.out.println("Enter the size of array 3:");
		int p = s.nextInt();
		
		System.out.println("Enter the elements of array : ");
		int arr3[] = new int[p];
		for(int i = 0 ; i < p ; i++)
		{
			arr3[i] = s.nextInt();
		}
		
		int i = 0, j = 0 , k = 0;
		
		int max = p > (m > n ? m : n) ? p : ((m > n) ? m : n);
		int out[] = new int[max];
		
		while(i < arr1.length && j < arr2.length && k < arr3.length)
		{
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k])
				{
					System.out.println(arr1[i] + "\t");
					i++; j++; k++;
				}
				
			else if(arr1[i] < arr2[j])
				i++;
			else if(arr2[j] < arr3[k])
				j++;
			else
				k++;
		}
	}
}
