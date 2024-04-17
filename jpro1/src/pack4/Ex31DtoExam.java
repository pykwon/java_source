package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31DtoExam {
	private ArrayList<Ex31StudDto> list = new ArrayList<Ex31StudDto>();

	public void insertList() {
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("이름:");
				String name = scanner.next();
				System.out.print("국어:");
				int kor = scanner.nextInt();
				System.out.print("영어:");
				int eng = scanner.nextInt();
				
				Ex31StudDto dto = new Ex31StudDto();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				list.add(dto);
				
				System.out.print("계속할까요?(y/n)");
				if(scanner.next().equalsIgnoreCase("n")) break;
			} catch (Exception e) {
				System.out.println("처리 중 오류 발생 : " + e);
				break;
			}
		}
	}
	public void showList() {
		System.out.println("이름\t국어\t영어\t총점");
		for(Ex31StudDto my:list) {
			int tot = my.getKor() + my.getEng();
			System.out.println(my.getName() + "\t" + 
						my.getKor() + "\t" + 
						my.getEng() + "\t" + tot);
		}
		System.out.println("응시 인원 : " + list.size() + "명");
	}
	
	public static void main(String[] args) {
		Ex31DtoExam dtoExam = new Ex31DtoExam();
		dtoExam.insertList();
		dtoExam.showList();
	}
}


