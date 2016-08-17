import java.util.Scanner;
/*
*
* @author Linda
* SCPC 방속의 거울
* https://www.codeground.org/practice/practiceProbView.do?probId=12#
*
*/
public class Mirror {
	//mirror 0:거울없음 1:우측상단/좌측하단 2:좌측상단/우측하단
	//direct 0:왼쪽 1:오른쪽 2:위 3:아래
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC;
		int test_case;
		TC = sc.nextInt();
		for(test_case=1; test_case<=TC; test_case++){
			int n = sc.nextInt();
			int[][] mArray = new int[n][n];
			boolean[][] bArray = new boolean[n][n]; //지나간 거울 체크하는 배열
			for(int j=0; j<n; j++){
				String a = sc.next();
				for(int i=0; i<n; i++){
					mArray[j][i] = Integer.parseInt(a.substring(i, i+1));
				}
			}
			int[][] dArray= new int[3][4];//이동위치를 나타내기 위한 배열
			makedArray(dArray);
			int count = solveAns(mArray, bArray, dArray);
			System.out.println("Case #" + test_case);
			System.out.println(count);
		}

	}
	public static void makedArray(int[][] dArray){
		//mirror와 direct에 따라서 정해질 다음 direct에 관한 정보를 배열에 저장
		for(int i=0; i<4; i++){
			dArray[0][i]  = i;
		}
		dArray[1][0] = 3;
		dArray[1][1] = 2;
		dArray[1][2] = 1;
		dArray[1][3] = 0;
		dArray[2][0] = 2;
		dArray[2][1] = 3;
		dArray[2][2] = 0;
		dArray[2][3] = 1;
	}
	public static int solveAns(int[][] mArray, boolean[][] bArray, int[][] dArray){
		//처음 시작 위치
		int x = 0;
		int y = 0;
		int direct = 1;
		int mirror = 0;
		while(true){
			if(x<0 || x>=mArray.length || y<0 || y>=mArray.length){
				break;
			}
			if(bArray[x][y] == false && mArray[x][y] != 0){
				bArray[x][y] = true;//지나간 거울인지 확인
			}
			mirror = mArray[x][y];
			direct = dArray[mirror][direct];
			if(direct == 0){//direct값에 따라서 x,y좌표를 변경
				y -= 1;
			}
			else if(direct == 1){
				y += 1;
			}
			else if(direct == 2){
				x -= 1;
			}
			else if(direct == 3){
				x += 1;
			}
		}
		int count = 0;
		//지나간 거울의 수를 체크
		for(int i=0; i<bArray.length; i++){
			for(int j=0; j<bArray.length; j++){
				if(bArray[i][j] == true){
					count += 1;
				}
			}
		}
		return count;

	}
}
