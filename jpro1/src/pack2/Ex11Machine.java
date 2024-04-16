package pack2;

import java.util.Scanner;

public class Ex11Machine {
	private int cupCount;
	private Ex11CoinIn coinIn = new Ex11CoinIn();  // 포함 관계
	
	public Ex11Machine() {
		
	}
	
	public void showData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 입력하세요");
		coinIn.setCoin(scanner.nextInt());
		
		System.out.print("몇 잔을 원하세요");
		cupCount = scanner.nextInt();
		//String result = coinIn.calc(cupCount);
		//System.out.println(result);
		System.out.println(coinIn.calc(cupCount));
		scanner.close();
	}
}
