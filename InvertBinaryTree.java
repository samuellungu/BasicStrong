public class InvertBinaryTree {
    public static void main(String[]args){
        Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
        root.left.left.right = new Node(6);

        root.printInorder(root);
        root.invertTree(root);
        System.out.println();
        root.printInorder(root);
    }
}
class Node {
	
	int value;
	Node left;//=null;
	Node right;// = null;
	
	Node(int value){
		this.value=value;
		//left=null;
		//right=null;
	}
    public void invertTree(Node node) {
        if(node==null)
            return;

        Node temp=node.left;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);
        
    }
    public void printInorder(Node node){
        if(node==null)
            return;
        printInorder(node.left);
        System.out.println(node.value+" ");
        printInorder(node.right);

        
    }

} 
