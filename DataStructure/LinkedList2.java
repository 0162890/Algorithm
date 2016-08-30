import java.util.LinkedList;
/*
*
* @author Linda
* 2016.08.30
* Data Structure
* LinkedList Collection Framework 
* 
*/
public class LinkedList2 {
	public static void main(String[] args) {
		LinkedList<Character> list = new LinkedList<Character>();
		System.out.println("Add A,B,C");
		list.add('A');
		list.add('B');
		list.add('C');
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("Size : " +list.size());
		System.out.println();
		System.out.println("Insert D in 2");
		list.add(2, 'D');
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("Size : "+list.size());
		System.out.println();
		System.out.println("Delete in 1");
		list.remove(1);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("Size : "+list.size());	
		System.out.println();
		System.out.println("Get in 1");
		System.out.println(list.get(1));
	}

}
