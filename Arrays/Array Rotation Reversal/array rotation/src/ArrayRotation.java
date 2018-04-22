import java.util.*;
public class ArrayRotation {

	public ArrayRotation() {
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
		
		System.out.println("Enter the postition you want to rotate :");
		
		int t = s.nextInt();
		
		for(int i = 0 ; i < t ; i++)
		{
			int temp = arr[0];
			for(int j = 0 ; j < n-1 ; j++)
			{
				arr[j] = arr[j+1];
			}
			arr[n-1] = temp;
		}
		
		
		for(int i = 0; i < n ; i++ )
		{
			System.out.print(arr[i] + " ");
		}
	}
}
