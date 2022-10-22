package application;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T>  {

	private Comparator<T> comparator;
	
	public SortedDoubleLinkedList (Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	public SortedDoubleLinkedList<T> add(T data){
		Node nNode = new Node(data);
		Node currNode = head;
		
		if(size==0) {
			head= nNode;
			tail = head;
			size++;
			return this;
		}
		
		
		else if(comparator.compare(head.data, data)>0) {
			nNode.next = head;
			head.prev = nNode;
			head = nNode;
			size++;
			return this;
		}
		else {
			while(comparator.compare(currNode.data, data) < 0) {
				if(currNode.next == null) {
					currNode.next = nNode;
					nNode.prev = currNode;
					tail = nNode;
					size++;
					return this;
				}
				else {
					currNode = currNode.next;
				}
			}
			
			currNode.prev.next = nNode;
			nNode.prev = currNode.prev;
		    currNode.prev = nNode;
		    nNode.next = currNode;
		    size++;
		    return this;
		}
	}
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public SortedDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException { 
		throw new UnsupportedOperationException(); 
    	
    }
	
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
}
