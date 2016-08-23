import java.util.Scanner;
/*
*
* @author Linda
* 2016.07.18
* SCPC 미궁의 
* https://www.codeground.org/practice/practiceProbView.do?probId=6
* heap space error 53/100
* 
*/
public class Room_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC;
		int test_case;
		TC = sc.nextInt();
		
		for(test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int[][] array = new int[n][n];
			int a = 1;
			int i=0;
			int j=0;
			//지그재그 방 만들기 
			makeArray(array, a, i, j, n);
			int count = sc.nextInt();
			String move = sc.next();
			char[] movement = move.toCharArray();
			
			//방문한 곳의 합 구하기 
			int sum = sumMovement(array, movement);
			
			//지그재그 방 프린트 
			for(int q=0; q<n; q++){
				for(int w=0; w<n; w++){
					System.out.print(array[q][w]+" ");
				}
				System.out.println();
			}
			System.out.println("Case #" + test_case);	
			System.out.println(sum);
		}
	}
	//지그재그 방 만드는 함수 
	public static void makeArray(int[][] array, int a, int i, int j, int n){
		for(int k=1; k<=n; k++){
			if(k%2==0){
				while(j>0){
					array[i][j] = a;
					i++; j--;
					a++;
				}
				array[i][j] = a;
				a++;
				i++;
			}
			else{
				if(k==1){
					array[i][j] = a;
					a++;
				}
				else{
					while(i>0){
						array[i][j] = a;
						i--; j++;
						a++;
					}
					array[i][j] = a;
					a++;
				}
				j++;
			}
		}
		if(n%2==0){
			i--; j++;
		}
		else{
			i++; j--;
		}
		for(int k=n; k>1; k--){
			if(k%2==0){
				while(j<n-1){
					array[i][j] = a;
					i--; j++;
					a++;
				}
				array[i][j] = a;
				a++;
				i++;
			}
			else{
				while(i<n-1){
					array[i][j] = a;
					i++; j--;
					a++;
				}
				array[i][j] = a;
				a++;
				j++;
			}
		}
	}
	//방문한 곳의 합 구하는 함수 
	public static int sumMovement(int[][] array, char[] movement){
		int j=0;
		int i=0;
		int sum = 1;
		for(int k=0; k<movement.length; k++){
			if(movement[k]=='U'){
				i--;
			}
			else if(movement[k]=='D'){
				i++;
			}
			else if(movement[k]=='L'){
				j--;
			}
			else if(movement[k]=='R'){
				j++;
			}
			sum += array[i][j];
		}
		return sum;
	}
}
