package pack3;

public interface Ex21Resume { // 이력서 표준 양식
	String SIZE = "A4";   // public final static String SIZE = "A4";
	//int kor = 90;
	
	void setIrum(String irum);
	void setPhone(String phone);
	void printData();
	
	// java 1.8 이후에 가능
	default void display(boolean b) {
		if(b) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
	}
	
	static void play() {
		System.out.println("play 메소드");
	}
}
