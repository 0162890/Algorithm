import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
/*
*
* @author Linda
* KOI Regional 2015
* https://www.acmicpc.net/problem/10800
* 시간초과 / 더해진 Size 수정해야 함.
*
*/
public class ColorBall3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double start = System.currentTimeMillis();
		int num = sc.nextInt();
		ArrayList<BallList> list = new ArrayList<BallList>();
		BallList ball;
		for(int i=0; i<num; i++){
			int n = i;
			int c = sc.nextInt();
			int s = sc.nextInt();
			ball = new BallList(n,c,s);
			list.add(ball);
		}
		//comparator를 이용해서 정렬하기
		Comparator<BallList> comparator = new Comparator<BallList>(){
			public int compare(BallList b1, BallList b2){
				//compare함수의 경우 class를 이용해야하기 때문에 int가 아닌 Integer로 비교해야 함.
				Integer i1 = new Integer(b1.getSize());
				Integer i2 = new Integer(b2.getSize());
				return i1.compareTo(i2);
			}
		};
		//size기준 정렬
		Collections.sort(list,comparator);
		int[] colorArray = new int[num+1];
		int total = 0;
		int sum = 0;
		int count = 0;
		//첫번째의 경우 미리 넣어주기
		total += list.get(0).getSize();
		colorArray[list.get(0).getColor()] += list.get(0).getSize();
		//더해진 크기 구하기
		for(int i=1; i<num; i++){
			for(int j=1; j<=num; j++){
				if(list.get(i).getColor()==j){
					//앞의 공과 색이 같을 경우
					if(list.get(i).getSize()!=list.get(i-1).getSize()){
						total += list.get(i).getSize();
						colorArray[j] += list.get(i).getSize();
						sum = total - colorArray[j];
						break;
					}
					//앞의 공과 색이 다를 경우
					else{
						colorArray[j] += list.get(i).getSize();
						sum = total - colorArray[j];
						total += list.get(i).getSize();
						break;
					}
				}
			}
			list.get(i).setSum(sum);
		}
		//comparator를 이용해서 정렬하기
		Comparator<BallList> comparator2 = new Comparator<BallList>(){
			public int compare(BallList b1, BallList b2){
			//compare함수의 경우 class를 이용해야하기 때문에 int가 아닌 Integer로 비교해야 함.
				Integer i1 = new Integer(b1.getNumber());
				Integer i2 = new Integer(b2.getNumber());
				return i1.compareTo(i2);
			}
		};
		//index 기준 정렬
		Collections.sort(list,comparator2);
		double end = System.currentTimeMillis();
		double times = (double)(end-start)/1000;
		for(int i=0; i<num; i++){
			System.out.println(list.get(i).getSum());
		}
		System.out.println("수행시간 : "+times);
	}
}

class BallList{
	int number;
	int color;
	int size;
	int sum;
	public BallList(){

	}
	public BallList(int number, int color, int size){
		this.number = number;
		this.color = color;
		this.size = size;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
