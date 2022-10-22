package application;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node head, tail;
	protected int size;	
	
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node nTail = new Node(data);
		
		if(size == 0) {
			head = nTail;
			tail = head;
		}
		else {
			tail.next = nTail;
			nTail.prev = tail;
			tail = nTail;
		}
		size++;
		return this;
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data){
		
		Node nHead = new Node(data);
		if(size == 0) {
			head = nHead;
			tail =head;
		}
		else {
			head.prev= nHead;
			nHead.next = head;
			head = nHead;
		}
		size++;
		return this;
	}
	
	public T getFirst() throws NoSuchElementException{
		if(size==0) {
			//throw new NoSuchElementException();
			return null;
		}
		return head.data;
	}
	public T getLast() throws NoSuchElementException{
		if(size==0) {
			//throw new NoSuchElementException();
			return null;
		}
		return tail.data;
	}
	
	public int getSize() {
		return size;
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new NodeIterator();
		
	}
	
	public class NodeIterator implements ListIterator<T>{
		protected Node curr =head;
		protected Node end;		
		
		@Override
		public boolean hasNext() {
			
			return curr != null;
		}

		@Override
		public T next() throws NoSuchElementException{
			if(hasNext()) {
				end = curr;
				curr = curr.next;
				return end.data;
			}
			throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			return end != null;
		}

		@Override
		public T previous() throws NoSuchElementException{
			if(hasPrevious()) {
				curr= end;
				end= end.prev;
				return curr.data;
			}
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}
	
	}
	public class Node{
			protected Node prev, next;
			protected T data;
			
			public Node(T data) {
				prev =null;
				next = null;
				this.data= data;
			}
		}
	public BasicDoubleLinkedList<T> remove(T setData, Comparator<T> comparator){
		Node currNode= head;
		while(currNode != null) {
			if(comparator.compare(setData, currNode.data)==0) {
				if(currNode==head) {
					head = head.next;
					
				}
				else if(currNode == tail) {
					tail= tail.prev;
					
				}
				else {
					currNode.prev.next = currNode.next;
				}
				size--;
				return this;
			}
			currNode = currNode.next;
			
		}
		return this;
	}
	
	public T retrieveFirstElement() {
		T firstElement = head.data;
		if(size ==0) {
			return null;
		}
		if(size==1) {
			head= null;
			tail= null;
			
		}
		else {
			head= head.next;
			head.prev =null;
		}
		size--;
		return firstElement;
	}
	
	public T retrieveLastElement() {
		T LastElement = tail.data;
		if(size ==0) {
			return null;
		}
		if(size == 1) {
			head = null;
			tail = null;
		}
		else {
			tail = tail.prev;
			tail.next= null;
		}
		size--;
		return LastElement;
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<>();
		Node currNode= head;
		
		while(currNode != null) {
			list.add(currNode.data);
			currNode = currNode.next;
			
		}
		return list;
	}
}
