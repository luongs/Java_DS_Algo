package Ch8_Trees;

public class BST2 {
	
	private class Node {
		Node left; 
		Node right;
		int key; 
		
		public Node(Node left, Node right, int key) {
			this.left = left;
			this.right = right;
			this.key = key;
		}
		
		public String toString(){
			return "Key: "+key;
		}
	}
	
	Node root; 

	/**
	 * Insert node in binary search tree
	 * @param tree
	 * @param newValue
	 */
	public void insert(BST2 tree, int newKey){
		Node newValue = new Node(null, null, newKey);
		Node walker = null;
		Node runner = tree.root;
		
		while (runner!=null){
			walker = runner;	// set walker one step behind - useful for adding later

			if ( newValue.key < runner.key)
				runner = runner.left;
			else
				runner = runner.right;
		}
		
		// This is an empty tree
		if (walker==null)
			tree.root = newValue;
		else if (newValue.key < walker.key)
			walker.left = newValue;
		else	// place right if newValue key > walker
			walker.right = newValue;
	}
	
	public void preOrder(Node node){
		if (node == null)
			return;
		
		System.out.println(node);
		preOrder(node.left);
		preOrder(node.right);
	}
	

	public static void main(String[] args) {
		BST2 tree = new BST2();
		tree.insert(tree, 12);
		tree.insert(tree, 5);
		tree.insert(tree, 19);
		tree.insert(tree, 13);
		tree.insert(tree, 17);
		tree.insert(tree, 15);
		tree.insert(tree, 2);
		tree.insert(tree, 9);
		tree.insert(tree, 18);
		
		Node root = tree.root;
		tree.preOrder(root);

	}

}
