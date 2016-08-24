import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.14
* KOI Regional 2015
* https://www.acmicpc.net/problem/2581
* 에라토스테네스의 
*
*/
public class PrimeNumSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int num = sc.nextInt();
		int[] array = new int[num+1];//소수가 아님을 체크하기 위한 array 
		findPrimeNum(min, num, array);
	}
	public static void findPrimeNum(int min, int num, int[] array){
		if(min == 1){//최소 값이 1인경우 2로 세팅(1은 소수가 아니므로)
			min = 2;
		}
		for(int i=2; i<=num; i++){
			if(array[i] == 1) continue; //이미 체크가 되어 있는 경우 
			for(int j=i+i; j<=num; j+=i){//나를 제외한 나의 배수를 모두 체크하기 
				array[j] = 1;
			}
		}
		boolean isIt = false;//소수가 없을 경우를 체크 
		int minNum = 10001;
		int sum = 0;
		for(int i=min; i<=num; i++){
			if(array[i]!=1){
				if(i<minNum){//최소값 구하기 
					minNum = i;
				}
				isIt = true;//소수가 있음 
				sum += i;//sum 구하기 
			}
		}
		if(!isIt) System.out.println(-1);//소수가 없는 경우 
		else{//소수가 있는 경우 
			System.out.println(sum);
			System.out.println(minNum);
		}
	}
}
