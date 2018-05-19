import java.util.*;
public class PrintRootTochildPath {
	public static ArrayList<String> ar = new ArrayList<String>();
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		String str = "";
		printPath(root, str);
		
		for(String s : ar)
		{
			System.out.print(s + "");
		}
	}
	
	public static void printPath(TreeNode node , String str)
	{
		if(node == null)
			return ;
		
		str = str + node.data;
		if(node != null)
		{
			if(node.left != null)
				printPath(node.left , str);
			if(node.right != null)
				printPath(node.right , str);
			
			if(node.left == null && node.right == null)
				ar.add(str);
		}
	}
}
