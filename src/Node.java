
public class Node {
	
	private String data;
	private Node prv;
	private Node nxt;
	
	public Node(String s, Node previous, Node next) {
		data = s;
		prv = previous;
		nxt = next;
		
	}
	
	public Node next() {
		return nxt;
	}
	public Node previous() {
		return prv;
	}
	
	public Node addAfter(String s) {
		
		Node newNode = new Node(s, this, null);
		this.nxt = newNode;
		return newNode;
	}
	
	public void setData(String s) {
		data = s;
		return;
	}
	
	public void setPrv(Node prv) {
		this.prv = prv;
	}
	
	public void setNxt(Node nxt) {
		this.nxt = nxt;
	}
	
	public Node getPrv() {
		return prv;
	}
	public Node getNxt() {
		return nxt;
	}
	public String getData() {
		return data;
	}
}

