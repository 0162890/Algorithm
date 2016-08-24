import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.09
* KOI Regional 2015
* https://www.acmicpc.net/problem/2953
*
*/
public class CookArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] array = new int[5][4];
		int sum=0;
		int max=0;
		int winner=0;
		for(int i=0; i<5; i++){
			sum = 0;
			//한 요리사가 받은 점수 더하기 
			for(int j=0; j<4; j++){
				array[i][j] = sc.nextInt();
				sum += array[i][j];
			}
			//가장 큰 값 정하기 
			if(sum>max){
				winner = i+1;
				max = sum;
			}
		}
		System.out.println(winner+" "+max);
	}
}
