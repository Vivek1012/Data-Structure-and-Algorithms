import java.util.*;
public class Combinations {

	public Combinations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of n :");
		int n = s.nextInt();
		System.out.println("Enter the value of r :");
		int r = s.nextInt();
		int nCr = getCombinations(n,r);
		System.out.println("The value of nCr = " + nCr);
	}

	private static int getCombinations(int n, int r) {
		// TODO Auto-generated method stub
		// using the property (n-1)C(r) + (n-1)C(r-1) = (n-1)C(r)

		if(r == 0 || r == n)
			return 1;
		
		return getCombinations(n-1 , r-1) + getCombinations(n-1 , r);
	}

}
