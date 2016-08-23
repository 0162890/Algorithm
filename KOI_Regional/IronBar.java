import java.util.Scanner;
import java.util.Stack;
/*
*
* @author Linda
* 2016.08.16
* KOI Regional 2015
* https://www.acmicpc.net/problem/10799
*
*/
public class IronBar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bracket = sc.nextLine();//괄호들을 입력받음.
		char[] array = bracket.toCharArray();//입력받은 괄호를 char 배열에 넣음
		Stack<Character> stack = new Stack<Character>();//Stack 생성
		int sum = 0;
		for(int i=0; i<array.length; i++){
			if(array[i]=='('){//'('일 경우 push
				stack.push('a');
			}
			else if(array[i]==')'){//')'일 경우 pop
				stack.pop();
				if(array[i-1]=='('){//앞의 문자가 '('일 경우 stack size만큼 더하기
					sum += stack.size();
				}
				else if(array[i-1]==')'){//앞의 문자가 ')'일 경우 1 더하기
					sum += 1;
				}
			}
		}
		System.out.println(sum);
	}

}
