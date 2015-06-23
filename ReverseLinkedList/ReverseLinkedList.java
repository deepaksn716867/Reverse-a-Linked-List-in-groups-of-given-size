package algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedList<T> {
	private node first = null;
	private node last = null;
	LinkedList<T> reverseList = new LinkedList<T>();
	private static boolean firstalreadySet = false;   
	class node
	{
		T data;
		node next;
		node(T value)
		{
			data = value;
		}
	}
	public node getFirst()
	{
		return first;
	}
	public void insert(T data)
	{
		if(first == null)
		{
			node firstnode = new node(data);
			firstnode.next = null;
			first = firstnode;
			last = firstnode;
			return;
		}
		node newnode = new node(data);
		newnode.next = null;
		last.next = newnode;
		last = newnode;
	}
	
	public node reverseList(node head,int count)
	{
		node prev = null;
		node next = null;
		node current = null;
		current = head;
		int k =0;
		while(k++ <count && current != null)
		{
			System.out.println(current.data);
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if(firstalreadySet == false)
		{
			firstalreadySet = true;
			first = prev;
		}
		
		if(next != null)
		{
			head.next =  reverseList(current,count);
		}
		
		return prev;
	}
	public void displayList()
	{
		node current = first;
		while(current != null)
		{
			current = current.next;
		}
	}
	
	public static void main(String args[])
	{
		ReverseLinkedList<Integer> reverse = new ReverseLinkedList<Integer>(); 
		reverse.insert(1);
		reverse.insert(2);
		reverse.insert(3);
		reverse.insert(4);
		reverse.insert(5);
		reverse.insert(6);
		reverse.insert(7);
		reverse.insert(8);
		reverse.reverseList(reverse.getFirst(),2); //The count to reverse the linked list of the given size.
		reverse.displayList();
		
	}

}
