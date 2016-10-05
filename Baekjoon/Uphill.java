import java.util.Scanner;
/*
*
* @author Linda
* Coupang Study 1day
* 2016.10.04
* day1
* https://www.acmicpc.net/problem/2846
* 
*
*/
public class Uphill{	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = sc.nextInt();
		}
		int ans = find(array);
		System.out.println(ans);
	}
	public static int find(int[] array){
		int start, end;
		int temp;
		int max = 0;
		int idx = 0;
		while(true){
			if(idx >= array.length-1){
				break;
			}
			if(array[idx]>=array[idx+1]){
				idx += 1;
			}
			else{
				start = idx;
				end = compare(array, idx);
				temp = array[end] - array[start];
				if(max<temp){
					max = temp;
				}
				idx += (end-start+1);
			}
		}
		return max;
	}
	public static int compare(int[] array, int start){
		boolean isIt = true;
		int end=start+1;
		for(int i=start+1; i<array.length-1; i++){
			if(array[i]<array[i+1]){
			}
			else{
				isIt = false;
				end = i;
				break;
			}
		}
		if(isIt){
			end = array.length-1;
		}
		return end;
	}
}
