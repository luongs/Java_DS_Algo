package Ch3_Fundamental_Data_structures;

public class SinglyLinkedList<E> {
	// Nested Node
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		
		public E getElement(){
			return element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> n){
			next = n;
		}
	}
	
	private Node<E> head = null;	// Bare minimum for linked list
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList(){
		head=null;
		tail=null;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public E first(){
		return head.getElement();
	}
	
	public E last(){
		return tail.getElement();
	}
	
	public void addToFirst(E node){
		// Set new element at head
		head = new Node<>(node, head);
		if (isEmpty())
			tail = head;	// special case 
		size++; 
	}
	
	public void addToTail(E node){
		Node<E> newest = new Node<>(node,null);
		
		if (isEmpty())
			head = newest;	// special case - list was previously empty
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst(){
		if (isEmpty())
			return null;
		E temp = head.getElement();
		head = head.next;
		size--;
		
		if (size==0)
			tail = null;	//special case - list is now empty
		
		return temp;
	}
	
	public String toString(){
		Node<E> runner = head;
		StringBuilder sb = new StringBuilder();
		while (runner != null){
			sb.append(runner.getElement());
			sb.append(" ");
			runner = runner.getNext();
		}
		return sb.toString();
	}

}
