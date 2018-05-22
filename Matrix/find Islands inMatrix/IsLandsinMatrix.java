import java.util.*;

public class IsLandsinMatrix
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of matrix");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of matrix :");
		int mat[][] = new int[n][n];
		
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				mat[i][j] = s.nextInt();
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if(mat[i][j] == 1)
					{
						++count;
						DfsComputations(mat , i , j , n);
					}
			}
		}
		
		System.out.println(count);
	}
	
	public static void DfsComputations(int mat[][] , int i , int j , int n)
	{
		if(i >= n || i < 0 || j >= n || j < 0 || mat[i][j] == 0)
			return;
		
		mat[i][j] = 0;
		DfsComputations(mat , i+1 , j, n);
		DfsComputations(mat , i-1 , j, n);
		DfsComputations(mat , i , j+1, n);
		DfsComputations(mat , i , j-1, n);
		DfsComputations(mat , i+1 , j+1, n);
		DfsComputations(mat , i-1 , j+1, n);
		DfsComputations(mat , i+1 , j-1, n);
		DfsComputations(mat , i-1 , j-1, n);
		
		
	}
}