
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode()
	{
		data = 0;
		left = null;
		right = null;
		next = null;
	}
	
	public TreeNode(int data)
	{
		this.data = data;
		left = right = next = null;
	}
}
