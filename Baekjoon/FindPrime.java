import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.25
* 소수 찾기 
* https://www.acmicpc.net/problem/1978
*
*/
public class FindPrime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		int count = 0;
		boolean isIt = false;
		for(int i=0; i<size; i++){
			array[i] = sc.nextInt();
			//소수일 경우 true return 
			isIt = find(array[i], count);
			//true일 경우 count 값 증가 
			if(isIt) count += 1;
		}
		System.out.println(count);
	}
	public static boolean find(int num, int count){
		boolean isIt = true;
		//1일 경우 소수 아님 
		if(num==1){
			isIt = false;
		}
		//2일 경우 소수 
		else if(num==2){
			isIt = true;
		}
		else{
			//2부터 num보다 작은 때까지 나누어 떨어지는 수가 있는 경우 소수 아님 
			for(int i=2; i<num; i++){
				if(num%i==0){
					isIt = false;
					break;
				}
			}
		}
		return isIt;
	}
}
