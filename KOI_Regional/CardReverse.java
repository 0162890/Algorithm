import java.util.Scanner;
/*
*
* @author Linda
* KOI Regional 2015
* https://www.acmicpc.net/problem/10804
*
*/
public class CardReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] card = new int[21];
		//card값 초기화 
		for(int i=1; i<=20; i++){
			card[i] = i;
		}
		//왼쪽과 오른쪽을 가르킬 인덱스 
		int leftIdx = 0;
		int rightIdx = 0;
		for(int i=1; i<=10; i++){
			leftIdx = sc.nextInt();
			rightIdx = sc.nextInt();
			reverse(leftIdx, rightIdx, card);
		}
		for(int i=1; i<=20; i++){
			System.out.print(card[i]+" ");
		}
	}
	public static void reverse(int leftIdx, int rightIdx, int[] card){
		int temp = 0;
		while(true){
			//leftIdx가 rightIdx보다 크거나 같을 때 까지 반복 
			if(leftIdx>=rightIdx){
				break;
			}
			temp = card[leftIdx];
			card[leftIdx] = card[rightIdx];
			card[rightIdx] = temp;
			
			leftIdx += 1;
			rightIdx -= 1;
		}
	}
}
