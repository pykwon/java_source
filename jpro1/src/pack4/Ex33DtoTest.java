package pack4;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex33DtoTest {
	private ArrayList<Ex33DonDto> list = new ArrayList<Ex33DonDto>();
	
	public void inputData(String[] datas) {
		for(String s:datas) {
			StringTokenizer st = new StringTokenizer(s,",");
			int sabun = Integer.valueOf(st.nextToken());
			String name = st.nextToken();
			int gibon = Integer.valueOf(st.nextToken());
			int ipsa = Integer.valueOf(st.nextToken());
			Ex33DonDto dto = new Ex33DonDto(sabun, name, gibon, ipsa);
			list.add(dto);
		}
	}
	
	public void showData() {
		int sudang, year, gong;
		double seyul;
		System.out.println("사번 이름\t기본급  년수 근속수당   공제액    수령액");
		for(Ex33DonDto don:list) {
			year = 2007 - don.getIpsa();
			if(year<3) 
				sudang = 150000;
			else if(year<8)
				sudang = 450000;
			else
				sudang = 1000000;
			
			gong = don.getGibon()+sudang;
			
			if(gong<2000000)
				seyul = 0.15;
			else if(gong<3000000)
				seyul = 0.3;
			else
				seyul = 0.5;
			
			
			System.out.println(don.getSabun() + " " + don.getName() + " " + don.getGibon()
			+ " " + year + " " + sudang + " " + gong + " " + gong*(1-seyul));			
		}
		System.out.printf("처리 건수 %d건", list.size());
	}
	
	public static void main(String[] args) {
		String[] datas = new String[2];
		datas[0] = "1,강나루,1500000,2005";
		datas[1] = "2,루나강,3000000,2000";
		
		Ex33DtoTest test = new Ex33DtoTest();
		test.inputData(datas);
		test.showData();	
	}

}
