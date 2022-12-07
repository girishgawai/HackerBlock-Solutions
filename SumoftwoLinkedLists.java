package linkedlist.qps;
import java.util.Scanner;

public class SumoftwoLinkedLists {

	public void sumOfTwoLL(LinkedList list1,LinkedList list2, int size1, int size2) {
		int carry=0; 
		LinkedList.Node head1=list1.head;
		LinkedList.Node head2=list2.head;
		LinkedList result = new LinkedList();

		if(size1>size2)
		{
			while(head2!=null)
			{
				result.addFirst((head1.data+head2.data+carry)%10);
				carry = (head1.data+head2.data+carry)/10;
				
				head1 = head1.next;
				head2 = head2.next;
			}
			
			while(head1!=null)
			{
				result.addFirst((head1.data+carry)%10);
				carry = (head1.data+carry)/10;
				
				head1 = head1.next;
			}
			
			if(carry!=0)
				result.addFirst(carry);
		}
		else
		{
			while(head1!=null)
			{
				result.addFirst((head1.data+head2.data+carry)%10);
				carry = (head1.data+head2.data+carry)/10;
				
				head1 = head1.next;
				head2 = head2.next;
			}
			
			while(head2!=null)
			{
				result.addFirst((head1.data+carry)%10);
				carry = (head2.data+carry)/10;
				
				head2 = head2.next;
			}
			
			if(carry!=0)
				result.addFirst(carry);
		}
		result.display();
	}

	static class LinkedList {
		// Complete the function below

		//  You dont need to read the code below.

		private class Node {
			int data;
			Node next;

			Node(int data, Node next) {
				this.data = data;
				this.next = next;
			}
		}

		private Node head;
		private Node tail;
		private int size;

		public LinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		public LinkedList(Node head, Node tail, int size) {
			this.head = head;
			this.tail = tail;
			this.size = size;
		}

		// O(1)
		public int size() {
			return this.size;
		}

		// O(1)
		public boolean isEmpty() {
			return this.size() == 0;
		}

		// O(1)
		public int getFirst() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty.");
			}

			return this.head.data;
		}

		// O(1)
		public int getLast() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty.");
			}

			return this.tail.data;
		}

		// O👎
		public int getAt(int idx) throws Exception {
			Node temp = this.getNodeAt(idx);
			return temp.data;
		}

		// O👎
		private Node getNodeAt(int idx) throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty");
			}

			if (idx < 0 || idx >= this.size()) {
				throw new Exception("Invalid arguments");
			}

			Node retVal = this.head;
			for (int i = 0; i < idx; i++) {
				retVal = retVal.next;
			}

			return retVal;
		}

		// O(1)
		public void addFirst(int data) {
			Node node = new Node(data, this.head);

			if (this.size() == 0) {
				this.head = node;
				this.tail = node;
			} else {
				this.head = node;
			}

			this.size++;
		}

		// O👎
		public void display() {
			Node node = this.head;

			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}

			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();

		int N2 = scn.nextInt();

		LinkedList list1 = new LinkedList();

		for (int i = 0; i < N1; i++) {
			list1.addFirst(scn.nextInt());
		}
		//list1.display();
		LinkedList list2 = new LinkedList();

		for (int i = 0; i < N2; i++) {
			list2.addFirst(scn.nextInt());
		}
		//list2.display();

		SumoftwoLinkedLists ll= new SumoftwoLinkedLists();
		ll.sumOfTwoLL(list1,list2,N1,N2);
	}
}
