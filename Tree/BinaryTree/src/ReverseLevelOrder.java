import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		//printing 4 5 6 7 2 3 1  
		ArrayList<Integer> ar = ReverseLevel(root);
		for(Integer i : ar)
		{
			System.out.print(i + "\t");
		}
	}

	private static ArrayList<Integer> ReverseLevel(TreeNode root) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode t = q.poll();
			if(t.right != null)
				q.add(t.right);
			if(t.left != null)
				q.add(t.left);
			
			s.push(t);
		}
		
		while(!s.isEmpty()) {
			arr.add(s.pop().data);
		}
		return arr;
	}
	
	
	
}
