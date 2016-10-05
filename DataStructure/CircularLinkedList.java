/*
*
* @author Linda
* 2016.10.04
* Data Structure
* CircularLinkedList
* 
*/
public class CircularLinkedList {

	public static void main(String[] args) {
		System.out.println("Circular Linked List");
		System.out.println();
		CircularList list = new CircularList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.print("Print All : ");
		list.print();
		System.out.println();
		System.out.println("get(2) : "+list.get(2));
		System.out.println("size : "+list.size());
		list.insert(9,2);
		System.out.println("insert(9,2)");
		System.out.print("Print All : ");
		list.print();
	
	}

}

class CircularList{
	Node2 head;
	public void add(int data){
		Node2 newNode = new Node2(data);
		if(head == null){
			head = newNode;
			newNode.next = head;
		}
		else{
			Node2 temp = head;
			while(temp.next != head){
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
	}
	
	public void insert(int data, int index){
		Node2 newNode = new Node2(data);
		if(size() < index){}
		else if(size() == index){
			Node2 tail = head;
			while(tail.next != head){
				tail = tail.next;
			}
			tail.next = newNode;
			newNode.next = head;
		}
		else{
			if(index == 0){
				Node2 tail = head;
				while(tail.next != head){
					tail = tail.next;
				}
				tail.next = newNode;
				newNode.next = head;
				head = newNode;
			}
			else{
				Node2 temp = head;
				for(int i=1; i<index; i++){
					temp = temp.next;
				}
				Node2 nextNode = temp.next;
				temp.next = newNode;
				newNode.next = nextNode;
			}
		}
	}
	
	public int size(){
		if(head == null){
			return 0;
		}
		else{
			Node2 temp = head;
			int count = 1;
			while(temp.next != head){
				count += 1;
				temp = temp.next;
			}
			return count;
		}
	}
	
	public void print(){
		if(size() < 1){}
		else{
			Node2 temp = head;
			for(int i=0; i<size(); i++){
				System.out.print(temp.value()+" ");
				temp = temp.next;
			}
		}
	}
	
	public int get(int index){
		if(index == 0){
			return head.value();
		}
		else{
			Node2 temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			return temp.value();
		}
	}
	
}

class Node2{
	int data;
	Node2 next;
	public Node2(int data){
		this.data = data;
	}
	public int value(){
		return data;
	}
}