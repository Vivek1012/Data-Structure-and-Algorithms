import java.util.Scanner;

public class FindMissing {

	public FindMissing() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		int n = s.nextInt();

		int arr[] = new int[n];
		System.out.println("Enter the elements of array : ");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int pos = seperate(arr, n);
		int missing = findPositiveMissing(arr , pos);
		
		System.out.println("First missing number = " + missing);
	}

	private static int findPositiveMissing(int[] arr, int n) {
		
		for(int i = 0 ; i <= n ; i++)
		{ 
			if(Math.abs(arr[i])-1 <= n && arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1]; 
		}
		
		for(int i = 0 ; i <= n ; i++)
		{
			if(arr[i] > 0)
				return i+1;
		}
		return n+1;
	}

	public static int seperate(int a[], int n) {
		int j = 0, i;
        for(i = 0; i < n; i++)
        {
           if (a[i] <= 0)  
           {
               int temp;
               temp = a[i];
               a[i] = a[j];
               a[j] = temp;
               // increment count of non-positive 
               // integers
               j++;  
           }
        }
      
        return j;
	}
}
