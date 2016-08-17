import java.util.Scanner;
/*
*
* @author Linda
* SCPC 개구리 뛰기
* https://www.codeground.org/practice/practiceProbView.do?probId=11
*
*/
public class JumpingFrog_Jinny {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int num = sc.nextInt();
			int[] array = new int[num];
			for(int i=0; i<array.length; i++){
				array[i] = sc.nextInt();
			}
			int count = 0;
			int jump = sc.nextInt();
			int current = 0;
			//점프가 불가능한 경우.
			for(int i=0; i<array.length-1; i++){
				if(array[i+1]-array[i] > jump){//인접한 돌 사이의 거리가 jump보다 큰 경우
					count = -1;
					break;
				}
			}

			if(count != -1){
				for(int i=0; i<array.length; i++){
					if(array[i]-current > jump){//array[i]까지 jump로 갈 수 없다면
						current = array[i-1];//그 전의 돌까지는 늘 jump할 수 있음
						count += 1;//jump 한 번 증가
					}
				}
				count += 1; // 마지막 돌은 점프를 안하므로 추가해줘야 함.
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(count);

		}
	}

}
