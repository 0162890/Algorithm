import java.util.Scanner;
/*
*
* @author Linda
* SCPC 숫자 골라내기
* https://www.codeground.org/practice/practiceProbView.do?probId=1#
*
*/
public class PickNum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			int num = sc.nextInt();
			int ans =0;
			//모든 수를 xor 함.
			for(int j=0; j<num; j++){
				int a = sc.nextInt();
				ans = ans^a;
			}
			System.out.println("Case #" + test_case);
			System.out.println(ans);
		}
	}
}
//홀수번 나온 수를 xor하는 문제
//xor의 경우 같은 숫자를 두번 xor하면 0이 됨
//3^3 = 0이고, 0^4=4
