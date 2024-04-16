package pack3;

import java.awt.Frame;

public class MyFrame2 extends Frame{
	public MyFrame2() {
		// 생성자
		super("상속 사용");
	}
	
	void display() {
		setSize(500, 300);
		//super.setSize(500, 300);
		setLocation(200, 150);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// 상속으로 Frame 띄우기
		//MyFrame2 frame = new MyFrame2();
		//frame.display();
		new MyFrame2().display();
	}
}
