package pack;

import java.util.Scanner;

public class Test5if {
	public static void main(String[] args) {
		// 조건 판단문 if 연습
		int num = 1;

		if (num >= 3) { // 조건이 참일 때만 두 개의 실행문 수행
			System.out.println("크군요");
			System.out.println("참일 때");
		}
		System.out.println("출력1");

		num = 5;
		if (num < 3) { // 조건에 따라 참 또는 거짓 영역 수행
			System.out.println("작군요");
			System.out.println("참일 때 수행");
		} else {
			System.out.println("거짓일 때 수행");
		}
		System.out.println("출력2");

		System.out.println("다중 if -------");
		int jumsu = 68;

		if (jumsu >= 70) {
			if (jumsu >= 90) {
				System.out.println("우수");
			} else {
				System.out.println("보통");
			}
		}
		System.out.println("출력3");

		jumsu = 65;
		if (jumsu >= 70) {
			if (jumsu >= 90) {
				System.out.println("우수");
			} else {
				System.out.println("보통");
			}
		} else {
			System.out.println("어라 70점 미만");
			if (jumsu > 50) {
				System.out.println("50점 초과");
			} else {
				System.out.println("50점 미만");
			}
		}
		System.out.println("출력4");

		jumsu = 85;
		String msg = "";
		if (jumsu >= 90) {
			msg = "수";
		} else if (jumsu >= 80) {
			msg = "우";
		} else if (jumsu >= 70) {
			msg = "미";

		} else if (jumsu >= 60) {
			msg = "양";
		} else {
			msg = "가";
		}
		System.out.println("평가 결과 : " + msg);

		System.out.println();
		// 입장료 : 8세 이하, 65세 이상 무료
		// 9세 이상 20세 미만 3000원
		// 20세 이상 65세 미만 5000원
		int age = 15;
		if (8 >= age || age >= 65) {
			System.out.println("0");
		}
		if (9 <= age && age < 20) {
			System.out.println("3000");
		}
		if (20 <= age && age < 65) {
			System.out.println("5000");
		}

		System.out.println();
		age = 15;
		int total = 0;
		if (9 <= age && age < 20) {
			total = 3000;
		} else if (20 <= age && age < 65) {
			total = 5000;
		}
		System.out.println(total + "원");

		System.out.println();
		// 문제 : 키보드로 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가)을 출력하시오.
		// 조건 : 금액이 5만원 이상이면 금액에 10%를 아니면 금액에 5%를 세금으로 출력
		// 출력 모양은 상품명:*** 금액:*** 세금:***
		Scanner sc = new Scanner(System.in); // 표준 입력장치(키보드)로 값 얻기
		System.out.print("상품명 입력:");
		String irum = sc.next();
		System.out.print("수량 입력:");
		int su = sc.nextInt();
		System.out.print("단가 입력:");
		int dan = sc.nextInt();
		int keum = su * dan; // 금액
		double sekeum = 0.0;

		if (keum >= 50000) {
			sekeum = keum * 0.1;
		} else {
			sekeum = keum * 0.05;
		}
		System.out.println("상품명:" + irum + " 금액:" + keum + " 세금:" + sekeum);
	}
}
