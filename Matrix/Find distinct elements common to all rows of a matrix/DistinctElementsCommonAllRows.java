import java.util.*;

public class DistinctElementsCommonAllRows
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
		
		HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
		for(int i  = 0 ; i < n ; i++)
		{
			if(!hm.containsKey(mat[0][i]))
			{
				hm.put(mat[0][i] , 1);
			}
		}
		
		for(int i = 1 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if(hm.containsKey(mat[i][j]) && hm.get(mat[i][j]) == i)
					hm.put(mat[i][j] , hm.get(mat[i][j]) + 1);
			}
		}
		
		for(Map.Entry<Integer , Integer> entry : hm.entrySet())
		{
			if(entry.getValue() == 4)
				System.out.println(entry.getKey());
		}
		
	}
	
	
}