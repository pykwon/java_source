package pack3;

public class Ex15PolyMain {
	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();
		
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		bus1.show();
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("\n--객체 주소 치환--");
		Ex15PolyCar car2 = new Ex15PolyBus();  // promotion
		car2.displaySpeed();  // 오버라이딩된 메소드는 호출 가능
		System.out.println(car2.getSpeed());
		//car2.show();  // 자식 고유의 메소드는 간섭(호출) 불가
		
		System.out.println();
		Ex15PolyCar car3 = taxi1;  // promotion
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		car3.displaySpeed();
		System.out.println(car3.getSpeed());
		

		System.out.println("\n=========");
		//Ex15PolyBus bus2 = new Ex15PolyCar(); // X
		
		Ex15PolyBus bus3 = (Ex15PolyBus)car2;   // 성립 : casting
		// car2는 부모 타입이지만 bus의 주소를 갖고 있으므로 캐스팅에 의해 치환 가능
		bus3.displaySpeed();
		
		System.out.println();
		//Ex15PolyTaxi taxi2 = new Ex15PolyCar(); // X
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi)car3;  // 성립 : casting
		taxi2.displaySpeed();
		
		//Ex15PolyTaxi taxi3 = (Ex15PolyTaxi)car1;  // 실행오류(Runtime error) - ClassCastException 
		
		System.out.println("^^^^^^^^^^^^^");
		Ex15PolyCar mycar;
		mycar = bus1;
		mycar.displaySpeed();
		
		mycar = taxi1;
		mycar.displaySpeed();
		
		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		for(Ex15PolyCar poly:p) {
			poly.displaySpeed();
		}
	}
}



