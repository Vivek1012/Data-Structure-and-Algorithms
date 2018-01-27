/*
 * An array contains both positive and negative numbers in random order. 
 * Rearrange the array elements so that positive and negative numbers are placed alternatively. 
 * Number of positive and negative numbers need not be equal. 
 * If there are more positive numbers they appear at the end of the array. 
 * If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]


-----------------------------Solution----------------------------- 
The solution is to first separate positive and negative numbers using partition process of QuickSort. 
In the partition process, consider 0 as value of pivot element so that all negative numbers are placed before positive numbers. 
Once negative and positive numbers are separated, we start from the first negative number and first positive number, 
and swap every alternate negative number with next positive number.*/


import java.util.*;
public class Rearrangement {

	public Rearrangement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = s.nextInt();
		
		int arr[]= new int[n];
		
		System.out.println("Enter the positive - negative numbers in random fashion :");
		for(int i=0 ; i< n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int pos = seperateArray(arr);
		System.out.println(pos);
		
		rearrangeArray(arr , pos);
	}

	private static void rearrangeArray(int[] arr, int pos) {
		// TODO Auto-generated method stub
		int i = 0;
		int temppos = pos;
		int temp = 0;
		int n = arr.length;
		while(i!=pos && pos < n  && arr[i] < 0)
		{
			temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
			i = i + 2;
			pos++;
		}
		
		for(i=0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}

	private static int seperateArray(int[] arr) {
		
		int n = arr.length;
		int temp = 0;
		int i = -1;
		
		for(int j = 0  ; j < n ; j++)
		{
			if(arr[j] < 0)
			{
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		return i+1;
	}

}
