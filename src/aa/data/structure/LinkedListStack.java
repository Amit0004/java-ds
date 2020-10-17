package aa.data.structure;

public class LinkedListStack {
	private int length;
	private Node top;
	
	public LinkedListStack() {
		this.length = 0;
		top = null;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public void push(int element) {
		if(isEmpty()) {
			top = new Node(element);
		} else {
			Node newElement = new Node(element);
			newElement.setNext(top);
			top = newElement;
		}
		length++;
	}
	
	public void pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Empty");
		}
		Node temp = top;
		top = top.getNext();
		temp = null;
		length--;
	}
	public int top() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Empty");
		}
		return top.getData();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(isEmpty()) {
			return "[]";
		} else {
			sb.append("[");
			Node temp = top;
			for(int i = 0 ; i < length; i++) {
				sb.append(temp.getData());
				if(i != length - 1) {
					sb.append("|");
				}
				temp = temp.getNext();
			}
			sb.append("]");
		}
		return sb.toString();
	}
}
