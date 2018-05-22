import java.util.*;

public class RowWithMaximum1
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
		
		int i = 0;
		int j = n-1;
		
		while(i < n && j >= 0)
		{
			if(mat[i][j] == 1)
				j--;
			else
				i++;
		}
		System.out.println(n-j-1);
	}
}