/*
*
* @author Linda
* 2016.10.04
* Data Structure
* DoublyLinkedList
* 
*/
public class DublyLinkedList {

	public static void main(String[] args) {
		System.out.println("Doubly Linked List");
		System.out.println();
		DoublyList list = new DoublyList();
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
		System.out.println();
		System.out.println("delete(1) :");
		list.delete(1);
		System.out.print("Print All : ");
		list.print();
	}

}

class DoublyList<E>{
	Node1 head;
	public void add(E data){
		Node1 newNode = new Node1(data);
		if(head == null){
			head = newNode;
		}
		else{
			Node1 temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
	}
	public void insert(E data, int index){
		if(size()<index){}
		else{

			Node1 newNode = new Node1(data);
			if(index == 0){
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			else{
				Node1 temp = head;
				for(int i=1; i<index; i++){
					temp = temp.next;
				}
				Node1 nextNode = temp.next;
				temp.next = newNode;
				newNode.prev = temp;
				newNode.next = nextNode;
				nextNode.prev = newNode;
			}
		}
	}
	public void delete(int index){
		if(size()<index){}
		else{
			if(index==0){
				head = head.next;
				head.prev = null;
			}
			else{
				Node1 temp = head;
				for(int i=1; i<index; i++){
					temp = temp.next;
				}
				Node1 prevNode = temp;
				Node1 nextNode = temp.next.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
			}
		}
	}
	public E get(int index){
		if(index == 0){
			return (E) head.value();
		}
		else{
			Node1 temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			return (E) temp.value();
		}
	}
	public void print(){
		if(size() < 1){}
		else{
			Node1 temp = head;
			for(int i=0; i<size(); i++){
				System.out.print(temp.value()+" ");
				temp = temp.next;
			}
		}
	}
	public int size(){
		if(head == null){
			return 0;
		}
		else{
			int count = 0;
			Node1 temp = head;
			while(temp!=null){
				count += 1;
				temp = temp.next;
			}
			return count;
		}
	}
}



class Node1<E>{
	E data;
	Node1 prev;
	Node1 next;
	public Node1(E data){
		this.data = data;
	}
	public E value(){
		return data;
	}
}