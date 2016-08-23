import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.14
* KOI Regional 2015
* https://www.acmicpc.net/problem/10798
*
*/
public class ReadHeight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] wholeArray = new String[5];//입력받은 문자열을 5개를 넣을 배열
		int arrayL = 0;
		for(int i=0; i<5; i++){
			String a = sc.next();
			wholeArray[i] = a;
			if(a.length()>arrayL){//입력받은 문자열중에 길이가 가장 긴 문자열의 길이를 찾기
				arrayL = a.length();
			}
		}
		for(int i=0; i<5; i++){//가장큰 문자열 보다 작은 문자열의 경우, 차이가 나는 수 만큼 뒤에 *룰 붙임.
			int count = arrayL-wholeArray[i].length();
			for(int j=0; j<count; j++){
				wholeArray[i] = wholeArray[i].concat("*");
			}
		}
		String[] makeSentence = new String[arrayL*5];//최종으로 받을 문자열을 저장할 배
		int j = 0;//substring을 사용할 때 필요한 변수
		//for문을 돌면서, 문자열의 처음 단어 부터 차례대로 makeSentence 배열에 저장
		for(int i=0; i<makeSentence.length; i++){
			makeSentence[i] = wholeArray[i%5].substring(j,j+1);
			if(i%5 == 4){
				j += 1;
			}
		}
		for(int i=0; i<makeSentence.length; i++){
			if(!(makeSentence[i].equals("*"))){//*일 경우를 제외하고 출력
				System.out.print(makeSentence[i]);
			}
		}
	}
}
