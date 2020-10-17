package aa.data.structure.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
	public static Queue reverseQueue(Queue input) {
		Stack stack  =  new Stack();
		while(!input.isEmpty()) {
			stack.push(input.poll());
		}
		while(!stack.isEmpty()) {
			input.offer(stack.pop());
		}
		return input;
		
	}
	
	public static void main(String[] args) throws Exception {
		QueueReversal qr = new QueueReversal();
		Queue input = new LinkedList();
		input.offer(4);
		input.offer(3);
		input.offer(6);
		input.offer(8);
		System.out.println("Orginal: " + input.toString());
		System.out.println("Reverse: " + qr.reverseQueue(input).toString());
	}
}
