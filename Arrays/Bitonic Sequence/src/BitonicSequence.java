//----------------------------------------Problem---------------------------------------------
/*Given an array A[0 … n-1] containing n positive integers,
 *  a subarray A[i … j] is bitonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j].
 *   Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
Expected time complexity of the solution is O(n)
*/

//-----------------------------------------Example---------------------------------------------
/*
 * 1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.

2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.

Extreme Examples
1) A[] = {10}, the single element is bitnoic, so output is 1.

2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.

3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.
*/

/*
 * ---------------------------------------Solution----------------------------------------------
Let us consider the array {12, 4, 78, 90, 45, 23} to understand the soultion.
1) Construct an auxiliary array inc[] from left to right such that inc[i] contains length of the nondecreaing subarray ending at arr[i].
For for A[] = {12, 4, 78, 90, 45, 23}, inc[] is {1, 1, 2, 3, 1, 1}

2) Construct another array dec[] from right to left such that dec[i] contains length of nonincreasing subarray starting at arr[i].
For A[] = {12, 4, 78, 90, 45, 23}, dec[] is {2, 1, 1, 3, 2, 1}.

3) Once we have the inc[] and dec[] arrays, all we need to do is find the maximum value of (inc[i] + dec[i] – 1).
For {12, 4, 78, 90, 45, 23}, the max value of (inc[i] + dec[i] – 1) is 5 for i = 3.*/


import java.util.*;

public class BitonicSequence {

	public BitonicSequence() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		System.out.println("enter the number of elements for an array : ");
		int n = s.nextInt();

		System.out.println("Enter the elements for array : ");
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int maxlength = BitonicSeq(arr, n);
		System.out.println("The maximum length of bitionic sequence is = " + maxlength);

	}

	private static int BitonicSeq(int[] arr, int n) {
		// TODO Auto-generated method stub
		// create non decreasing cumultive array from left to right

		int leftToright[] = new int[n];
		leftToright[0] = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				leftToright[i] = leftToright[i-1] + 1;
			} else
				leftToright[i] = 1;
		}
		
		int maxlr = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(leftToright[i] + "\t");
			if(maxlr<leftToright[i])
				maxlr = leftToright[i];
		}
		System.out.println(maxlr);
		// create non-decreasing cumultive array from right to left

		int rightToleft[] = new int[n];
		rightToleft[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i + 1] < arr[i]) {
				rightToleft[i] = rightToleft[i+1] + 1;
			} else
				rightToleft[i] = 1;
		}
		
		int maxrl = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(rightToleft[i] + "\t");
			if(maxrl<rightToleft[i])
				maxrl = rightToleft[i];
		}
		
		System.out.println(maxrl);
		return (maxlr + maxrl) - 1;
	}
	
	
}
