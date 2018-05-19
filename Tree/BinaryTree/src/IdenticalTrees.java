import java.util.*;

public class IdenticalTrees {
	public static void main(String args[])
	{
		//Root1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		
		//Root2
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		
		boolean check = checkTreeIdentical(root1 , root2);
		System.out.println(check);
	}

	private static boolean checkTreeIdentical(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub 
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		else if(root1.data != root2.data)
			return false;
		
		return (checkTreeIdentical(root1.left , root2.left) && checkTreeIdentical(root1.right , root2.right)); 
		
	}
}
