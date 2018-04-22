package abc.xyz.jGraphT;

import java.util.Scanner;

public class SpiralMatrix {

	public SpiralMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of array in n and m format :");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = s.nextInt();
			}
		}

		int jmin = 0;
		int jmax = m - 1;
		int imin = jmin + 1;
		int imax = n - 1;

		int count = 0;
		int i = 0;
		int j = 0;
		while (count != (n * m)) {
			for (j = jmin; j <= jmax; j++) {
				System.out.println(a[i][j]);
				count++;
			}
			if (count == (n * m))
				break;
			j = jmax--;
			
			for (i = imin; i <= imax; i++) {
				System.out.println(a[i][j]);
				count++;
			}
			if (count == (n * m))
				break;
			i = imax--;
			
			for (j = jmax; j >= jmin; j--) {
				System.out.println(a[i][j]);
				count++;
			}
			if (count == (n * m))
				break;
			j = jmin++;

			for (i = imax; i >= imin; i--) {
				System.out.println(a[i][j]);
				count++;
			}
			if (count == (n * m))
				break;
			i = imin++;

		}
		
		int arr[][] = fillspiral(n);
		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n ; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static int[][] fillspiral(int n) {
		// TODO Auto-generated method stub
		
		int arr[][] = new int[n][n];
		int k = n*n;

		int jmin = 0;
		int jmax = n - 1;
		int imin = jmin + 1;
		int imax = n - 1;

		int count = 0;
		int i = 0;
		int j = 0;
		while (count != k) {
			for (j = jmin; j <= jmax; j++) {
				arr[i][j] = ++count;
			}
			if (count == k)
				break;
			j = jmax--;
			
			for (i = imin; i <= imax; i++) {
				arr[i][j] = ++count;
			}
			if (count == k)
				break;
			i = imax--;
			
			for (j = jmax; j >= jmin; j--) {
				arr[i][j] = ++count;
			}
			if (count == k)
				break;
			j = jmin++;

			for (i = imax; i >= imin; i--) {
				arr[i][j] = ++count;
			}
			if (count == k)
				break;
			i = imin++;

		}
		

		return arr;
	}

}
