import java.util.Scanner;
import java.util.Stack;
/*
*
* @author Linda
* 2016.09.02
* 문제 분류 : stack
* https://www.acmicpc.net/problem/2493
*
*/
public class Top {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] tops = new int[num+1];
		//결과를 저장할 배열 
		int[] results = new int[num+1];
		for(int i=1; i<tops.length; i++){
			tops[i] = sc.nextInt();
		}
		findNum(tops, results);
		for(int i=1; i<results.length; i++){
			System.out.print(results[i]+" ");
		}
	}
	public static void findNum(int[] tops, int results[]){
		//맨 처음 값은 0 
		results[1] = 0;
		//높은 빌딩을 저장할 stack 
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=1; i<tops.length-1; i++){
			//i가 다음 값보다 크다면,
			if(tops[i]>tops[i+1]){
				//그 index를 stack에 저장 
				stack.push(i);
				results[i+1] = i;
			}
			//i가 다음 값보다 작을 경우, stack에 들어있는 값들과 비교 
			else{
				//stack이 empty일 때 까지 큰 값을 못 찾았다면 결과는 0
				//배열의 초기값이 0이므로, 값을 넣지 않아도 
				while(!stack.isEmpty()){
					int temp = stack.peek();
					if(tops[temp]>tops[i+1]){
						results[i+1] = temp;
						break;
					}
					//stack의 가장 위의 값보다 현재 값이 크다면 그 값을 stack에서 삭제 
					else{
						stack.pop();
					}
				}
			}
		}
	}

}
