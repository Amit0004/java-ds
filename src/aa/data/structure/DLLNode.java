package aa.data.structure;

public class DLLNode {
	private int data;
	private DLLNode previous;
	private DLLNode next;
	
	public DLLNode(int data) {
		setData(data);
		previous = null;
		next = null;
	}
	public DLLNode(int data, DLLNode prev, DLLNode next) {
		setData(data);
		setPrevious(prev);
		setNext(next);
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setPrevious(DLLNode prev) {
		this.previous = prev;
	}
	
	public DLLNode getPrevious() {
		return this.previous;
	}
	
	public void setNext(DLLNode next) {
		this.next = next;
	}
	
	public DLLNode getNext() {
		return this.next;
	}
}
