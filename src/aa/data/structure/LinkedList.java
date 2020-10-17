package aa.data.structure;
public class LinkedList {
	Node head;
	private int length = 0;
	public LinkedList() {
		length = 0;
	}
	
	public synchronized void insertAtBegin(Node data) {
		data.setNext(head);
		head = data;
		length++;
	}
	public synchronized int size() {
		return this.length;
	}
	
	public synchronized void insertAtEnd(Node data) {
		if(head ==  null) {
			head = data;
		} else {
			Node p = head;
			Node q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(data);
		}
		length++;
	}
	
	public void insert(Node data, int position) {
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		if(position == 0) {
			insertAtBegin(data);
		} else if (position == length) {
			insertAtEnd(data);
		} else {
			Node temp = head;
			for(int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			data.setNext(temp.getNext());
			temp.setNext(data);
			length++;
		}
	}
	
	public void removeFromBegin() throws Exception {
		Node node = head;
		if(node != null) {
			head = node.getNext();
			node.setNext(null);
		} else {
			throw new Exception("Linked List Empty");
		}
		length--;
	}
	
	public void removeFromEnd() throws Exception {
		Node temp = head;
		if(temp == null) {
			throw new Exception("Linked List Empty");
		}
		for(int i = 0; i < length - 2; i++) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		length--;
		
	}
	
	public void remove(int position) throws Exception{
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		if(position == 0) {
			removeFromBegin();
		} else if(position == length) {
			removeFromEnd();
		} else {
			Node temp = head;
			for(int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			temp = null;
			length--;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(head == null) {
			return "[]";
		} else {
			Node temp = head;
			while(temp != null) {
				sb.append(temp.getData());
				if(temp.getNext() != null) {					
					sb.append("->");
				}
				temp = temp.getNext();
			}
			sb.append("]");
		}
		return sb.toString();
	}
}