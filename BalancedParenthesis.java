package stack_problems;

import java.util.Scanner;

public class BalancedParenthesis {
	
	public static void main(String[] args) throws Exception {
		BalancedParenthesis(args);
	}
	
	public static void BalancedParenthesis(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		BalancedParenthesis mainobj = new BalancedParenthesis();
		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
		if (isBalanced(str, stack)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean isBalanced(String str, StacksUsingArrays st) throws Exception {
		String sqb = "[]";
		String rb = "()";
		String cb = "{}";
		
		for (int i = 0; i < str.length(); i++) {
			if('('==str.charAt(i) || '['==str.charAt(i) || '{'==str.charAt(i))
			{
				st.push(str.charAt(i));
			}
			else
			{
				if(st.isEmpty())
					return false;
				char ch = str.charAt(i);
				Character pop = (char) st.pop();
				boolean status = (sqb.contains(ch+"") && sqb.contains(pop+"")) || (rb.contains(ch+"") && rb.contains(pop+"")) || (cb.contains(ch+"") && cb.contains(pop+""));
				if(status==false)
				{
					return false;
				}
			}
		}
		if(str.length()%2!=0)
			return false;
		
		if(!st.isEmpty())
			return false;
		
		return true;
		
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(int item) throws Exception {
			if (this.size() == this.data.length) {
				throw new Exception("Stack is Full");
			}
			this.tos++;
			this.data[this.tos] = item;
		}

		public int pop() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			this.data[this.tos] = 0;
			this.tos--;
			return retVal;
		}

		public int top() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			return retVal;
		}

		public void display() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			for (int i = this.tos; i >= 0; i--) {
				System.out.println(this.data[i]);
			}

		}

	}
}
