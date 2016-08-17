import java.util.Scanner;
/*
*
* @author Linda
* KOI Regional 2015
* https://www.acmicpc.net/problem/10797
*
*/
public class Car {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int day = sc.nextInt();
		 int count = 0;
		 for(int i=0; i<5; i++){
			 int a = sc.nextInt();
			 if(a==day){
				 count += 1;
			 }
		 }
		 System.out.println(count);
	}
}
