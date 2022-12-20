package linkedlist.qps;

import java.util.Scanner;

public class MergeSortedLinkedLists {

	public static class LinkedList {
		private class Node{
			int val;							// node ki value
			Node next;							// next node ka address

		}

		private Node head;				// tells the first/starting point of linkedlist --> node address of head
		private Node tail;				// tells the last/ending point of linkedlist --> node address of head
		private int size;				// tells total number of nodes in LinkedList


		public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while(t>0)
			{
				LinkedList list1 = new LinkedList();
				int n1 = sc.nextInt();
				for (int i = 0; i < n1; i++) {
					list1.addLast(sc.nextInt());
				}
				//				list1.display();
				Node node1 = list1.head;

				LinkedList list2 = new LinkedList();
				int n2 = sc.nextInt();
				for (int i = 0; i < n2; i++) {
					list2.addLast(sc.nextInt());
				}
				//				list2.display();
				Node node2 = list2.head;

				merge(node1, node2);

				t--;
			}

		}





		private static void merge(Node node1, Node node2) throws Exception {
			// TODO Auto-generated method stub
			Node NL1 = node1;
			Node NL2 = node2;

			LinkedList merged = new LinkedList();
			merged.addLast(0);							// aise hi ek num add krdo wrna list me null rhega and list.next pe error dega
			Node ans = merged.head;
			Node returnAns = merged.head;				// head ko yaad kro.. return krte time head ke next se return krna

			while(NL1!=null && NL2!=null)
			{
				if(NL1.val>NL2.val)
				{
					ans.next = NL2;
					ans = ans.next;
					NL2 = NL2.next;
				}
				else
				{
					ans.next = NL1;
					ans = ans.next;
					NL1 = NL1.next;
				}
			}
			
			if(NL1!=null)
			{
				ans.next = NL1;
			}

			if(NL2!=null)
			{
				ans.next = NL2;
			}

			//			merged.display();
			//			System.out.println(returnAns.next.val);
			
			merged.removeFirst();	// jo no add kia tha list me starting me upr null error na aane k liye usko remove krdo.. bcha hua ans hai saara
			merged.display();
			
		}





		private LinkedList merge(LinkedList list1, LinkedList list2) {
			// TODO Auto-generated method stub
			Node n1 = new Node();
			System.out.println(head.val);


			return list1;
		}



		//	O(1)
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

		//	O(1)
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

		//	O(1)
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

		//	O(N)
		public int getAtIndex(int k) throws Exception			// iss index pe ke node ki val
		{
			return getNode(k).val;
		}

		//	O(1)
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

		//	O(N)
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

		//	O(N)
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
				temp=temp.next;
			}
			System.out.println();
		}

	}

}


/*********************************************************************************************************************************/
								// Hacker Blocks Runnable Code

////package linkedlist.qps;
//
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) throws Exception{
//		LinkedList ll = new LinkedList();
//		ll.merging();
//	}
//
//	public static class LinkedList {
//		private class Node{
//			int val;							// node ki value
//			Node next;							// next node ka address
//
//		}
//
//		private Node head;				// tells the first/starting point of linkedlist --> node address of head
//		private Node tail;				// tells the last/ending point of linkedlist --> node address of head
//		private int size;				// tells total number of nodes in LinkedList
//
//
//		public void merging() throws Exception {
//			Scanner sc = new Scanner(System.in);
//			int t = sc.nextInt();
//
//			while(t>0)
//			{
//				LinkedList list1 = new LinkedList();
//				int n1 = sc.nextInt();
//				for (int i = 0; i < n1; i++) {
//					list1.addLast(sc.nextInt());
//				}
//				//				list1.display();
//				Node node1 = list1.head;
//
//				LinkedList list2 = new LinkedList();
//				int n2 = sc.nextInt();
//				for (int i = 0; i < n2; i++) {
//					list2.addLast(sc.nextInt());
//				}
//				//				list2.display();
//				Node node2 = list2.head;
//
//				merge(node1, node2);
//
//				t--;
//			}
//
//		}
//
//
//
//
//
//		private static void merge(Node node1, Node node2) throws Exception {
//			// TODO Auto-generated method stub
//			Node NL1 = node1;
//			Node NL2 = node2;
//
//			LinkedList merged = new LinkedList();
//			merged.addLast(0);							// aise hi ek num add krdo wrna list me null rhega and list.next pe error dega
//			Node ans = merged.head;
//			Node returnAns = merged.head;				// head ko yaad kro.. return krte time head ke next se return krna
//
//			while(NL1!=null && NL2!=null)
//			{
//				if(NL1.val>NL2.val)
//				{
//					ans.next = NL2;
//					ans = ans.next;
//					NL2 = NL2.next;
//				}
//				else
//				{
//					ans.next = NL1;
//					ans = ans.next;
//					NL1 = NL1.next;
//				}
//			}
//			
//			if(NL1!=null)
//			{
//				ans.next = NL1;
//			}
//
//			if(NL2!=null)
//			{
//				ans.next = NL2;
//			}
//
//			//			merged.display();
//			//			System.out.println(returnAns.next.val);
//			
//			merged.removeFirst();	// jo no add kia tha list me starting me upr null error na aane k liye usko remove krdo.. bcha hua ans hai saara
//			merged.display();
//			
//		}
//
//
//
//
//
//		private LinkedList merge(LinkedList list1, LinkedList list2) {
//			// TODO Auto-generated method stub
//			Node n1 = new Node();
//			System.out.println(head.val);
//
//
//			return list1;
//		}
//
//
//
//		//	O(1)
//		public void addFirst(int item)
//		{
//			Node nn = new Node();
//			nn.val = item;
//
//			if(size==0)			// agr yeh phla hi node hai bnne ke liye linkedlist me toh hea v yhhi and tail v yhi
//			{
//				this.head = nn;			// this likha toh v chlega iss case me nh likha toh v chlega.. bcaz no conflit
//				this.tail = nn;
//				this.size++;
//			}
//			else
//			{
//				nn.next=head;
//				head=nn;
//				this.size++;
//			}
//		}
//
//		//	O(1)
//		public void addLast(int item)
//		{
//			if(size==0)
//				addFirst(item);
//			else
//			{
//				Node nn = new Node();
//				nn.val=item;
//				tail.next=nn;
//				tail=nn;
//				size++;
//			}
//		}
//
//
//		//O(1)
//		public int getFirst() throws Exception
//		{
//			if(size==0)
//				throw new Exception("LinkedList is Empty");
//			else
//				return head.val;
//		}
//
//		//	O(1)
//		public int getLast() throws Exception
//		{
//			if(size==0)
//				throw new Exception("LinkedList is Empty");
//			else
//				return tail.val;
//		}
//
//
//		public Node getNode(int k) throws Exception				// iss index ke node ka ddrss btana hai
//		{
//			if(k<0 || k>=size)
//				throw new Exception("Invalid Index");
//
//			Node temp = head;
//			for (int i = 1; i <= k; i++) {
//				temp=temp.next;
//			}
//
//			return temp;
//		}
//
//		//	O(N)
//		public int getAtIndex(int k) throws Exception			// iss index pe ke node ki val
//		{
//			return getNode(k).val;
//		}
//
//		//	O(1)
//		public int removeFirst() throws Exception
//		{
//			if (size == 0) {
//				throw new Exception("LinkedList is Empty");
//			}
//
//			Node temp = head;
//			head = head.next;
//			if(size==1)
//			{
//				tail=null;
//			}
//			size--;
//
//			temp.next=null;
//			return temp.val;
//		}
//
//		public int removeLast() throws Exception
//		{
//			if(size==0)
//			{
//				return 1;
//			}
//			if(size==1)
//			{
//				return removeFirst();
//			}
//			else
//			{
//				Node lastBut_1 = getNode(size-2);			// last se phle wale node ka addrss dega
//				Node temp = tail;
//				tail=lastBut_1;
//				tail.next=null;
//				size--;
//				return temp.val;
//			}
//		}
//
//		//	O(N)
//		public int removeAtIndex(int k) throws Exception
//		{
//			if(k<0 || k>=size)
//				throw new Exception("LinkedList is Empty");
//			if(k==0)
//			{
//				return removeFirst();
//			}
//			if(k==size-1)
//			{
//				return removeLast();
//			}
//			else
//			{
//				Node nn = getNode(k);			// removal node
//				Node prev = getNode(k-1);		// removal se phle wala node
//				prev.next=nn.next;
//				size--;
//				nn.next=null;
//				return nn.val;
//			}
//		}
//
//		//	O(N)
//		public void addAtIndex(int k, int item) throws Exception
//		{
//			if(k==0)
//				addFirst(item);
//			if(k==size-1)
//				addLast(item);
//			else
//			{
//				Node add = new Node();
//				add.val=item;
//
//				Node oldNode = getNode(k-1);
//				add.next=oldNode.next;
//
//				oldNode.next=add;
//				size++;
//			}
//		}
//
//		public void display()
//		{
//			Node temp = head;
//			while(temp!=null)
//			{
//				System.out.print(temp.val + " ");
//				temp=temp.next;
//			}
//			System.out.println();
//		}
//
//	}
//
//
//}
