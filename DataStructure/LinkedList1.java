/*
*
* @author Linda
* 2016.08.30
* Data Structure
* LinkedList 
* 
*/
public class LinkedList1 {
	public static void main(String[] args) {
		List list = new List();
		System.out.println("Add A,B,C");
		list.add('A');
		list.add('B');
		list.add('C');
		list.print();
		System.out.println("Size : " +list.size());
		System.out.println();
		System.out.println("Insert D in 2");
		list.insert('D',2);
		list.print();
		System.out.println("Size : "+list.size());
		System.out.println();
		System.out.println("Delete in 1");
		list.delete(1);
		list.print();
		System.out.println("Size : "+list.size());	
		System.out.println();
		System.out.println("Get in 1");
		System.out.println(list.get(1));
	}
}
class List{
	Node root;
	public void add(char data){
		//입력받은 값으로 새로운 노드 생성. 
		Node newNode = new Node(data);
		//root가 없으면 새로운 노드가 root 
		if(root==null){
			root = newNode;
		}
		else{
			Node temp = root;
			//list의 마지막 노드를 찾기 
			while(temp.next!=null){
				temp = temp.next;
			}
			//list의 마지막에 새로운 노드를 삽입 
			temp.next = newNode;
		}
	}
	public void print(){
		//list가 비어 는 경우 
		if(root==null){
		}
		else{
			//노드를 차례로 가르키면서 출력 
			Node temp = root;
			while(temp!=null){
				System.out.print(temp.value()+" ");
				temp = temp.next;
			}
		}
		System.out.println();
	}
	public int size(){
		//list가 비어 있는 경우 
		if(root==null){
			return 0;
		}
		else{
			//노드를 차례로 가르키면서 count 더하기 
			Node temp = root;
			int count = 0;
			while(temp!=null){
				count += 1;
				temp = temp.next;
			}
			return count;
		}
	}
	public void insert(char data, int index){
		Node newNode = new Node(data);
		//현재 list의 사이즈보다 큰 값에 넣고자 하는 경우 불가능 
		if(size()<index){
			System.out.println("Insert Impossible");
		}
		else{
			//가장 앞에 넣고 싶은 경우 root노드로 만들어 줌 
			if(index==0){
				newNode.next = root;
				root = newNode;
			}
			else{
				//넣고 싶은 index의 앞 노드를 가르키는 노드 
				Node temp = root;
				for(int i=1; i<index; i++){
					temp = temp.next;
				}
				//앞의 노드의 next를 새로운 노드를 넣고
				//새로운 노드의 next에 앞의 노드의 next를 넣음 
				Node pre = temp;
				Node nextNode = pre.next;
				pre.next = newNode;
				newNode.next = nextNode;
			}
		}
	}
	public void delete(int index){
		//현재 list의 사이즈보다 큰 값에 넣고자 하는 경우 불가능 
		if(size()<=index){
			System.out.println("Delete Impossible");
		}
		else{
			//root노드를 삭제할 경우 
			if(index==0){
				root = root.next;
			}
			else{
				//삭제하고 싶은 노드의 앞 노드 
				Node temp = root;
				for(int i=1; i<index; i++){
					temp = temp.next;
				}
				//삭제하고 싶은 노드의 앞 노드가 삭제하고 싶은 노드의 next를 next로 넣음 
				Node pre = temp;
				Node target = pre.next;
				pre.next = target.next;
			}
		}
	}
	public char get(int index){
		if(index==0){
			return root.value();
		}
		else{
			Node temp = root;
			for(int i=1; i<=index; i++){
				temp = temp.next;
			}
			return temp.value();
		}
	}
}

class Node{
	char data;
	Node next;
	public Node(){
		
	}
	public Node(char data){
		this.data = data;
	}
	public char value(){
		return data;
	}
}