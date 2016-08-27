import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.27
* Coder's high 2016 Round 1: Online
* https://www.acmicpc.net/problem/12790
*
*/
public class MiniFantasyWar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//입력값을 받을 배열 
		int[] capacity = new int[8];
		//계산한 결과를 저장할 배열 
		int[] result = new int[4];
		int ans = 0;
		for(int i=1; i<=num; i++){
			for(int j=0; j<8; j++){
				capacity[j] = sc.nextInt();
			}
			ans = power(capacity, result);
			System.out.println(ans);
		}
	}
	public static int power(int[] capacity, int[] result){
		//더한 값을 배열에 넣기 
		for(int i=0; i<4; i++){
			result[i] = capacity[i]+capacity[i+4];
		}
		//제약 조건 설정하기 
		for(int j=0; j<=1; j++){
			if(result[j]<1){
				result[j] = 1;
			}
		}
		if(result[2]<0){
			result[2] = 0;
		}
		//최종 값 계산 
		int ans = (1*result[0]) + (5*result[1]) + (2*result[2]) + (2*result[3]);
		return ans;
	}

}
