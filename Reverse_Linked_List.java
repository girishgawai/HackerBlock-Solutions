package linkedlist.qps;
import java.util.Scanner;


public class Reverse_Linked_List {

	private static class LinkedList {
		private class Node{
			int val;							// node ki value
			Node next;							// next node ka address
		}

		private Node head;				// tells the first/starting point of linkedlist --> node address of head
		private Node tail;				// tells the last/ending point of linkedlist --> node address of head
		private int size;				// tells total number of nodes in LinkedList

		//		O(1)
		public void addFirst(int item)
		{
			Node nn = new Node();
			nn.val = item;

			if(size==0)			// agr yeh phla hi node hai bnne ke liye linkedlist me toh hea v yhhi and tail v yhi
			{
				this.head = nn;			// this likha toh v chlega iss case me nh likha toh v chlega.. bcaz no conflit
				this.tail = nn;
				this.size++;
			}
			else
			{
				nn.next=head;
				head=nn;
				this.size++;
			}
		}

		//		O(1)
		public void addLast(int item)
		{
			if(size==0)
				addFirst(item);
			else
			{
				Node nn = new Node();
				nn.val=item;
				tail.next=nn;
				tail=nn;
				size++;
			}
		}


		//O(1)
		public int getFirst() throws Exception
		{
			if(size==0)
				throw new Exception("LinkedList is Empty");
			else
				return head.val;
		}

		//		O(1)
		public int getLast() throws Exception
		{
			if(size==0)
				throw new Exception("LinkedList is Empty");
			else
				return tail.val;
		}


		public Node getNode(int k) throws Exception				// iss index ke node ka ddrss btana hai
		{
			if(k<0 || k>=size)
				throw new Exception("Invalid Index");

			Node temp = head;
			for (int i = 1; i <= k; i++) {
				temp=temp.next;
			}

			return temp;
		}

		//		O(N)
		public int getAtIndex(int k) throws Exception			// iss index pe ke node ki val
		{
			return getNode(k).val;
		}

		//		O(1)
		public int removeFirst() throws Exception
		{
			if (size == 0) {
				throw new Exception("LinkedList is Empty");
			}

			Node temp = head;
			head = head.next;
			if(size==1)
			{
				tail=null;
			}
			size--;

			temp.next=null;
			return temp.val;
		}

		public int removeLast() throws Exception
		{
			if(size==0)
			{
				return 1;
			}
			if(size==1)
			{
				return removeFirst();
			}
			else
			{
				Node lastBut_1 = getNode(size-2);			// last se phle wale node ka addrss dega
				Node temp = tail;
				tail=lastBut_1;
				tail.next=null;
				size--;
				return temp.val;
			}
		}

		//		O(N)
		public int removeAtIndex(int k) throws Exception
		{
			if(k<0 || k>=size)
				throw new Exception("LinkedList is Empty");
			if(k==0)
			{
				return removeFirst();
			}
			if(k==size-1)
			{
				return removeLast();
			}
			else
			{
				Node nn = getNode(k);			// removal node
				Node prev = getNode(k-1);		// removal se phle wala node
				prev.next=nn.next;
				size--;
				nn.next=null;
				return nn.val;
			}
		}

		//		O(N)
		public void addAtIndex(int k, int item) throws Exception
		{
			if(k==0)
				addFirst(item);
			if(k==size-1)
				addLast(item);
			else
			{
				Node add = new Node();
				add.val=item;

				Node oldNode = getNode(k-1);
				add.next=oldNode.next;

				oldNode.next=add;
				size++;
			}
		}

		public void display()
		{
			Node temp = head;
			while(temp!=null)
			{
				System.out.print(temp.val + " ");
//				System.out.print(temp.val + " --> ");
				temp=temp.next;
			}
//			System.out.println(".");
		}


		public LinkedList reverse()
		{
			LinkedList ll = new LinkedList();
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				addLast(sc.nextInt());
			}
			
//			display();
			head = reverse(head);				// return prev into head
			return ll;
		}

		private Node reverse(Node head) {
			// TODO Auto-generated method stub
//			System.out.println(head.next.val);
			
			Node curr = head;
			Node prev = null;
			
			while(curr!=null)
			{
				Node ahead = curr.next;
				curr.next = prev;
				prev = curr;
				curr = ahead;
			}
			
			return prev;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.reverse();
		ll.display();
	}
}
