import java.util.*;

public class FindMaximum {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int n = findMaximumElement(root);
		System.out.println("The maximum value in Tree = " + n);
	}

	private static int findMaximumElement(TreeNode root) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		if(root == null)
			return 0;
		else
		{
			int leftmax = findMaximumElement(root.left);
			int rightmax = findMaximumElement(root.right);

			max = Math.max(leftmax , rightmax);
			
			if(max < root.data)
				max = root.data;
		}
		
		return max;
	}
	
	
}
