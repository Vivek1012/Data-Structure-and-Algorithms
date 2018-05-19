import java.util.*;

public class KthMinimumBST {

	public static void main(String args[])
	{
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(8);
		root.right.right = new Node(12);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the kth value :");
		int k = s.nextInt();
		findKthMin(root , k);
	}
	static int count = 0;
	public static void findKthMin(Node node ,int k)
	{
		if(node == null)
			return;
		
		else {
		findKthMin(node.left , k);
		count++;
		if(count == k)
			System.out.println("Kth node = " + node.data);
		
		findKthMin(node.right , k);
		}
	}
	
	
}
