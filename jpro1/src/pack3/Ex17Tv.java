package pack3;

public class Ex17Tv extends Ex17Jepum{
	public Ex17Tv() {
		System.out.println("TV 생성자");
	}
	
	@Override
	public void volumeControl() {
		// 오버라이딩 강요 당함
		System.out.println("TV 소리 변경");
	}
	
	@Override
	public void volumeShow() {
		// 오버라이딩 선택
		System.out.println("소리 크기는 적당히 : 부모 메소드 내용 대신 새로운 내용으로 대체");
	}
}
