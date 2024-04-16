package pack;

import java.util.Scanner;

public class Test7for {
	public static void main(String[] args) {
		// 반복문 for
		// for(초기치;조건;증감치){반복 처리 대상}
		int a;
		//for(int a = 1; a <= 5; a = a + 1) {
		//for(a = 1; a <= 5; a = a + 1) {
		//for(a = 1; a <= 5; a += 1) {
		
		int sum = 0;  // 누적 기억장소
		
		for(a = 1; a <= 10; a++) {
			System.out.println("a : " + a);
			//a = 4;
			sum += a;
		}
		System.out.println("반복문 수행 후 a:" + a);
		System.out.println("합은 " + sum);
		
		for (int i = 65; i <= 90; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=10; i > 1; i -= 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		for(int ytn = 0, tvn=5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + "," + tvn + ":");
		}
		
		System.out.println();
		int aa = 1;
		for(; aa <= 5; aa++) {
			System.out.print(aa + " ");
		}
		
		System.out.println("\n\n다중 for -------");
		for(int m=1; m <= 3; m++) {
			System.out.println("m=" + m);
			for(int n=1; n <= 4; n++) {
				System.out.print("n:" + n + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		for(char i=65; i <= 90; i++) {
			System.out.print(i + " : ");
			for(char j = i; j <= 'Z'; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		// 구구단 3단 출력
		for(int count=1; count < 10; count++) {
			System.out.println("3*" + count + "=" + (3 * count));
		}
		
		//문1 : 키보드로 숫자를 받아 구구단 출력
		// 예) 몇 단? 3
		// 3*1=3 3*2=6...
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단?");
		int dan = sc.nextInt();
		
		for(int count=1; count < 10; count++) {
			System.out.print(dan + "*" + count + "=" + (dan * count) + "  ");
		}
		*/
		
		//문2 : 1 ~ 100 사이의 정수 중 3의 배수이면서 5의 배수의 갯수와 그 합을 출력
		int gaesu = 0;
		int hap = 0;
		
		for(int su=1; su <= 100; su++) {
			//System.out.println(su);
			if(su % 3 == 0 && su % 5 == 0) {
				//System.out.println(su);
				gaesu += 1;
				hap += su;
			}
		}
		System.out.println("갯수는 " + gaesu + ", 합은 " + hap);
		
		
		//문3 : 2 ~ 9단까지 출력 (다중 for)
		// 2*1=2 2*2=4...
		// ...
		// 9*1=9 9*2=18...
		for(int dan=2; dan < 10; dan++) {
			//System.out.println(dan);
			for(int no=1; no <= 9; no++) {
				//System.out.print(no + " ");
				System.out.print(dan + "*" + no + "=" + (dan * no) + " ");
			}
			System.out.println();
		}
	}
}
