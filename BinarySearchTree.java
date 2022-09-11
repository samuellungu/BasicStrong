public class BinarySearchTree {
    
    class Node{
        int value;
        Node left, right;

        public Node(int item){
            this.value=item;
            left=right=null;
        }
    }
    Node root;

    BinarySearchTree(){
        root = null;
    }
    public void getInorder(Node root){
        if(root!=null){
            getInorder(root.left);
            System.out.println(root.value);
            getInorder(root.right);
        }
    }
    //insert methods
    public Node search(int value){
        return searchInBST(this.root, value);
    }
    
    private Node searchInBST(Node node, int value){
        
        if(node==null || node.value==value)
            return node;

        if(value < node.value){
            return searchInBST(node.left, value);
            //return node.left;
        }
        else if (value > node.value){
            return searchInBST(node.right, value);
            //return node.left;
        }
        return node;

    }


    public void insert(int value){
        this.root = insertInBST(this.root, value);
    }
    
    private Node insertInBST(Node node, int value){
        
        if(node==null)
            return new Node(value);

        if(value < node.value){
            node.left = insertInBST(node.left, value);
            //return node.left;
        }
        else if (value > node.value){
            node.right = insertInBST(node.right, value);
            //return node.left;
        }
        return node;

    }

    //Delete operation
    public void delete(int value){
        deleteFromBST(this.root, value);
    }
    private Node deleteFromBST(Node node, int value){
        if(node == null)
            return node;

        if(value < node.value)
            node.left = deleteFromBST(node.left, value);

        else if (value > node.value)
            node.right = deleteFromBST(node.right, value);

        else{
            if(node.left==null)
                return node.right;
            else if(node.right==null)
                return node.left;
            
            node.value = minValue(node.right);
            node.right = deleteFromBST(node.right, node.value);
        }
        return node;
    }
    private int minValue(Node right){
        int min = right.value;

        while(right.left!=null){
            min = right.left.value;
            right = right.left;
        }
        return min;
    }

    public static void main (String [] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(13); 
        tree.insert(15);
        tree.insert(7);
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(14);
        tree.insert(16);


        tree.getInorder(tree.root);
        System.out.println(tree.search(7).value );
        System.out.println("Deleting 13: ");
        tree.delete(13);
        tree.getInorder(tree.root);
    }
}
