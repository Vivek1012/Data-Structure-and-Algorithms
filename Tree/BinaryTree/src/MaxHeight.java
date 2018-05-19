import java.util.*;

public class MaxHeight {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int h = maxHeight(root);
	}
	
	public static int maxHeight(TreeNode node)
	{
		if(node == null)
			return 0;

		return Math.max(maxHeight(node.left) , maxHeight(node.right)) + 1;
	}
}
