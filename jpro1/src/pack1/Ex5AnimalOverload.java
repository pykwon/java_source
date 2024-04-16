package pack1;

// method overload : 한 개의 클래스의 이름이 같은 메소드를 여러 개 선언
// 성립 조건 : 매개변수의 갯수, 타입, 순서가 다르면 된다. 반환형과는 관계없다.

public class Ex5AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1;  // final 멤버필드는 대문자로 적자
	
	public Ex5AnimalOverload() {
		// 생성자는 내용이 없는 경우 생략 가능
		this(10);   // 생성자가 다른 생성자를 호출
		System.out.println("비어 있는 생성자");
		
		//메소드명();  // 생성자가 메소드를 호출
	}
	public Ex5AnimalOverload(int leg) {  // 생성자 오버로딩
		this.leg = leg;
	}
	public Ex5AnimalOverload(String name) {  // 생성자 오버로딩
		this.name = name;
	}
	public Ex5AnimalOverload(String name, int age, int leg) {  // 생성자 오버로딩
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
	
	//------------------------------------------
	public void display() {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	// method overloading
	public void display(int age) {  // 매개변수(parameter)의 갯수가 다름
		this.age = age;  // 지역변수 age를 멤버필드 age에 기억
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(String name) {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(String name, int age) {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(int age, String name) {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	/* 에러~
	public void display(int leg) {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public String display(int leg) {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
    */
}



