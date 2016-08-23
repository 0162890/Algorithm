/*
 *
 * @author Linda
 * 2016.08.17
 * KOI Regional 2015
 * https://www.acmicpc.net/problem/10801
 *
 */
import java.util.Scanner;
public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[10];
        int[] B = new int[10];
        for(int i=0; i<10; i++){
            //A의 값을 배열에 넣기
            A[i] = sc.nextInt();
        }
        for(int i=0; i<10; i++){
            //B의 값을 배열에 넣기
            B[i] = sc.nextInt();
        }
        int countA = 0;
        int countB = 0;
        for(int i=0; i<10; i++){
            //A값이 크면 countA 증가, B값이 크면 countB 증
            if(A[i] > B[i]) countA += 1;
            else if(A[i] < B[i]) countB += 1;
            else if(A[i] == B[i]){
            }
        }
        if(countA>countB) System.out.println("A");
        else if(countA<countB) System.out.println("B");
        else if(countA==countB) System.out.println("D");
    }

}
