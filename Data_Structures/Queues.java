package Ch6_Stack_Queues;

import java.util.NoSuchElementException;

public class Queues<E> {
	
	private class Node<E> {
		private Node<E> next;
		private E data;
		
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
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
	private Node<E> tail;
	private int size;
	
	public void enqueue(E data){
		Node<E> newValue = new Node<E>(data, null);
		if (isEmpty())
			head = newValue;
		else
			tail.setNext(newValue);
		tail = newValue;
		size++;
	}
	
	public E dequeue(){
		
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		
		E result = head.getData();
		head = head.getNext();
		size--;
		return result;

	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public E first(){
		return head.getData();
	}
	
	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getTail() {
		return tail;
	}
	
	public int getSize() {
		return size;
	}

}
