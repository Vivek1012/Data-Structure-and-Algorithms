import java.util.*;

public class KPairSmallestSum
{
	public static void main(String args[])
	{
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of first array :");
		int an = s.nextInt();
		System.out.println("Enter the size of second array :");
		int bn = s.nextInt();
		
		int arr1[] = new int[an];
		int arr2[] = new int[bn];
		
		System.out.println("Enter the elements of 1st array :");
		for(int i = 0 ; i < an ; i++)
		{
			arr1[i] = s.nextInt();
		}
		
		System.out.println("Enter the elements of 2nd array :");
		for(int i = 0 ; i < bn ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.println("Enter the number of pairs you want to get :");
		int k = s.nextInt();
		
		int out[][] = new int[2][k];
		
		int i = 0;
		int j = 0;
		int K = 1;
		out[0][0] = arr1[0];
		out[1][0] = arr2[0];
		int sum1 = 0;
		int sum2 = 0;
		
		while(k > K)
		{
			
			if(j < bn-1)
				 {
					if(i == -1)
						i = 0;
					
					sum1 = arr1[i] + arr2[j+1];
				 }
			if(i < an-1)
			{
				if(j == -1)
					j = 0;
				sum2 = arr1[i+1] + arr2[j];
			}
			if(sum1 > sum2 && j < bn-1)
				j = (j+1);
			else if(sum1 < sum2 && i < an-1)
				i = (i+1);
				
				out[0][K] = arr1[i];
				out[1][K] = arr2[j];
				
				K++;
				
				if(i == an-1)
					i = -1;
				if( j == bn-1)
					j = -1;
		}
		
		
		for(int a = 0 ; a < k ; a++)
		{
			System.out.println(out[0][a] + "\t" + out[1][a]);
		}
	}
}