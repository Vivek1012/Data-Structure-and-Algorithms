import java.util.*;


public class NextPointer {
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		connect(root);
		int val = 0;
		
	}
	
	public static void connect(TreeNode node)
	{
		if(node == null)
			return;
		
		TreeNode first = node;
		while(first != null)
		{
			TreeNode que = first;
			while(que != null)
			{
				if(que.left != null)
				{
					if(que.right != null)
						que.left.next = que.right;
					else
						que.left.next = getNext(que);
				}
				if(que.right != null)
					que.right.next = getNext(que);
				
				que = que.next;
			}
			
			if(first.left != null)
				first = first.left;
			else if(first.right != null)
				first = first.right;
			else
				first = first.next;
		}
	}
	
	public static TreeNode getNext(TreeNode node)
	{
		TreeNode temp = node.next;
		while(temp != null)
		{
			if(temp.left != null)
				return temp.left;
			if(temp.right != null)
				return temp.right;
			
			temp = temp.next;
		}
		
		return null;
	}
}

