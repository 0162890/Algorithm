import java.util.Arrays;
import java.util.Scanner;
/*
*
* @author Linda
* 2016.07.03
* SCPC 프로그래밍 경진대회 
* https://www.codeground.org/practice/practiceProbView.do?probId=2
* 
*/
public class Competition2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			int num = sc.nextInt();
			int[] array = new int[num];
			int count = num;
			for(int i=0; i<num; i++){
				array[i] = sc.nextInt();
			}
			Arrays.sort(array); //작은 순서대로 정렬 
			int[] sumArray = new int[num];
			int temp = num;
			int max = 0;
			for(int i=0; i<num; i++){
				//가장 작은 수부터 차례대로 num, num-1.. 값을 넣음 
				sumArray[i] = array[i] + temp;
				temp -= 1;
				//max값을 찾음 
				if(sumArray[i] > max){
					max = sumArray[i];
				}
			}
			int index = 0;
			for(int i=0; i<num; i++){
				//max값보다 같거나 커지는 index를 찾음 
				if(max <= num + array[i]){
					index = i;
					break;
				}
			}
			System.out.println("Case #" + test_case);
			//그 index부터 우승이 가능 
			System.out.println(num-index);
		}
	}

}
