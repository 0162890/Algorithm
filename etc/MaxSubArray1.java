/*
*
* @author Linda
* 2016.08.27
* 최대 구간 합 문제 
* 알고리즘 문제풀이 전략 코드 4.9 ~ 4.11
*
*/
public class MaxSubArray1 {

	public static void main(String[] args) {
		int[] array = {-7, 4, -3, 6, 3, -8, 3, 4};
//		int[] array = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		int ans1 = betterMaxSum(array);
		int ans2 = fasterMaxSum(array, 0, array.length-1);
		int ans3 = fastestMaxSum(array);
		System.out.println("O(n^2) : "+ans1);
		System.out.println("O(nlogn) : "+ans2);
		System.out.println("O(n) : "+ans3);

	}
	//O(n^2)의 방법. for문 두번 돌면서 처음부터 다 체크 
	public static int betterMaxSum(int[] array){
		int ans = 0;
		int temp = 0;
		int max = -98765;
		for(int i=0; i<array.length; i++){
			temp = array[i];
			for(int j=i+1; j<array.length; j++){
				//순서대로 더하면서 더 큰 값을 찾음. 
				temp += array[j];
				max = Math.max(max, temp);
			}
		}
		return max;
	}
	//O(nlogn)의 방법. Divide and Conquer 방법.
	public static int fasterMaxSum(int[] array, int lo, int hi){
		if(lo==hi){ 
			 return array[lo];
		}
		int mid = (lo+hi)/2;
		int left = -98765;
		int right = -98765;
		//두부분에 모두 걸쳐 있는 최대 합 구하기 
		int sum = 0;
		//왼쪽 배열의 가장 큰 값 구하기 
		for(int i=mid; i>=lo; i--){
			sum += array[i];
			left = Math.max(left,sum);
		}
		sum = 0;
		//오른쪽 배열의 가장 큰 값 구하기 
		for(int i=mid+1; i<=hi; i++){
			sum += array[i];
			right = Math.max(right, sum);
		}
		//최대 값이 두 부분에 걸쳐 있지 않은 경우의 답을 재귀로 구하기 
		int single = Math.max(fasterMaxSum(array,lo,mid), fasterMaxSum(array,mid+1,hi));
		return Math.max(single, left+right);
	}
	
	//O(n)의 방법. kadane's algorithm
	//maxAt(i) = Math.max(maxAt(i-1),0)+array[i];
	//i전까지의 최대합의 구간에서 i값을 붙인 구간의 합을 비교해서 최대 구간을 구할 수 있음.
	//위의 식에서 0의 의미는 i값에 아무것도 더하지 않은 순수한 i의 값을 의미하게 됨. 
	public static int fastestMaxSum(int[] array){
		int psum = 0;
		int ans = 0;
		int max = -98765;
		for(int i=0; i<array.length; i++){
			//i전까지의 합 + i값과 i의 값 중의 큰 값을 구함. 
			psum = Math.max(psum, 0) + array[i];
			max = Math.max(max, psum);
		}
		return max;
	}
}
