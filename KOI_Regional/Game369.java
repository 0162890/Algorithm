import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.23
* KOI Regional 2015
* https://www.acmicpc.net/problem/10802
* 런타임 에러 
*
*/
public class Game369 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 long start = sc.nextInt();
		 long end = sc.nextInt();
		 long startT = start/10;
		 long endT = end/10;
		 long sum = 0;
		 boolean isThree = false;
		 long checkSum = 0;
		 //10자리 단위로 끊어서, 두 수 사이에 있는 숫자들 계산
		 for(long i=startT+1; i<=endT-1; i++){
			 isThree = checkThree(i);
			 //3,6,9 숫자가 들어간 경우 10개 모두 해
			 if(isThree){
				 sum += 10;
			 }
			 else{
				 checkSum = checkSum(i);
				 //각 자리 수의 합이 3의 배수인 경우 4개가 해
				 if(checkSum%3==0){
					 sum += 4;
				 }
				 else{
					 //아닌 경우 6개가 해
					 sum+= 6;
				 }
			 }
		 }
		 //앞의 숫자 계산
		 for(long i=start; i<(startT+1)*10; i++){
			 if(i%3 == 0){
				 sum += 1;
			 }
			 else{
				 boolean isIt = checkThree(i);
				 if(isIt){
					 sum += 1;
				 }
			 }
		 }
		 //뒤의 숫자 계산
		 for(long i=endT*10; i<=end; i++){
			 if(i%3 == 0){
				 sum += 1;
			 }
			 else{
				 boolean isIt = checkThree(i);
				 if(isIt){
					 sum += 1;
				 }
			 }
		 }
		 System.out.println(sum%20150523);

	}
	//3,6,9가 들어가는 숫자인지 체크
	public static boolean checkThree(long a){
		//String으로 변환해서 각 자리 수 체크
		String str = String.valueOf(a);
		boolean isIt = false;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='3'||str.charAt(i)=='6'||str.charAt(i)=='9'){
				isIt = true;
				break;
			}
		}
		return isIt;
	}
	//각 자리의 숫자의 합을 계산
	public static long checkSum(long a){
		String str = String.valueOf(a);
		long sum = 0;
		for(int i=0; i<str.length(); i++){
			sum += str.charAt(i)-'0';//char to int ASCII 사용
		}
		return sum;
	}

}
