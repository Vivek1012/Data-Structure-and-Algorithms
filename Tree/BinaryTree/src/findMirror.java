import java.util.*;
public class findMirror {
	public static void main(String args[])
	{
		//Root1
				TreeNode root1 = new TreeNode(1);
				root1.left = new TreeNode(2);
//				root1.right = new TreeNode(3);
//				root1.left.left = new TreeNode(4);
//				root1.left.right = new TreeNode(5);
				
				//Root2
				TreeNode root2 = new TreeNode(1);
				root2.left = new TreeNode(3);
				root2.right = new TreeNode(2);
//				root2.right.left = new TreeNode(5);
//				root2.right.right = new TreeNode(4);
				
		boolean check = findMirror(root1 , root2);
		System.out.println(check);
	}
	
	public static boolean findMirror(TreeNode root1 , TreeNode root2)
	{
		//there is proble with this code you must know where to do what
		/*
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
			if(root1.data == root2.data)
				return findMirror(root1.left , root2.right);
			if(root1.data == root2.data)
				return findMirror(root1.right , root2.left);
			
		return false;*/
		

		 if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data != root2.data)
			return false;
		
		return (findMirror(root1.left , root2.right) && findMirror(root1.right , root2.left));
	}
}
