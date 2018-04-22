import java.util.Scanner;

public class LargestSubarray {

	public LargestSubarray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements : ");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter the 0's and 1's for computations :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int c = 0;
		int max = 0;
		int posi = 0; 
		int posj = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			c = 0;
			for(int j = i ; j < n ; j++)
			{
				if(arr[j] == 1)
					c++;
				else 
					c--;
				
				if(c == 0)
				{
					if((j-i+1) > max)
					{
						max = j-i+1;
						posi = i;
						posj = j;
					}
				}
			}
		}
		
		System.out.println(posi + " " + posj);
	}

}
