package pack7gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ex50Packman extends JFrame implements KeyListener{
	Image image;
	int x = 100, y = 100;
	int selImage = 1;
	
	public Ex50Packman() {
		super("상하좌우 화살표를 사용하세요");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg"));
		
		setLayout(null);  // 배치 관리자 없음
		setResizable(false);
		
		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(this);
		
		x = super.getWidth() / 2;  // frame의 너비 절반
		y = super.getHeight() / 2; // frame의 높이 절반
	}
	
	@Override
	public void paint(Graphics g) {
		// Frame에 뭔가를 주려주는 메소드로 자동 호출
		switch(selImage) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack2.jpg");
			break;
			
		}
		
		g.clearRect(0, 0, getWidth(), getHeight()); // 화면전체를 선택 후 클리어 : 잔상 해결
		
		g.drawImage(image, x - image.getWidth(this) / 2, 
				y - image.getHeight(this) / 2, this);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("key : " + key);
		
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) { // 오른쪽 화살표
			//System.out.println("go");
			selImage = (selImage == 1)?2:1; // 삼항 연산자
			//x = x + 10;
			x = (x < getWidth())?x += 10:-image.getWidth(this);
		}
		
		repaint();   // paint() 호출
	}
	
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyTyped(KeyEvent e) { }
	
	public static void main(String[] args) {
		// 키보드 이벤트 연습
		new Ex50Packman();
	}
}
