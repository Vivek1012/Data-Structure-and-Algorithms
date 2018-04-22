import java.util.Scanner;

/*
 * Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. 
The idea of the algorithm is:
Reverse A to get ArB. /* Ar is reverse of A */
/*Reverse B to get ArBr. /* Br is reverse of B */
/*Reverse all to get (ArBr) r = BA.

For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]
Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]

 * */
public class ArrayRotationReversal {

	public ArrayRotationReversal() {
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
		
		System.out.println("Enter the number of postition you want to rotate :");
		
		int t = s.nextInt();
		
		for(int i = 0 ; i < t/2 ; i++)
		{
			int temp = arr[i];
			arr[i] = arr[t-i-1];
			arr[t-i-1] = temp;
		}
		
		for(int i = 0 ; i < (n-t)/2 ; i++)
		{
			int temp = arr[i+t];
			arr[i+t] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
		
		for(int i = 0 ; i < n/2 ; i++)
		{
			int temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}
