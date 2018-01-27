/*Given an unsorted array of integers, sort the array into a wave like array.
 *An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 **/

import java.util.*;
public class SortInWave {

	public SortInWave() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements for an array :");
		int n = s.nextInt();
		
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr1[i] = s.nextInt();
			arr2[i] = arr1[i];
		}
		
		SortSolution1(arr1);
		
		for(int i = 0 ; i < n  ; i++)
		{
			System.out.print(arr1[i] + " \t");
		}
		System.out.println();
		sortSolution2(arr2);
		for(int i = 0 ; i < n  ; i++)
		{
			System.out.print(arr2[i] + " \t");
		}
	}
	
	/*A Simple Solution is to use sorting. First sort the input array, then swap all adjacent elements.

	For example, let the input array be {3, 6, 5, 10, 7, 20}.
	After sorting, we get {3, 5, 6, 7, 10, 20}. After swapping adjacent elements, we get {5, 3, 7, 6, 20, 10}.
	It goes till order O(nlogn)
	*/

	private static void SortSolution1(int[] arr1) {
		// TODO Auto-generated method stub
		int n = arr1.length;
		int temp = 0;
		mergeSort(arr1, 0 , n-1);
		for(int i = 0 ; i < n-1 ; i = i+2)
		{
			temp = arr1[i];
			arr1[i] = arr1[i+1];
			arr1[i+1] = temp;
		}
	}
	
	/*This can be done in O(n) time by doing a single traversal of given array. 
	 * The idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..) 
	 * elements are greater than their adjacent odd elements, we don’t need to worry about odd positioned element. 
	 * Following are simple steps.
1) Traverse all even positioned elements of input array, and do following.
….a) If current element is smaller than previous odd element, swap previous and current.
….b) If current element is smaller than next odd element, swap next and current.

Below are implementations of above simple algorithm.
*/
	
	private static void sortSolution2(int[] arr2) {
		int temp = 0;
		
		if(arr2[0] < arr2[1])
		{
		temp = arr2[0];
		arr2[0] = arr2[1];
		arr2[1] = temp;
		}
		int n = arr2.length;
		for(int i = 2 ; i < n ; i+=2)
		{
			if(arr2[i] < arr2[i+1] && i<n-1)
			{
				temp = arr2[i];
				arr2[i] = arr2[i+1];
				arr2[i+1] = temp;
			}
			if(arr2[i] < arr2[i-1])
			{
				temp = arr2[i];
				arr2[i] = arr2[i-1];
				arr2[i-1] = temp;
			}
		}
	}

	
	
	public static void mergeSort(int a[] , int l , int r)
	{
		
		if(l<r)
		{
			int m = l+(r-l)/2;
			
			mergeSort(a , l , m);
			mergeSort(a , m+1 , r);
			
			merge(a , l , r , m);
		}
		
	}
	
	public static void merge(int a[] , int l , int r , int m)
	{
		    int i, j, k;
			int n1 = m - l + 1;
			int n2 =  r - m;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(i = 0; i < n1 ; i++)
			left[i] = a[l+i];
		for(j = 0 ; j < n2 ; j++)
			right[j] = a[m+1+j];
		
		/* Merge the temp arrays back into arr[l..r]*/
		i = 0; // Initial index of first subarray
		j = 0; // Initial index of second subarray
		k = l; // Initial index of merged subarray
		
		while(i<n1 && j<n2)
		{
			if(left[i] < right[j])
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<n1)
		{			
			a[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}

}
