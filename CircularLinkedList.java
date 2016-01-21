package Ch3_Fundamental_Data_structures;


public class CircularLinkedList<E> {
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
	private Node<E> tail = null;	//store head but not tail
	private int size = 0;
	
	public CircularLinkedList(){
		tail=null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public E first(){
		if (isEmpty())
			return null;
		return tail.getNext().getElement();		// head is the value after tail
	}
	
	public E last(){
		if (isEmpty())
			return null;
		return tail.getElement();
	}
	
	public void rotate(){	// rotate head to back of the list
		if (tail!=null)
			tail = tail.getNext();	// head becomes tail
	}
	
	public void addFirst(E element){
		if (isEmpty()){
			tail = new Node<>(element, null);
			tail.setNext(tail);		// link to itself circularly
		}
		else {
			Node<E> newest = new Node<>(element, tail.next);
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E element){
		addFirst(element);	// Add new element to front of list
		tail = tail.getNext();	// Set the element as the tail
	}
	
	public E removeFirst(){
		if (isEmpty())
			return null;
		Node<E> head = tail.getNext();
		if (head==tail)		// only one node
			tail=null;
		else
			tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
	
	public String toString(){
		Node<E> runner = tail.next;		// Set runner to head
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (count < size){
			sb.append(runner.getElement());
			sb.append(" ");
			runner = runner.getNext();
			count++;
		}
		return sb.toString();
	}
	

}
