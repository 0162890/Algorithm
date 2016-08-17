import java.util.Arrays;
import java.util.Scanner;
/*
*
* @author Linda
* SCPC 시험공부
* https://www.codeground.org/practice/practiceProbView.do?probId=3#
*
*/
public class PreparingTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for(test_case = 1; test_case <= TC; test_case++) {
			int total = sc.nextInt();
			int pick = sc.nextInt();
			int[] array = new int[total];
			for(int i=0; i<total; i++){
				array[i] = sc.nextInt();
			}
			//작은 순서대로 정렬
			Arrays.sort(array);
			int result = 0;
			//큰 수부터 pick 수 만큼 더함.
			for(int j=total-1; j>=total-pick; j--){
				result += array[j];
			}

			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}

}
