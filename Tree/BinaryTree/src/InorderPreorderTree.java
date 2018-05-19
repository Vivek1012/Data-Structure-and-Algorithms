import java.util.*;

public class InorderPreorderTree {
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

		System.out.println("Enter the preorder sequence :");
		int pre[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			pre[i] = s.nextInt();
		}
		
		TreeNode root = constructTree(pre , 0 , n-1 , in , 0 , n-1);
		int val = 0;
		System.out.println(val);
	}
	
	public static TreeNode constructTree(int[] pre , int prestart , int preend , int[] in , int instart , int inend) {
		if(prestart > preend || instart > inend )
			return null;
		
		int val = pre[prestart];
		TreeNode node = new TreeNode(val);
		int offset = instart;
		for(; offset < inend ; offset++)
		{
			if(in[offset] == val)
				break;
		}
		
		node.left = constructTree(pre , prestart+1 , prestart + offset - instart , in , instart , offset-1);
		node.right = constructTree(pre , prestart + offset - instart + 1 , preend, in , offset + 1 , inend);
		
		return node;
	} 
	
}
