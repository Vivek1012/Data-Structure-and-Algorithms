import java.util.*;

public class SearchinBinaryTree {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.println("Enter the key you want to search :");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean found = SearchElement(root, n);
		System.out.println("Status of Searched Key = " + found);
	}
	
	public static boolean SearchElement(TreeNode node, int key)
	{
		if(node == null)
			return false;
		else
		{
			if(node.data == key)
				return true;
		}
		
		return (SearchElement(node.left , key) || (SearchElement(node.right, key)));
	}
}
