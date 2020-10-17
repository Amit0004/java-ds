package aa.data.structure;

public class DoublyLinkedList {
	private int length = 0;
	private DLLNode head;
	public DoublyLinkedList() {
		length = 0;
	}
	
	public void insertAtBegin(DLLNode node) {
		node.setNext(head);
		node.setPrevious(null);
		head = node;
		length++;
	}
	
	public void insertAtEnd(DLLNode node) {
		if(head == null) {
			insertAtBegin(node);
		} else {
			DLLNode temp = head;
			for(int i = 0; i < length-1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrevious(temp);
			length++;
		}
	}
	
	public void removeAtBegin() throws Exception {
		DLLNode temp = head;
		if(head == null) {
			throw new Exception("Doubly linked list empty");
		}
		head = temp.getNext();
		temp = null;
		length--;
	}
	
	public void removeAtEnd() throws Exception {
		if(head == null) {
			throw new Exception("Doubly linked list empty");
		} else {
			DLLNode temp = head;
			for(int i = 0; i < length-1; i++) {
				temp = temp.getNext();
			}
			temp.setPrevious(null);
			temp = null;
			length--;
		}
	}
	
	public void remove(int position) throws Exception {
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		if(position == 0) {
			removeAtBegin();
		} else if(position == length) {
			removeAtEnd();
		} else {
			DLLNode temp = head;
			for(int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			DLLNode node = temp.getPrevious();
			temp.setNext(temp.getNext().getNext());
			temp = null;
			length--;
		}
		
	}
	public int size() {
		return this.length;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(head == null) {
			return "[]";
		} else {
			DLLNode temp = head;
			for(int i = 0; i < length; i++) {
				sb.append(temp.getData());
				if(i != length-1) {					
					sb.append(" <-> ");
				}
				temp = temp.getNext();
			}
			sb.append("]");
		}
		return sb.toString();
	}
}
