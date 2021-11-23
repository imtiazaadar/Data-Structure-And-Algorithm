package DataStructure;
/*
 * Imtiaz Adar
 * Linked List [Singly]
 */
public class Singly_Linked_List {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public void insert_head(int data) {
		Node newnode = new Node(data);
		if(this.head == null) {
			this.head = newnode;
			return;
		}
		newnode.next = this.head;
		this.head = newnode;
	}
	public void insert_tail(int data) {
		Node newnode = new Node(data);
		if(this.head == null) {
			this.head = newnode;
			return;
		}
		Node currentNode = this.head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newnode;
	}
	public void delete_head() {
		if(this.head == null) {
			System.out.println("This Linked List Is Empty");
			return;
		}
		this.head = this.head.next;
	}
	public void delete_tail() {
		if(this.head == null) {
			System.out.println("This Linked List Is Empty");
			return;
		}
		if(this.head.next == null) {
			this.head = null;
			return;
		}
		Node secondLast = this.head;
		Node last = this.head.next;
		while(last.next != null) {
			last = last.next;
			secondLast = secondLast.next;
		}
		secondLast.next = null;
	}
	public void displayLinkedList() {
		Node temp = this.head;
		System.out.println("Displaying Linked List");
		while(temp != null) {
			System.out.print(temp.data + "-> ");
			temp = temp.next;
		}
		System.out.print("NULL" + "\n");
	}
	public static void main(String[] args) {
		Singly_Linked_List list = new Singly_Linked_List();
		list.insert_head(56);
		list.insert_tail(16);
		list.insert_tail(54);
		list.insert_tail(76);
		list.insert_tail(82);
		list.insert_head(113);
		list.insert_head(25);
		list.displayLinkedList();
		list.delete_head();
		list.delete_tail();
		list.displayLinkedList();
	}
}
