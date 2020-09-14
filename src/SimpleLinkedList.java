import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList {
	
	private int size;
	private Node start;
	private Node stop;

	public SimpleLinkedList() {
		start = new Node(null, null, null);
		stop = new Node(null, start, null);
		size = 0;
	}
	
	public SimpleLinkedList(List<String> list) {
		start = new Node(null, null, null);
		Node currentNode = start;
		for(int i = 0; i < list.size(); i++) {
			Node el = currentNode;
			currentNode = currentNode.addAfter(list.get(i));
			currentNode.setPrv(el);
			currentNode.setData(list.get(i));
		}
		currentNode.setNxt(stop);
		size = list.size();
	}
	
	public void add(int idx, String s) {
		checkIdx(idx);
		Node nextNode = getNode(idx);
		Node prevNode = nextNode.getPrv();
		Node newNode = new Node(s, prevNode, nextNode);
		prevNode.setNxt(newNode);
		nextNode.setPrv(newNode);
		size ++;
	}
	
	public void addFirst(String s) {
		add(0, s);
	}
	
	public void addLast(String s) {
		add(size, s);
	}
	
	public void clear() {
		for(int i = size-1; i >= 0; i--) {
			Node n = getNode(i);
			n = null;
		}
		start.setNxt(stop);
		stop.setPrv(start);
	}
	
	public boolean contains(String s) {
		return (indexOf(s) != -1);
	}
	
	public String get(int idx) {
		checkIdx(idx);
		Node n = getNode(idx);
		return n.getData();
	}
	
	public String getFirst() {
		return get(0);
	}
	
	public String getLast() {
		return get(size-1);
	}
	
	public int indexOf(String s) {
		Node currentNode = start;
		for(int i = 0; i < size; i++) {
			currentNode = currentNode.getNxt();
			if(currentNode.equals(s)) { return i; }
		}
		return -1;
	}
	
	public String remove(int idx) {
		checkIdx(idx);
		Node n = getNode(idx);
		Node prevNode = n.getPrv();
		Node nextNode = n.getNxt();
		String el = n.getData();
		n = null;
		prevNode.setNxt(nextNode);
		nextNode.setPrv(prevNode);
		return el;
	}
	
	public boolean remove(String s) {
		int idx = indexOf(s);
		if(idx != -1) {
			remove(idx);
			return true;
		}
		return false;
	}
	
	public String removeFirst() {
		checkList();
		return remove(0);
	}
	
	public String removeLast() {
		checkList();
		return remove(size-1);
	}
	
	public String set(int idx, String s) {
		checkIdx(idx);
		Node n = getNode(idx);
		String el = n.getData();
		n.setData(s);
		return el;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		
		Node currentNode = start;
		for(int i = 0; i < size-1; i++) {
			currentNode = currentNode.getNxt();
			str = str + currentNode.getData() + ", ";
		}
		if(size != 0) { str +=  currentNode.getNxt().getData(); }
		str += "]";
		return str;
	}
	
	private Node getNode(int idx) {
		Node currentNode = start.getNxt();
		for(int i = 0; i < idx; i++) {
			currentNode = currentNode.getNxt();
		}
		return currentNode;
	}
	
	private void checkIdx(int idx) {
		if(idx < 0 || idx > size) { 
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
		}
	}
	private void checkList() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
	}
	
		
		
	
} 