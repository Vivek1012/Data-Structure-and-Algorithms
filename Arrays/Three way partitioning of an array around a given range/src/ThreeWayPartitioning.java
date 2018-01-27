/*Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.
1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVVal come next.
3) All elements greater than highVVal appear in the end.
The individual elements of three sets can appear in any order.*/

//-------------------------------------Examples----------------------------------

/*
 * Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
        lowVal = 14, highVal = 20
Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
       lowVal = 20, highVal = 20       
Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54} 
*/

import java.util.*;

public class ThreeWayPartitioning {

	public ThreeWayPartitioning() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the value of plow: ");
		int plow = s.nextInt();
		
		System.out.println("Enter the value of phigh: ");
		int phigh = s.nextInt();
		
		
		ThreeWaypartition(arr , n , phigh , plow);
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
		
	}

	private static void ThreeWaypartition(int[] arr, int n, int phigh, int plow) {
		// TODO Auto-generated method stub
		int temp = 0;
		int start = 0;
		int end = n-1;
		
		for(int i = 0 ; i < end ;)
		{
			if(arr[i] < plow)
			{
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
				start++;
				i++;
			}
			else if(arr[i] > phigh)
			{
				temp = arr[i];
				arr[i] = arr[end];
				arr[end] = temp;
				end--;
			}
			else
				i++;
		}
		
	}
}
