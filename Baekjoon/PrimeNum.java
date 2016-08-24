import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.13
* KOI Regional 2015
* https://www.acmicpc.net/problem/1929
* 에라토스테네스의 
*
*/
public class PrimeNum {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
         int min = sc.nextInt();
         int num = sc.nextInt();
         int[] array = new int[num+1];//체크를 위한 배열 생성 
         findPrime(min, num, array);//소수 구하는 함수 
    }
    public static void findPrime(int min, int num, int[] array){
    	if(min == 1){//2부터 소수이므로, min값이 1인 경우 2로 바꿔준다 
    		min = 2;
    	}
    	for(int i=2; i<=num; i++){
    		if(array[i]==1){//이미 소수가 아니라고 체크 된 경우 제외 
    			continue;
    		}
    		for(int j=i+i; j<=num; j+=i){//나를 제외하고 나의 배수인 경우 1로 체크 
    			array[j] = 1;
    		}
    	}
    	int count = 0;
    	for(int i=min; i<=num; i++){
    		if(array[i]!=1){//소수인 경우 프린트 
    			System.out.println(i);
    			count += 1;
    		}
    	}
    }
}

