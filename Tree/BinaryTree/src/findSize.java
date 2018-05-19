
public class findSize {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int n = findSize(root);
		System.out.println("The maximum value in Tree = " + (n) );
	}

	private static int findSize(TreeNode root) {
		// TODO Auto-generated method stub

		int leftsum = (root.left == null ? 0 : findSize(root.left));
		int rightsum = (root.right == null ? 0 : findSize(root.right));
	
		return 1 + leftsum + rightsum;
	}
}
