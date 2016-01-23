package Ch8_Trees;

public class BinarySearchTree {
	protected class Node{
		private int key; 
		private Node left;
		private Node right;
		private String value;
		private boolean leaf;
		
		public Node(int key, Node left, Node right, String value){
			this.key = key;
			this.left = left;
			this.right = right;
			this.value = value;
			this.leaf = false;
		}
		
		public Node(boolean leaf){
			this.leaf = true;
			left = null;
			right = null;
		}
		
		public int getKey(){
			return key;
		}
		
		public boolean getLeaf(){
			return leaf;
		}
		
		public Node getLeft(){
			return left;
		}
		
		public Node getRight(){
			return right;
		}
		
		public String getValue(){
			return value;
		}
		
		public void setKey(int key){
			this.key = key;
		}
		
		public void setLeaf(boolean leaf){
			this.leaf = leaf;
		}
		
		public void setLeft(Node left){
			this.left = left;
		}
		
		public void setRight(Node right){
			this.right = right;
		}
		
		public void setValue(String value){
			this.value = value;
		}
	}
	
	private Node root;
	private int size;
	
	public Node getRoot(){
		return root;
	}
	
	public int getSize(){
		return size;
	}
	
	/** Factory methods **/
	public Node createNode(int key, Node left, Node right, String value){
		return new Node(key,left,right,value);
	}
	
	public Node createLeafNode(){
		boolean leaf = true;
		return new Node(leaf);
	}
	
	// Upgrade leaf into an internal node
	public void upgradeLeaf(Node parent, int key, String value){
		parent.setKey(key);
		parent.setValue(value);
		parent.setLeaf(false);
		parent.setLeft(createLeafNode());
		parent.setRight(createLeafNode());
	}
	
	public Node find(Node parent, int key){
		// Leaf is an empty external node
		if (parent.getLeaf())
			return parent; 	// Useful for insert method, this node will be an empty leaf node
		// Found value
		if (parent.getKey() == key)
			return parent;
		// go right if key @ current node is smaller
		if (parent.getKey()< key)
			find(parent.getRight(), key);
		// go left if key @ current node is bigger
		else 
			find(parent.getLeft(), key);
		return parent;

	}
	
	public void insert(int key, String value){
		// Initial empty tree
		if (root==null){
			Node leaf = createLeafNode();
			root = createNode(key, leaf, leaf, value);
			return;
		}
		
		// Iterate to either empty spot or matching node
		Node parent = find(getRoot(), key); 
		
		// Leaf node reached
		if (parent.getLeaf()){
			// upgrade leaf node into internal node
			upgradeLeaf(parent,key, value);
		}
		// Update value if there's a match
		else if (parent.getKey()==key)
			parent.setValue(value);

	}
	
	public void inOrder(Node parent){
		if (parent==null)
			return; 
		// Traverse left first
		inOrder(parent.getLeft());
		// Print left and root
		System.out.println(parent.getKey());
		inOrder(parent.getRight());

	}
	
	
	
	
	

}
