package DataStructure;
/*
 * Imtiaz Adar
 * Linked List [Doubly]
 */
public class Doubly_Linked_List {
	Node head;
	
	class Node{
		Node next;
		Node prev;
		int data;
		Node(int data){
			this.data = data;
			this.next = this.prev = null;
		}
	}
	
	void insert_head(int data) {
		Node newNode = new Node(data);
		newNode.next = this.head;
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
	}
	
	void insert_tail(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			Node currNode = this.head;
			while(currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
			newNode.prev = currNode;
		}
	}
	
	void insert_after(int data, int given) {
		if(this.head == null) {
			System.out.println("This Is an Empty Linked List");
		}
		else {
			Node node = this.head;
			while(node != null) {
				if(node.data == given)
					break;
				node = node.next;
			}
			if(node == null) {
				System.out.println("Node Not Found");
			}
			else {
				Node newnode = new Node(data);
				newnode.next = node.next;
				newnode.prev = node;
				if(node.next != null) {
					node.next.prev = newnode;
				}
				node.next = newnode;
			}
		}
	}
	
	void insert_begin(int data, int given) {
		if(this.head == null) {
			System.out.println("This Is an Empty Linked List");
		}
		else {
			Node node = this.head;
			while(node != null) {
				if(node.data == given)
					break;
				node = node.next;
			}
			if(node == null) {
				System.out.println("Node Not Found");
			}
			else {
				Node newnode = new Node(data);
				newnode.next = node;
				newnode.prev = node.prev;
				if(node.prev != null) {
					node.prev.next = newnode;
				}
				else {
					this.head = newnode;
					node.prev = newnode;
				}
			}
		}
	}
	
	void delete_head() {
		if(this.head == null) {
			System.out.println("Linked List Is Empty");
			return;
		}
		if(this.head.next == null) {
			this.head = null;
		}
		else {
			this.head = this.head.next;
			this.head.prev = null;
		}
	}
	
	void delete_tail() {
		if(this.head == null) {
			System.out.println("Linked List Is Empty");
			return;
		}
		if(this.head.next == null) {
			this.head = null;
		}
		else {
			Node node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.prev.next = null;
		}
	}
	
	void delete_by_value(int value) {
		if(this.head == null) {
			System.out.println("Linked List Is Empty");
			return;
		}
		if(this.head.next == null) {
			if(value == this.head.data) {
				this.head = null;
			}
			else {
				System.out.println("Element Not Present In The Linked List");
			}
			return;
		}
		if(this.head.data == value) {
			this.head = this.head.next;
			this.head.prev = null;
			return;
		}
		Node node = this.head;
		while(node.next != null) {
			if(node.data == value)
				break;
			node = node.next;
		}
		if(node.next != null) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		else {
			if(node.data == value) {
				node.next.prev = null;
			}
			else {
				System.out.println("Not Present");
			}
		}
	}
	
	void display_Linked_List() {
		Node temp = this.head;
		System.out.println("Displaying Linked List");
		while(temp != null) {
			System.out.print(temp.data + "-> ");
			temp = temp.next;
		}
		System.out.print("NULL" + "\n");
	}
	
	public static void main(String[] args) {
		Doubly_Linked_List doublelist = new Doubly_Linked_List();
		doublelist.insert_head(12);
		doublelist.insert_tail(121);
		doublelist.insert_tail(24);
		doublelist.insert_tail(44);
		doublelist.insert_tail(33);
		doublelist.insert_begin(55, 33);
		doublelist.insert_tail(17);
		doublelist.insert_after(444, 24);
		doublelist.display_Linked_List();
		doublelist.delete_head();
		doublelist.delete_tail();
		doublelist.delete_by_value(444);
		doublelist.display_Linked_List();
		
	}
}
