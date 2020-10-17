package aa.data.structure;

public class FixedCircularArrayQueue {
	private int[] queueContainer;
	private int size, front, rear;
	public static final int CAPACITY = 16;
	
	public FixedCircularArrayQueue() {
		queueContainer = new int[CAPACITY];
		size = 0; front = 0; rear = 0;
	}
	
	public FixedCircularArrayQueue(int capacity) {
		queueContainer = new int[capacity];
		size = 0; front = 0; rear = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == CAPACITY);
	}
	
	public int front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue Empty");
		}
		return queueContainer[front];
	}
	
	public int rear() throws Exception {
		if(size() == CAPACITY) {
			throw new Exception("Queue Overflow");
		}
		return rear;
	}
	
	public void enQueue(int element) throws Exception {
		if(isFull()) {
			throw new Exception("Queue Overflow");
		}
		size++;
		queueContainer[rear] = element;
		rear = (rear + 1) % CAPACITY;
	}
	
	public void deQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue Empty");
		}
		size--;  
		queueContainer[front] = Integer.MIN_VALUE;
		front = (front + 1) % CAPACITY;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(isEmpty()) {
			return "[]";
		}
		sb.append("[");
		for(int i = 0; i < size; i++) {
			sb.append(queueContainer[(front + i) % CAPACITY]);
			if(i != size - 1) {
				sb.append("-");
			}
		}
		sb.append("]");
		return sb.toString();
		
	}
}
