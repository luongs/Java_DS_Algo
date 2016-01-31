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
	
	public int minimum() {
		Node node = root; 
		if (root == null)
			return -1;

		// Go to node before leftmost
		while(node.left !=null) 
			node = node.left;
		
		return node.key;
	}
	
	public int maximum() {
		Node node = root; 
		if (root == null)
			return -1;
		
		// Go to node before rightmost
		while (node.right != null)
			node = node.right;
		
		return node.key;
		
	}
	
	public boolean search(int key, Node node){

		// either tree is empty or key was not found
		if (node==null)
			return false;
		if (key==node.key)
			return true; 
		
		if (key<node.key)
			return search(key, node.left);
		else 	// key > node.key
			return search(key, node.right);
	}
	
	/**
	 * Print inorder traversal
	 * Visit left, root, right
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node==null)
			return;
		inOrder(node.left);
		System.out.println(node);
		inOrder(node.right);
	}
	
	/**
	 * Print preorder traversal (each node as its passed) 
	 * Visit Root - Left - Right
	 * @param node
	 */
	public void preOrder(Node node){
		if (node == null)
			return;
		
		System.out.println(node);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * Print postorder traversal 
	 * Visit left, right, root
	 * @param node
	 */
	public void postOrder(Node node){
		if (node==null)
			return; 
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node);
	}
	

	public static void main(String[] args) {
		BST2 tree = new BST2();
		tree.insert(tree, 12);
		tree.insert(tree, 5);
		tree.insert(tree, 18);
		tree.insert(tree, 2);
		tree.insert(tree, 15);
		tree.insert(tree, 9);
		tree.insert(tree, 19);
		tree.insert(tree, 13);
		tree.insert(tree, 17);
		
		Node root = tree.root;
		// tree.preOrder(root);
		//tree.postOrder(root);
		//tree.inOrder(root);
		
		System.out.println("Search: "+tree.search(12, root));
		System.out.println("Minimum is "+tree.minimum());
		System.out.println("Maximum is "+tree.maximum());
		
	}

}
