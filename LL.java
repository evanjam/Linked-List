import java.util.*;

public class LL
{
	class Node
	{

		public Object value;
		public Node next;
	}

	private Node first;

	public LL()
	{
		first = null;
	}

	public void addFirst(Object element)
	{
		Node n = new Node();
		n.value = element;
		n.next = first;
		first = n;
	}

	public Object getFirst()
	{
		if (first == null)
			throw new NoSuchElementException();
		return first.value;
	}

	public Object removeFirst()
	{
		if (first == null)
			throw new NoSuchElementException();
		Object element = first.value;
		first = first.next;
		return element;
	}	

	public LinkedListIterator listIterator()
	{
		return new LinkedListIterator();
	}

	class LinkedListIterator
	{
		private Node current;
		private Node previous;
		private boolean isAfterNext;

		public LinkedListIterator()
		{
			current = null;
			previous = null;
			isAfterNext = false;
		}

		public boolean hasNext()
		{
			if (current == null)
				return first != null;
			else
				return current.next != null;
		}		

		public Object next()
		{
			if ( ! hasNext())
				throw new NoSuchElementException();
			previous = current;
			isAfterNext = true;
			if (current == null)
				current = first;
			else
				current = current.next;
			return current.value;
		}

		public void add(Object element)
		{

			if (current == null)
			{
				addFirst(element);
				current = first;
			}

			else
			{
				Node n = new Node();
				n.value = element;
				n.next = current.next;
				current.next = n;
				current = n;
			}

			previous = current;
			isAfterNext = false;
		}

		public void set(Object element)
		{
			if (!isAfterNext)
				throw new IllegalStateException();
			current.value = element;
		}

		public void remove()
		{
			if (!isAfterNext)
				throw new IllegalStateException();
			if (current == first)
				removeFirst();
			else
				previous.next = current.next;
			current = previous;
			isAfterNext = false;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.print("do something");
	}
}
