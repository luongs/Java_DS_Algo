package Ch8_Trees;

public class LinkedBinaryTree<E> {
	
	private static class Node<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		// accessor methods
		public E getElement(){
			return element;
		}
		
		public Node<E> getParent(){
			return parent;
		}
		
		public Node<E> getLeft(){
			return left;
		}
		
		public Node<E> getRight(){
			return right;
		}
		
		// update methods
		public void setElement(E e){
			element = e;
		}
		
		public void setParent(Node<E> parentNode){
			parent = parentNode;
		}
		
		public void setLeft(Node<E> leftNode){
			left = leftNode;
		}
		
		public void setRight(Node<E> rightNode){
			right = rightNode;
		}

		// end of nested node class
	}
	
	/** Factory function to create a new node storing element e */
	protected Node<E> createNode(E el, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(el, parent,left,right);
	}
	
	// Instance variables
	protected Node<E> root = null;
	private int size=0;
	
	// Constructor
	public LinkedBinaryTree() {}
	
	// accessor methods 
	public int size(){
		return size;
	}
	
	public Node<E> root(){
		return root;
	}
	
	public Node<E> parent(Node<E> node) {
		return node.getParent();
	}
	
	public Node<E> left(Node<E> node) {
		return node.getLeft();
	}
	
	public Node<E> right(Node<E> node) {
		return node.getRight();
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	/* Add root if tree is empty */
	public Node<E> addRoot(E e) throws IllegalStateException{
		if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size++;
		return root;
	}
	
	public Node<E> addLeft(Node<E> parent, E e) throws IllegalStateException {
		if (parent.getLeft() != null)
			throw new IllegalStateException("parent already has a left child");
		Node<E> child = createNode(e,parent,null,null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	public Node<E> addRight(Node<E> parent, E e) throws IllegalStateException {
		if (parent.getRight() != null)
			throw new IllegalStateException("parent already has a right child");
		Node<E> child = createNode(e,parent,null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	// Replace element currently at node and return old element
	public E set(Node<E> parent, E e) {
		// Save current element to be returned
		E temp = parent.getElement();
		// Set new element at current location
		parent.setElement(e);
		return temp;
	}
	
	// Return amount of children 
	public int numChildren(Node<E> parent){
		int count = 0;
		if (parent.getLeft()!=null)
			count++;
		if (parent.getRight()!=null)
			count++;
		return count;
	}
	
	// Remove function implementation left for BST
	
	public E remove(Node<E> parent) throws IllegalArgumentException {
		// Can't remove a node with 2 children 
		if (numChildren(parent)==2)
			throw new IllegalArgumentException("p has two children");
		// Get child node 
		Node<E> child;
		if (parent.getLeft()!=null)
			child = parent.getLeft();
		else
			child = parent.getRight();

		// connect child to grandparent or null if it was the only node
		if (child!=null)
			child.setParent(parent.getParent());
		// child becomes root if parent was root
		if (parent == root)
			root = child;
		else {
			Node<E> grandParent = parent.getParent();
			// connect grandparent to child
			if (parent == grandParent.getLeft())
				grandParent.setLeft(child);
			else 
				grandParent.setRight(child);
		}
		size--;
		E temp = parent.getElement();
		// Remove parent
		parent.setElement(null);
		parent.setLeft(null);
		parent.setRight(null);
		parent.setParent(parent);
		return temp;
		}
}
	

