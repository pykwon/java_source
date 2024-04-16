package pack3;

public class Ex16ElecMain {

	public static void main(String[] args) {
		// 가전제품 부모 클래스 생성 후 volumeControl()을 오버라이딩하여 다형성 구사
		Ex16ElecPolyProduct product = null;  // 부모 객체로만 의미를 가짐

		Ex16ElecPolyRadio radio = new Ex16ElecPolyRadio();
		radio.setVolume(7);
		System.out.println(radio.getVolume());
		radio.volumeControl();
		
		System.out.println();
		Ex16ElecPolyTv tv = new Ex16ElecPolyTv();
		tv.setVolume(3);
		tv.volumeControl();
		tv.tvShow();  // tv 고유 메소드
		
		System.out.println("\n다형성 ----------");
		product = radio;  // promotion
		product.volumeControl();
		System.out.println();
		product = tv;  // promotion
		product.volumeControl();
	}

}





