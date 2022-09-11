class Node {
	
	int value;
	Node left;//=null;
	Node right;// = null;
	
	Node(int value){
		this.value=value;
		left=null;
		right=null;
	}

	public int convertIntoSumTree(Node node) {
		
		if(node ==null)
			return 0;
		
		int oldValue = node.value;
		int leftTreeSum = convertIntoSumTree(node.left);
		int rightTreeSum = convertIntoSumTree(node.right);
		
		node.value = leftTreeSum + rightTreeSum;
		
		return node.value + oldValue;
	}

	public void printInorder(Node node) {
		if (node==null)
			return;		
		printInorder(node.left);
		System.out.println(node.value+ " ");
		printInorder(node.right);
		
		
	}

}

public class SumTree {

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(-4);
		root.left.left = new Node(3);
		root.left.right = new Node(-6);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		
		root.convertIntoSumTree(root);
		root.printInorder(root);

	}
}
