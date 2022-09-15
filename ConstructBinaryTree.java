package Alg;

import java.util.HashMap;
import java.util.Map;

class Node{
	int data;
	Node left, right;
	
	Node(int data){
		this.data=data;
	}
}
public class ConstructBinaryTree {

	public static void main(String[] args) {

		int [] inorder = {1,5,7,6,9,14,12};
		int [] level = {9,5,12,1,6,14,7};
		
		Node root = construct(inorder, level);
		System.out.println("Inorder traversal of the constructed");
		inorderTraversal(root);

	}
	public static void inorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}

	private static Node construct(int[] inorder, int[] level) {

		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<level.length;i++) {
			map.put(level[i], i);
		}
				
		return construct(inorder, 0,inorder.length-1, map );
	}

	private static Node construct(int[] inorder, int start, int end, Map<Integer, Integer> map) {

		if(start > end) return null;

		int index = start;
		
		for(int i=start+1; i <= end;i++) {
			if(map.get(inorder[i])< map.get(inorder[index])) {
				index=i;
			}
		}
		Node root = new Node(inorder[index]);
		
		//left subtree
		root.left = construct(inorder, start, index-1, map);
		
		//right structure
		root.right = construct(inorder, index+1, end, map);
		
		return root;
	}

}
