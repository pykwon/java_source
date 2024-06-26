package pack6thread;

public class Ex37Thread1 extends Thread{
	public Ex37Thread1() {
		// TODO Auto-generated constructor stub
	}
	
	public Ex37Thread1(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=1; i <= 50; i++) {
			//System.out.print(i + " ");
			System.out.print(i + ":" + super.getName() + " ");
		}
	}
	
	public static void main(String[] args) {
		// Thread
		// 하나의 응용 프로그램은 운영체제에 의해 process(작업단위)를 확보하고
		// 응용 프로그램의 실행은 threead(실행 단위)가 담당한다.
		// 기본적으로 main thread에 의해 응용 프로그램은 실행된다.
		// thread의 갯수 만큼 실행 단위를 늘릴수 있다. 
		// 즉 multi thread에 의한 multi tasking이 가능하다.
		// 주로 네트워크 작업에서 많이 활용된다.
		// 자바에서 실행 파일 직접 실행
		try {
			//process 단위의 실행
			//Process p1 = Runtime.getRuntime().exec("calc.exe");
			
			//Thread를 사용한 특정 메소드(run) 실행
			//Thread를 사용하지 않은 경우 : 순차적으로 실행
			/*
			Ex37Thread1 th1 = new Ex37Thread1();
			th1.run();
			
			Ex37Thread1 th2 = new Ex37Thread1();
			th2.run();
			*/
			
			//사용자 정의 Thread를 사용한 경우 : 랜덤하게 실행
			//Ex37Thread1 th1 = new Ex37Thread1();
			Ex37Thread1 th1 = new Ex37Thread1("one");
			th1.start();
			//Ex37Thread1 th2 = new Ex37Thread1();
			Ex37Thread1 th2 = new Ex37Thread1("two");
			th2.start();
			
			// MAX_PRIORITY = 10 // 최대 우선 순위
			// MIN_PRIORITY = 1  // 최소 우선 순위
			th2.setPriority(MAX_PRIORITY);  // 스레드 스케쥴러에게 우선 순위 요청
			
			th1.join();   // th1 스레드가 종료될 때까지 main 스레드 종료를 대기 
			//th2.join();
			
			th1.yield();  // 다른 스레드의 수행 요청이 들어오면 현재 스레드의 수해을 일시정지
			
			System.out.println();
			System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
		
	}
}
