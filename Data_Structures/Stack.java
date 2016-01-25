package Ch6_Stack_Queues;

import java.util.EmptyStackException;

public class Stack<E> {
	private class Node<E> {
		private Node<E> next;
		private E data;
		
		public Node(Node<E> next, E data){
			this.next = next;
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}
		
	}
	
	private Node<E> head;
	private int size;
	
	public void push(E data){
		head = new Node<E>(head, data);
		size++;
	}
	
	public E pop(){
		if (isEmpty())
			throw new EmptyStackException();
		E result = head.getData();
		head = head.getNext();
		size--;
		return result;
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public E top(){
		return head.getData();
	}
	
	
	public Node<E> getHead() {
		return head;
	}
	public void setHead(Node<E> head) {
		this.head = head;
	}
	public int getSize() {
		return size;
	} 
	
}
