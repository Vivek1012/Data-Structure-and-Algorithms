import java.util.Scanner;

public class LCA {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the node 1 value :");
		int a = s.nextInt();
		System.out.println("Enter the node 2 value : ");
		int b = s.nextInt();
		
		TreeNode val = findLCA(root , a , b);
		System.out.println("The Least Common ancestor is = " + val.data);
	}
	
	public static TreeNode findLCA(TreeNode root , int a , int b)
	{
		if(root == null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		TreeNode left = findLCA(root.left , a , b);
		TreeNode right = findLCA(root.right , a , b);
		
		if(left != null && right != null)
			return root;
		
		return (left != null ? left : right);
		
	}
}
