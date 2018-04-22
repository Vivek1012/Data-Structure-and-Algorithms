//https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/

import java.util.*;

public class closestPairFrom2SortedArrays
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number elements in 1st array :");
		int n1 = s.nextInt();
		
		int arr1[] = new int[n1];
		
		
		System.out.println("Enter the elements of 1st array :");
		for(int i = 0 ; i < n1 ; i++)
		{
			arr1[i] = s.nextInt();
		}

		Arrays.sort(arr1);
		System.out.println("Enter the number elements in 2nd array :");
		int n2 = s.nextInt();
		int arr2[] = new int[n2];		
		System.out.println("Enter the elements of 2nd array :");
		for(int i = 0 ; i < n2 ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		Arrays.sort(arr2);
		
		System.out.println("Enter the value of X :");
		int x = s.nextInt();
		
		int i = 0; // for reading the arr1 from left to right
		int j = n2-1; // for reading the arr2 from right to left
		int diff = Integer.MAX_VALUE;
		int posi = 0 , posj = 0;
		
		while(i < n1 && j >=0)
		{
			if(Math.abs((arr1[i] + arr2[j]) - x) < diff)
			{
				posi = i;
				posj = j;
				diff = Math.abs((arr1[i] + arr2[j]) - x);
			}
			
			else if(arr1[i] + arr2[j] > x)
				j--;
			else if(arr1[i] + arr2[j] < x)
				i++;
		
		}
		
		System.out.println("The value of a and b from arr1 and arr2 is = " + arr1[posi] + "\t" + arr2[posj]);
	}
}

