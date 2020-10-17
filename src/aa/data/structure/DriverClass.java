package aa.data.structure;

public class DriverClass {

	public static void main(String[] args) throws Exception {
//		LinkedList list = new LinkedList();
//		list.insertAtBegin(new Node(2));
//		list.insertAtBegin(new Node(3));
//		list.insertAtBegin(new Node(4));
//		list.insert(new Node(9), 3);
//		list.remove(3);
//		list.remove(2);
//		System.out.println(list.toString());
//		System.out.println("Length: " + list.size());
		
//		DoublyLinkedList dll = new DoublyLinkedList();
//		dll.insertAtBegin(new DLLNode(1));
//		dll.insertAtBegin(new DLLNode(2));
//		dll.insertAtBegin(new DLLNode(3));
//		dll.insertAtBegin(new DLLNode(4));
//		dll.insertAtEnd(new DLLNode(3));
//		dll.insertAtEnd(new DLLNode(4));
//		dll.removeAtBegin();
//		dll.removeAtEnd();
//		dll.remove(1);
//		System.out.println(dll.toString());
//		System.out.println("Length: " + dll.size());
		
//		FixedSizeArrayStack stack = new FixedSizeArrayStack(4);
//		stack.push(1);
//		stack.pop();
//		stack.push(2);
//		stack.pop();
//		stack.push(4);
//		stack.pop();
//		stack.push(5);
//		System.out.println(stack.toString());
//		System.out.println("Top: " + stack.top());
//		System.out.println("Size: " + stack.size());
		
//		DynamicArrayStack stack = new DynamicArrayStack();
//		stack.push(1);
//		stack.pop();
//		stack.push(2);
//		stack.pop();
//		stack.push(4);
//		stack.pop();
//		stack.push(5);
//		System.out.println(stack.toString());
//		System.out.println("Top: " + stack.top());
//		System.out.println("Size: " + stack.size());
		
//		LinkedListStack stack = new LinkedListStack();
//		stack.push(1);
//		stack.pop();
//		stack.push(2);
//		stack.pop();
//		stack.push(4);
//		stack.pop();
//		stack.push(5);
//		stack.pop();
//		System.out.println(stack.toString());
//		System.out.println("Top: " + stack.top());
//		System.out.println("Size: " + stack.size());
		
		FixedCircularArrayQueue queue = new FixedCircularArrayQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue.toString());
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.front());
		System.out.println("Rear: " + queue.rear());
	}

}
