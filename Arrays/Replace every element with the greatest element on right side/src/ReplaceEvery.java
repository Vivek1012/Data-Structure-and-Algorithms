import java.util.Scanner;

public class ReplaceEvery {

	public ReplaceEvery() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		for(int i = 0  ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int temp = arr[n-1];
		int val = 0;
		
		for(int i = n-2 ; i >=0 ; i--)
		{
			if(i == n-2) {
				temp = (arr[i] > arr[i+1] ? arr[i] : arr[i+1]);
				arr[i] = arr[n-1];
				arr[n-1] = -1;
			}
			else {
					if(temp < arr[i])
					{
						val = arr[i];
						arr[i] = temp;
						temp = val;
					}
					else
						arr[i] = temp;
				}
		}
		
		for(int i = 0; i < n ; i++)
		{
			System.out.println(arr[i]);
		}
		
		}

}
