import java.util.Scanner;

class Node{
	int i;
	int j;
	int val;
	
	public Node()
	{
		i = 0; 
		j = 0;
		val = 0;
	}
	public Node(i, j , val)
	{
		this.i = i;
		this.j = j;
		this.val = val;
	}
}

public class LargestElement {

	public LargestElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50},
              };
		
		System.out.println("Enter the kth element you want to find :");
		int k = s.nextInt();
	}

}
