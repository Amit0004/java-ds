package aa.data.structure;

public class DynamicArrayStack {
	protected int capacity;
	protected int[] stackContainer;
	protected int top = -1;
	public static final int CAPACITY = 2;
	public static final int MIN_CAPACITY = 10;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}
	
	public DynamicArrayStack(int capacity) {
		this.capacity = capacity;
		stackContainer = new int[capacity];
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public int size() {
		return top + 1;
	}
	
	public void expand() {
		if(size() == capacity) {
			int length = top + 1;
			int[] newContainer = new int[capacity * 2];
			System.arraycopy(stackContainer, 0, newContainer, 0, length);
			stackContainer = newContainer;
			this.capacity = capacity * 2;
		} else {
			return;
		}
	}
	
	public void shrink() {
		if(size() < (capacity/2)) {
			int[] newContainer = new int[capacity/2];
			System.arraycopy(stackContainer, 0, newContainer, 0, top + 1);
			stackContainer = newContainer;
			this.capacity = capacity/2;
		} else {
			return;
		}
		
	}
	
	public void push(int element) {
		expand();
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
		stackContainer[top--] = Integer.MIN_VALUE;
		shrink();
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
