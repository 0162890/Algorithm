import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.29
* Coder's high 2016 Round 1: Online
* https://www.acmicpc.net/problem/12792
* 시간초과 
* Pseudo forest?
*/
public class LotGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] values = new int[num+1];
		boolean ok = true;
		int count = 0;
		for(int i=1; i<=num; i++){
			values[i] = sc.nextInt();
			//같은 숫자가 있는 경우 break. 
			if(values[i] == i){
				ok = false;
				break;
			}
		}
		if(ok){
			count = handleData(values);
		}
		else{
			count = -1;
		}
		System.out.println(count);
		
	}
	
	public static int handleData(int[] values){
		int[] tempArray = new int[values.length]; 
		System.arraycopy(values, 0, tempArray, 0, values.length);
		int count = 1;
		boolean alldif = true;
		//모든 숫자가 다를 때까지 진행 
		while(true){
			alldif = true;
			for(int i=1; i<values.length; i++){
				int cur = tempArray[i];
				tempArray[i] = values[cur];
				//숫자가 같은 경우 false 
				if(tempArray[i]==i){
					alldif = false;
				}
			}
			count += 1;
			//모든 숫자가 다른 경우 break 
			if(alldif){
				break;
			}	
		}
		return count;
	}
}







