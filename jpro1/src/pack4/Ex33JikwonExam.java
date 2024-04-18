package pack4;

import java.util.ArrayList;

public class Ex33JikwonExam {
	private ArrayList<Ex33JikwonDto> list = new ArrayList<Ex33JikwonDto>();
	
	public void inputData(String[] datas) {
		
	}
	
	public void displayData() {
		
	}
	
	public static void main(String[] args) {
		Ex33JikwonExam exam = new Ex33JikwonExam();
		String[] datas = new String[3];
		datas[0] = "1,신선해,1500000,2020";
		datas[1] = "2,신기해,1800000,2022";
		datas[2] = "3,신기루,2500000,2015";
		exam.inputData(datas);
	}
}
