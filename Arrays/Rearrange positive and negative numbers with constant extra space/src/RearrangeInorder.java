import java.util.*;

public class RearrangeInorder {

	public RearrangeInorder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the number of elements :");
		int n = s.nextInt();

		int arr[] = new int[n];
		System.out.println("Enter the elements of array ");

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		/* We can modify insertion sort to solve this problem. */

		/*
		 * Loop from i = 1 to n - 1. a) If the current element is positive, do nothing.
		 * b) If the current element arr[i] is negative, we insert it into sequence
		 * arr[0..i-1] such that all positive elements in arr[0..i-1] are shifted one
		 * position to their right and arr[i] is inserted at index of first positive
		 * element.
		 */

		InsertionSortMethod(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	private static void InsertionSortMethod(int[] arr, int n) {
		// TODO Auto-generated method stub
		int key = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < 0) {
				key = arr[i];
				int j = i - 1;

				while (j >= 0 && arr[j] > 0) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}

	}

}
