import java.util.*;

public class MagicSquare
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of n :");
		int n = s.nextInt();
		
		int val = 1;
		
		int mat[][] = new int[n][n];
		int i = n/2;
		int j = n-1;
		
		while(val <= (int)Math.pow(n,2))
		{
			
			if(i == -1 && j == n)
			{
				i = i+1;
				j = j-2;
			}
			else{
			
				if(i == -1)
					i = n-1;
				
				if(j == n)
					j = 0;
			}
			
			if(mat[i][j] != 0)
			{
				i = i+1;
				j = j-2;
				continue;
			}
			else 
				mat[i][j] = val++;
				
				
			i = i - 1;
			j = j + 1;
		}

		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n ; j++)
			{
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
