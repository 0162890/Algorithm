import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.10
* KOI Regional 2015
* https://www.acmicpc.net/problem/2920
*
*/
public class Scale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[8];
		array[0] = sc.nextInt();
		boolean isIt = true;
		//처음 변수가 1인지 8인지 아닌지로 나눠서 진행 
		if(array[0] == 1){
			for(int i=1; i<8; i++){
				array[i] = sc.nextInt();
				if(array[i]!=i+1){//array[0]==1인 경우, 다음 값이 i+1과 같으면 계속 진행 
					isIt = false;
					break;
				}
			}
			if(isIt == true){
				System.out.println("ascending");
			}
			else System.out.println("mixed");
		}
		else if(array[0] == 8){
			for(int i=1; i<8; i++){
				array[i] = sc.nextInt();
				if(array[i]!=8-i){//array[0]==8인 경우, 다음 값이 8-i와 같으면 계속 진행 
					isIt = false;
					break;
				}
			}
			if(isIt == true){
				System.out.println("descending");
			}
			else System.out.println("mixed");
		}
		else{
			System.out.println("mixed");
		}
	}
}
