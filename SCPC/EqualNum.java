import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.06
* SCPC 균일수 
* https://www.codeground.org/practice/practiceProbView.do?probId=13
* 시간초과 106/150
* 
*/
public class EqualNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC;
		int test_case;
		TC = sc.nextInt();
		for(test_case=1; test_case<=TC; test_case++){
			int num = sc.nextInt();
			int temp = num;
			int remainder;
			int count;
			int compare; 
			boolean isIt = false;
			//2부터 나눠서 나머지가 같은 경우에는 계속 진행하고, 아니면 나누는 수를 증가시킴 
			for(count=2; count<num; count++){
				remainder = temp % count;
				compare = remainder;
				temp = temp/count;
				while(true){
					if(temp == 0){
						isIt = true;
						break;
					}
					remainder = temp % count;
					//나머지가 같지 않을 경우 나누는 수를 증가.
					if(compare != remainder){
						temp = num;
						break;
					}
					else{
						//나머지가 같을 경우 계속 진행. 
						temp = temp/count;
					}
				}
				if(isIt==true){
					break;
				}
			}
			
			System.out.println("Case #" + test_case);
			System.out.println(count);
		}
	}

}
