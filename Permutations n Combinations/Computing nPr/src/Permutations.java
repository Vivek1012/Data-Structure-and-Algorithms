import java.util.*;

public class Permutations {

	public Permutations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the value of n :");
		int n = s.nextInt();
		
		System.out.println("Enter the value of r :");
		int r = s.nextInt();
		
		int nPr = getPermutations(n,r);
		System.out.println("The permutation value = " + nPr);
		
	}

	private static int getPermutations(int n, int r) {
		// TODO Auto-generated method stub
		
		//Using the property (n)P(r) = n * (n-1)P(r-1)
		
		if(r == 0)
			return 1;
		
		return (n * getPermutations(n-1 , r-1));
	}

}
