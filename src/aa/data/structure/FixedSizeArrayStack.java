package aa.data.structure;

public class FixedSizeArrayStack {
	protected int capacity;
	public static final int CAPACITY = 10;
	protected int top = -1;
	protected int[]  stackContainer;
	
	public FixedSizeArrayStack() {
		this(CAPACITY);
	}
	
	public FixedSizeArrayStack(int capacity) {
		this.capacity = capacity;
		stackContainer = new int[capacity];
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public void push(int element) throws Exception {
		if((top + 1) > this.capacity - 1) {
			throw new Exception("Stack Overflow");
		}
		stackContainer[++top] = element;
	}
	
	public int top() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Empty");
		}
		return stackContainer[top];
	}
	
	public void pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Empty");
		}
		stackContainer[top] = Integer.MIN_VALUE;
		top--;
	}
	public int size() {
		return top + 1;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(isEmpty()) {
			return "[]";
		} else {
			sb.append("[");
			for(int i = 0;i < size(); i++) {
				sb.append(stackContainer[i]);
				if(i != size() - 1) {
					sb.append("|");
				}
			}
			sb.append("]");
			
		}
		return sb.toString();
	}
} 
