package stack_problems;

import java.util.*;

public class Kartik_Sir_and_Coding {
	static Scanner s = new Scanner(System.in);
	public static void main(String args[]) throws Exception {
		// Your Code Here


		int q = s.nextInt();
		Kartik_Sir_and_Coding obj = new Kartik_Sir_and_Coding();
		StacksUsingArrays stack = obj.new StacksUsingArrays();
		Calculate(stack, q);
	}

	public static void Calculate(StacksUsingArrays stack, int q) throws Exception {
		//Write Your Code Here
		while(q>0)
		{
			int a = s.nextInt();
			int b=0;
			if(a!=1)
			{
				b = s.nextInt();
				stack.push(b);
			}
			else
			{
				if(stack.isEmpty())
				{
					System.out.println("No Code");
				}
				else
				{
					System.out.println(stack.pop());
				}
			}
			q--;
		}
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

				int[] temp = new int[2 * data.length];
				for(int i = 0;i < data.length;i++){
					temp[i] = data[i];
				}

				data = temp;
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

