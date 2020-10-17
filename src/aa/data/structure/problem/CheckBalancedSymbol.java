package aa.data.structure.problem;

import java.util.Scanner;
import java.util.Stack;

import aa.data.structure.LinkedListStack;

public class CheckBalancedSymbol {
	private LinkedListStack stack;
	private String input;
	private String result;
	Stack<Character> st = new Stack<Character>();
	public CheckBalancedSymbol(String input) {
		this.input = input;
	}
	
	public boolean stringProcessor() throws Exception {
		if(this.input.isEmpty()) {
			throw new Exception("Empty String");
		}
		for(char ch: input.toCharArray()) {
			if(ch == ']') {
				if(!st.isEmpty() && st.peek() == '[') {
					st.pop();
				} else {
					return false;
				}
			} else if(ch == '}') {
				if(!st.isEmpty() && st.peek() == '{') {
					st.pop();
				} else {
					return false;
				}
			} else if(ch == ')') {
				if(!st.isEmpty() && st.peek() == '(') {
					st.pop();
				} else {
					return false;
				}
			} else {
				st.push(ch);
			}
		}
		if(st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string");
		String input = sc.nextLine();
		CheckBalancedSymbol cbs = new CheckBalancedSymbol(input);
		System.out.println(cbs.stringProcessor());
	}
}
