import java.util.Scanner;

public class MatrixRotation {

	public MatrixRotation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of array in n and m format :");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		System.out.println("Enter the elements of array : ");
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = s.nextInt();
			}
		}

		int jmin = 0;
		int jmax = m - 1;
		int imin = jmin;
		int imax = n - 1;

		int count = 0;
		int i = 0;
		int j = 0;
		int temp = 0;
		int next = 0, prev = 0;
		
		while (count != (n * m)) {
			
			prev = a[imin][jmin];
			i = imin; j = 0;

			for (j = jmin; j < jmax; j++) {
				next = a[i][j+1];
				a[i][j+1] = prev;
				prev = next;
				count++;
			}
			if (count == (n * m))
				break;	
//			jmax--;
			
			
			for (i = imin; i < imax; i++) {
				next = a[i+1][j];
				a[i+1][j] = prev;
				prev = next;
				count++;
			}
			if (count == (n * m))
				break;
//			imax--;
			
			for (j = jmax; j > jmin; j--) {
				next = a[i][j-1];
				a[i][j-1] = prev;
				prev = next;
				count++;
			}
			if (count == (n * m))
				break;
//			jmin++;
			
			for (i = imax; i > imin; i--) {
				next = a[i-1][j];
				a[i-1][j] = prev;
				prev = next;
				count++;
			}
			if (count == (n * m))
				break;
//			imin++;

			imin++;
			jmin++;
			imax--;
			jmax--;
			
			if(imin == imax && jmin == jmax)
				break;
		}

		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < m ; j++)
			{
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
