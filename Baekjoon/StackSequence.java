import java.util.Scanner;
import java.util.Stack;
/*
*
* @author Linda
* 2016.06.20
* 스택 수열 : 1부터 순서대로 stack에 넣어서 주어진 수열을 만들 수 있는가?  
* https://www.acmicpc.net/problem/1874
* 
*/
public class StackSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int[] array = new int[max];
		String[] word = new String[max*2];//+,-를 저장할 배열 
		for(int i=0; i<max; i++){
			int a = sc.nextInt();
			array[i] = a;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int point = 0;//word배열을 가르킬 index 
		int num = 1;//stack에 넣을 값 
		boolean ok = true;
		for(int i=0; i<max; i++){
			if(stack.isEmpty() || array[i]>stack.peek()){
				//현재 값과 같아질 때 까지 stack에 값을 넣기 
				while(array[i] >= num){
					word[point] = "+";
					point += 1;
					stack.push(num);
					num += 1;
				}
			}
			//현재값이 stack의 맨 위의 값과 같으면 pop 
			if(array[i] == stack.peek()){
				word[point] = "-";
				point += 1;
				stack.pop();
			}
			//현재값이 stack의 맨 위 값보다 작으면 수열이 만들어지지 않으므로 break 
			else if(array[i] < stack.peek()){
				ok = false;
				break;
			}
		}
		if(ok){
			for(int i=0; i<word.length; i++){
				System.out.print(word[i]+" ");
			}
		}
		else System.out.println("NO");
	}

}
