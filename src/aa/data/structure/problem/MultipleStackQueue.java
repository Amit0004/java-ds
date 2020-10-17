package aa.data.structure.problem;

import java.util.Stack;

public class MultipleStackQueue<T> {
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();
	
	public void enQueue(T data) {
		s1.push(data);
	}
	
	public T deQueue() {
		while(s2.empty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
		}
		return s2.pop();
	}
}
