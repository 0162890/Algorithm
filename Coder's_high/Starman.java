import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/*
*
* @author Linda
* 2016.08.28
* Coder's high 2016 Round 1: Online
* https://www.acmicpc.net/problem/12791
*
*/
public class Starman {

	public static void main(String[] args) {
		//주어진 값을 배열에 넣기. 
		int[] years = {1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976, 1977, 1977, 1979, 1980, 1983, 1984, 1987, 1993, 1995, 1997, 1999, 2002, 2003, 2013, 2016};
		String[] names = {"DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", "AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation", "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance", "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling", "Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"};
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=1; i<=num; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			//가르키는 index를 저장할 list
			ArrayList<Integer> list = new ArrayList<Integer>();
			int count = 0;
			for(int j=0; j<years.length; j++){
				//배열을 돌면서 연도가 주어진 값 사이에 있는 경우 찾기 
				if(years[j]>=start && years[j]<=end){
					list.add(j);
					count += 1;
				}
			}
			Iterator it = list.iterator();
			System.out.println(count);
			while(it.hasNext()){
				//index에 해당하는 값 출력 
				int index = Integer.parseInt(it.next().toString());
				System.out.println(years[index]+" "+names[index]);
			}
		}
 
	}

}
