import java.util.Scanner;

public class MatrixRotation90 {

	public MatrixRotation90() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of 2D array n and m :");
		int n = s.nextInt();
		int m = s.nextInt();
		
		int arr [][] = new int[n][m];
		
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < m ; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}
		
		// first find the transpose of the given array
		
		int temp = 0;
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j <= i ; j++)
			{
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		for(int i = 0 ; i < n/2 ; i++)
		{
			for(int j = 0 ; j < m ; j++)
			{
				temp = arr[i][j];
				arr[i][j] = arr[n-i-1][j];
				arr[n-i-1][j] = temp;
			}
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < m ; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
