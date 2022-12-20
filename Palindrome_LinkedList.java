package linkedlist.qps;

import java.util.Scanner;

public class Palindrome_LinkedList {
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

	public Palindrome_LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Palindrome_LinkedList(Node head, Node tail, int size) {
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

	// O(N)
	public int getAt(int idx) throws Exception {
		Node temp = this.getNodeAt(idx);
		return temp.data;
	}

	// O(N)
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

	// O(1)
	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int idx, int data) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.head.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n)
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

		//System.out.println("END");
	}
	public boolean isPalindrome() {
		Node slow = head;
		Node fast = head;
		Node preSlow = null;						// to note the exact location before mid
		
		while(fast!=null && fast.next!=null)
		{
			preSlow=slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node mid = slow;			//	 mid form where half list rev  --> curr
		
		// REverse after mid
		Node nn = new Node(0, null);
		Node prev = null;
		
		while(mid!=null)
		{
			Node ahead = mid.next;
			mid.next = prev;
			prev = mid;
			mid=ahead;
		}
		
		// REstore reverse part of list after mid to original list at from mid point
		if(preSlow!=null)
			preSlow.next = prev;			// prev is the head/start of reverse list --> jisko mid se phle ke next me dalna hai
														// reverse list ko mid ke jgah se replace krdena

//		// Print the complete list
//		Node start = head;				// start of list
//		while(start!=null)
//		{
//			System.out.print(start.data + "  ");
//			start=start.next;
//		}
		
		// Checking Palindrome or not
		Node start = head;				// start of list
		Node start_mid = prev;				// start of reversed list at mid
		while(start!=null && start!=prev)
		{
			if(start.data!=start_mid.data)
				return false;
			
			start=start.next;
			start_mid=start_mid.next;
		}
		
		return true;
	}
	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();


		Palindrome_LinkedList list = new Palindrome_LinkedList();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

		System.out.println(list.isPalindrome());
	}
}

