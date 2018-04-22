import java.util.Scanner;

public class Sieve {

	public Sieve() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s =  new Scanner(System.in);
		
		System.out.println("Enter the number to find prime sum :");
		int n = s.nextInt();
		int is_prime[] = new int[n+1];
		
		for(int i = 0 ; i <= n ; i++)
		{
			is_prime[i] = 1;
		}
		
		for(int p = 2 ; p*p <= n ; p++)
		{
			if(is_prime[p] == 1)
			{
				for(int i = 2*p ; i <= n ; i = i + p)
				{
					is_prime[i] = 0;
				}
			}
		}
		 for(int i = 2; i <= n; i++)
	        {
	            if(is_prime[i] == 1)
	                System.out.print(i + " ");
	        }		
	}
}
