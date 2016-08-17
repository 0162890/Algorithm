import java.util.HashSet;
/*
*
* @author Linda
* SCPC 좋은 수
* https://www.codeground.org/practice/practiceProbView.do?probId=7
*
*/
import java.util.Scanner;
public class GoodNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC;
		int test_case;
		TC = sc.nextInt();
		for(test_case=1; test_case<=TC; test_case++){
			int count = 0;//좋은 수의 개수를 count하는 변수
			int num = sc.nextInt();
			int[] array = new int[num];
			for(int i=0; i<num; i++){
				array[i] = sc.nextInt();
			}
			HashSet<Integer> hash = new HashSet<Integer>();
			for(int i=0; i<num; i++){
				for(int j=0; j<i; j++){
					//hashset에는 두수의 합이 들어 있으므로 차이가 hashset에 존재한다면 좋은수
					if(hash.contains(array[i]-array[j])){
						count += 1;
						break;
					}
				}
				for(int k=0; k<=i; k++){//두 수의 합은 hashset에 저장
					hash.add(array[i]+array[k]);
				}
			}
			System.out.println("Case #" + test_case);
			System.out.println(count);
		}
	}
}
