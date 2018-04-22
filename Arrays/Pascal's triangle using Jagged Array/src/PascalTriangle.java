import java.util.Scanner;

public class PascalTriangle {

	public PascalTriangle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the kth row for Pascal's Trinagle : ");
		Scanner s =  new Scanner(System.in);
		int  k = s.nextInt();
		
		int arr[][] = GetPascals(k);
		
		
		for(int i = 0 ; i < k ; i++ )
		{
			for(int j = 0 ; j <= i ; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

		int a[] = nthRowPascals(k);
		
		for(int i = 0 ; i < a.length; i++)
		{
			System.out.print(a[i] + "\t");
		}
		
	
		
	}

	private static int[] nthRowPascals(int A) {
		// TODO Auto-generated method stub
		int temp[] = new int[0];
		int arr[];
	
	for(int j = 0 ; j <= A ; j++ )
		{
			arr = new int[temp.length + 1];
			for(int i = 0 ; i <= j ; i++)
			{
				if(i == 0 || i == j)
					arr[i] = 1;
				else
				{
					arr[i] = temp[i-1] + temp[i];
				}
			}
			temp = new int[j+1];
			
			for(int i = 0 ; i <= j ; i++)
			{
				temp[i] = arr[i];
			}
		}
		 
		return temp;
	}

	private static int[][] GetPascals(int k) {
		// TODO Auto-generated method stub
		
		int arr[][] = new int[k][];
		
		for(int i = 1 ; i <= k ; i++ )
		{
			arr[i-1] = new int[i];
		}
		
		
		for(int i = 0 ; i < k ; i++ )
		{
			for(int j = 0 ; j <= i ; j++)
			{
				if(j == 0 || j == i)
					arr[i][j] = 1;
				else
				{
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
	
		return arr;
	}

}
