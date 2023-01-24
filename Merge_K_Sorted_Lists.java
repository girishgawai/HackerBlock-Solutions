package linkedlist.qps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Merge_K_Sorted_Lists {

	static class Node{
		int val;							// node ki value
		Node next;							// next node ka address

	}

	Node head;				// tells the first/starting point of linkedlist --> node address of head
	private Node tail;				// tells the last/ending point of linkedlist --> node address of head
	private int size;				// tells total number of nodes in LinkedList


	public static void merge(Merge_K_Sorted_Lists[] arr)
	{
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
		
		for(Merge_K_Sorted_Lists nn : arr)
		{
			if(nn.size!=0)			// agr list khali nhi hai toh hi add ho
				pq.add(nn.head);
		}
		
		Node ans = new Node();
		Node temp = ans;
		
		while(!pq.isEmpty())
		{
			// remove
			Node removed = pq.remove();
			
			// add removed data into ans list
			ans.next = removed;
			
			// ans ki list ko next pe shift krdo.. mtlb jo next data ayega woh yha pe aakr baithega
			ans = ans.next;
			
			// if removed list is not empty and still it is having elements then add that list again into PW for next elements
			if(removed.next!=null)
				pq.add(removed.next);
		}
		
		// agr return kredete temp.next toh nxt se data's present rhte.. lekin currently next wala data default 0 hai.. isliye aur nxt set kro
		temp = temp.next;
		while(temp!=null)
		{
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int pin = 0;
		int n = sc.nextInt();
		Merge_K_Sorted_Lists[] arr = new Merge_K_Sorted_Lists[k];

		while(pin<k)
		{
			Merge_K_Sorted_Lists list = new Merge_K_Sorted_Lists();
			for (int i = 0; i < n; i++) {
				list.addLast(sc.nextInt());
			}
//			list.display();
			
			arr[pin] = list;
			pin++;
		}
		
		merge(arr);
	}

	public void addFirst(int item)
	{
		Node nn = new Node();
		nn.val = item;
		if(size==0)
		{
			this.head = nn;
			this.tail = nn;
		}
		else
		{
			nn.next = head;
			head = nn;
		}
		this.size++;
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

	public void addLast(int item)
	{
		if(size==0)
			addFirst(item);
		else
		{
			Node nn = new Node();
			nn.val = item;
			tail.next = nn;
			tail = nn;
		}
	}
}
