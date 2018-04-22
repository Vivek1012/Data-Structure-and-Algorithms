//https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/

import java.util.*;

public class MaximumSumPath
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
		
		System.out.println("Enter the number elements in 2nd array :");
		int n2 = s.nextInt();
		int arr2[] = new int[n2];		
		System.out.println("Enter the elements of 2nd array :");
		for(int i = 0 ; i < n2 ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		int i = 0; //here i would keep track of 1st array
		int j = 0; // j would keep track of second array
		int sum1 = 0;
		int sum2 = 0;
		
		ArrayList<Integer> arr = new ArrayList<Integer>(); //used to keep the sum till the same element occur in both the arrays.
		
		int ij = n1 + n2;
		
		while((i + j) < ij)
		{
			if(arr1[i] < arr2[j])
			{
				sum1 = sum1 + arr1[i];
				i++;
			}
			else if(arr1[i] > arr2[j])
			{
				sum2 = sum2 + arr2[j];
				j++;
			}
			else if(arr1[i] == arr2[j])
			{
				sum1 = sum1 + arr1[i];
				i++;
				sum2 = sum2 + arr2[j];
				j++;
				arr.add(max(sum1 , sum2));
				sum1 = 0;
				sum2 = 0;
			}

			if(i == n1)
				{
					while(j < n2)
					{
						sum2 = sum2 + arr2[j];
						j++;
					}
					break;
				}
			if(j == n2){
				while(i < n1)
				{
					sum1 = sum1 + arr1[i];
					i++;
				}
				break;
				}
		}

			if(i == n1 && j == n2)
			{
				arr.add(max(sum1 , sum2));
			}		

		
		int sum = 0;
		
		for(int a = 0 ; a < arr.size() ; a++)
		{
			sum = sum + arr.get(a);
		}
		
		System.out.println("The maximux sum in both the arrays : " + sum);
	}
	
	public static int max(int a , int b)
	{
		return (a > b) ? a : b;
	}
}