import java.util.Scanner;

public class maximumSum {

	public maximumSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		System.out.println("Enter the array elements :");
		
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ;i++)
		{
			arr[i] = s.nextInt();
		}
		int max = 0;
		
		for(int j = 0 ; j < n ; j++)
		{
			max = max + (j*arr[j]);
		}
	
		for(int i = 0 ; i < n ; i++)
		{
			int sum = 0;
			int temp = arr[0];
			for(int j = 0 ; j < n-1 ; j++)
			{
				arr[j] = arr[j+1];
			}
			arr[n-1] = temp;

			for(int j = 0 ; j < n ; j++)
			{
				sum = sum + (j*arr[j]);
			}
			
			if(sum > max)
				max = sum;
		}
		
		System.out.println("The maximum sum for (i*arr[i]) = " + max);
	}
	
}
