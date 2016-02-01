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
	 * Substitutes nodeToRmv with nodeToSubs and updates parent.  
	 * Helper function to delete()
	 * @param tree
	 * @param nodeToRmv
	 * @param nodeToSubs
	 */
	public void transplant(BST2 tree, Node nodeToRmv, Node nodeToSubs){
		
		// Substitute when nodeToRmv is root of tree
		if (nodeToRmv.parent == null)
			tree.root = nodeToSubs;
		// Substitute when nodeToRmv is left child of parent
		else if (nodeToRmv == nodeToRmv.parent.left)
			nodeToRmv.parent.left = nodeToSubs;
		// Substitute when nodeToRmv is right child of parent
		else
			nodeToRmv.parent.right = nodeToSubs;
		
		// Transplant is possible with null values, null will substitute
		// current node
		if (nodeToSubs != null)
			nodeToSubs.parent = nodeToRmv.parent;
	}
	
	/**
	 * Delete nodeToRmv from tree and connect child nodes to keep bst properties
	 * Four possible cases. Presence of left and right child at nodeToRmv is trickiest
	 * Iterative
	 * @param tree
	 * @param nodeToRmv
	 */
	public void delete(BST2 tree, Node nodeToRmv) {

		//1. nodeToRmv has no left child
		if (nodeToRmv.left == null)
			// Replace nodeToRmv with its right child
			transplant(tree, nodeToRmv, nodeToRmv.right);
		//2. nodeToRmb has no right child
		else if (nodeToRmv.right == null)
			// Replace nodeToRmv with its left child
			transplant(tree, nodeToRmv, nodeToRmv.left);
		else	// nodeToRmv has both left and right child 
		{
			// Get smallest right side value as substitute for nodeToRmv
			// This keeps bst property since remaining left children are smaller
			// and remaining right children are bigger than nodeToSubs
			Node nodeToSubs = minimum(nodeToRmv.right);

			//3. nodeToSubs is not the found to the right of nodeToRmv
			// instead it is found on a lower level
			if (nodeToSubs.parent != nodeToRmv){
				//replace nodeToSubs with its right child (can be null)
				//right child is now connected to right node of nodeToRmv
				transplant(tree, nodeToSubs, nodeToSubs.right);
				// attach right node of nodeToRmv and its children underneath nodeToSubs
				nodeToSubs.right = nodeToRmv.right;
				// set nodeToSubs as parent of nodeToRmr.right
				nodeToSubs.right.parent = nodeToSubs;
			}
			
			// 4. nodeToSubs is the right child of nodeToRmv
			// replace nodeToRmv with nodeToSubs
			transplant(tree, nodeToRmv, nodeToSubs);
			// attach left children of nodeToRmv to nodeToSubs
			nodeToSubs.left = nodeToRmv.left;
			nodeToSubs.left.parent = nodeToSubs;
			
			// erase nodeToRmv from tree
			nodeToRmv.parent = null;
			nodeToRmv.left = null;
			nodeToRmv.right = null;
			nodeToRmv.key = -1;
		}
			
	}
	
	/**
	 * Return minimum node if it exists
	 * Iterative
	 * @return
	 */
	public Node minimum(Node node) {
		
		// Save node before leftmost
		while(node.left !=null) 
			node = node.left;
		
		return node;
	}
	
	/**
	 * Return maximum node if it exists
	 * Iterative
	 * @return
	 */
	public Node maximum(Node node) {

		// Save node before rightmost
		while (node.right != null)
			node = node.right;
		
		return node;
		
	}
	
	/**
	 * Check if key exists in BST, returns true if exists
	 * Recursive
	 * @param key
	 * @param node
	 * @return
	 */
	public Node search(int key, Node node){

		// either tree is empty or key was not found
		if (node==null)
			return null;
		if (key==node.key)
			return node; 
		
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
		tree.delete(tree, tree.search(15, root));
		tree.preOrder(root);
		//tree.postOrder(root);
		//tree.inOrder(root);
		
		System.out.println("Search: "+tree.search(15, root));
		System.out.println("Minimum is "+tree.minimum(root));
		System.out.println("Maximum is "+tree.maximum(root));
		
	}

}
