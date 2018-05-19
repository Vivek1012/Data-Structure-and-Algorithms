import java.util.*;

public class diameterOfTree {
	public static void main(String args[]) {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);
	
	int dia = findDiameter(root);
	System.out.println(dia);
	}
	
	public static int findDiameter(TreeNode node)
	{
		if(node == null)
			return 0;
		//the concept of finding the diameter is 
		//1. you could get add (height of left subtree and height of right subtree) + 1(for root)
		
		int leftheight = height(node.left);
		int rightheight = height(node.right);
		
		int len1 = (leftheight + rightheight) + 1;
		
		//2. you could find the Max of (diameter(root.left) , diameter(root.right)); 
		
		int len2 = Math.max(findDiameter(node.left) , findDiameter(node.right));
		
		return Math.max(len1 , len2);
	}

	private static int height(TreeNode node) {
		// TODO Auto-generated method stub
		
		if(node == null)
			return 0;

		return (Math.max(height(node.left) , height(node.right)) + 1);
	}
}
