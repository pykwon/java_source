package pack5io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex34IoTest {
	public static void main(String[] args) throws Exception{
		// Console과 file을 통한 입력
		// 1. Console을 통한 입력
		/*
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.print("이름은");
		String ir = br.readLine();
		System.out.println("이름은 " + ir);
		br.close();
		in.close();
		*/
		
		// 2. Scanner를 통한 입력
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름은");
		String ir = scanner.nextLine();
		System.out.print("몸무게는");
		double w = scanner.nextDouble();
		System.out.println(ir + "님의 몸무게는 " + w);
		scanner.close();
		*/
		
		// 파일 읽기
		//File f = new File("c:/work/good.txt");
		File f = new File("c:\\work\\good.txt");  
		// 문자 단위
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		//System.out.println(br.readLine());
		while(true) {
			String ss = br.readLine();
			if(ss == null) break;
			System.out.println(ss);
		}
		br.close();   // Garbage collector(GC)오 하여금 점유 메모리 해제 요청
		fr.close();
		
		System.out.println("전국 도서관 정보 파일 일부 읽기 --------");
		File file = new File("c:/work/전국도서관표준데이터.csv");
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);
		int count = 0;
		String ss = br2.readLine();
		while(true) {
			count++;
			ss = br2.readLine();
			if(ss == null || count > 10) break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();
			
			System.out.println(s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);
		}
		System.out.println("건수 : " + count);
	}

}



