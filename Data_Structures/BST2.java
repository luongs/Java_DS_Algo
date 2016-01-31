package Ch8_Trees;

public class BST2 {
	
	private class Node {
		Node left; 
		Node right;
		Node parent;
		int key; 
		
		public Node(Node parent, Node left, Node right, int key) {
			this.parent = parent;
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
	 * Iterative
	 * @param tree
	 * @param newValue
	 */
	public void insert(BST2 tree, int newKey){
		Node newValue = new Node(null ,null, null, newKey);
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
			// parent stays null since its root
			tree.root = newValue;
		else if (newValue.key < walker.key){
			walker.left = newValue;
			walker.left.parent = walker;
		}
		else{	// place right if newValue key > walker
			walker.right = newValue;
			walker.right.parent = walker;
		}
	}
	
	/**
	 * Return minimum key if it exists
	 * Iterative
	 * @return
	 */
	public int minimum() {
		Node node = root; 
		if (root == null)
			return -1;

		// Go to node before leftmost
		while(node.left !=null) 
			node = node.left;
		
		return node.key;
	}
	
	/**
	 * Return maximum key if it exists
	 * Iterative
	 * @return
	 */
	public int maximum() {
		Node node = root; 
		if (root == null)
			return -1;
		
		// Go to node before rightmost
		while (node.right != null)
			node = node.right;
		
		return node.key;
		
	}
	
	/**
	 * Check if key exists in BST, returns true if exists
	 * Recursive
	 * @param key
	 * @param node
	 * @return
	 */
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
	 * Recursive
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
	 * Recursive
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
	 * Recursive
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
		//tree.preOrder(root);
		//tree.postOrder(root);
		//tree.inOrder(root);
		
		System.out.println("Search: "+tree.search(12, root));
		System.out.println("Minimum is "+tree.minimum());
		System.out.println("Maximum is "+tree.maximum());
		
	}

}
