package pack1;

public class Ex3Main {

	public static void main(String[] args) {
		// 클래스 기본 연습 중
		Ex3Programmer programmer = new Ex3Programmer();
		programmer.displayData();
		
		System.out.println();
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
		programmer.displayData();
		
		System.out.println("-------");
		Ex3Programmer tom = new Ex3Programmer();
		tom.nickName = " 톰 아저씨";
		tom.displayData();
		
		System.out.println("-------");
		Ex3Programmer james = new Ex3Programmer();
		james.nickName = "제임스 형";
		james.displayData();
		
		System.out.println();
		System.out.println("너의 모토는 " + james.motto);
		// static 멤버는 클래스이름.멤버 하고 사용한다(권장)
		System.out.println("너의 모토는 " + Ex3Programmer.motto);
		Ex3Programmer.goodMethod();
	}

}




