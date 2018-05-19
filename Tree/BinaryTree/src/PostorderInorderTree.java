import java.util.*;

public class PostorderInorderTree {
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of tree :");
		int n = s.nextInt();
		System.out.println("Enter the inorder sequence :");
		int in[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			in[i] = s.nextInt();
		}

		System.out.println("Enter the postorder sequence :");
		int post[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			post[i] = s.nextInt();
		}
		
		TreeNode root = constructTree(post , 0 , n-1 , in , 0 , n-1);
		int val = 0;
		System.out.println(val);
	}
	
	public static TreeNode constructTree(int[] post , int poststart , int postend , int[] in , int instart , int inend) {
		if(poststart > postend || instart > inend )
			return null;
		
		int val = post[postend];
		TreeNode node = new TreeNode(val);
		int offset = instart;
		for(; offset < inend ; offset++)
		{
			if(in[offset] == val)
				break;
		}
		
		node.left = constructTree(post , poststart  , poststart + offset - instart - 1 , in , instart , offset-1);
		node.right = constructTree(post , poststart + offset - instart , postend - 1, in , offset + 1 , inend);
		
		return node;
	} 
}
