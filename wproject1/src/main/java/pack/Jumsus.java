package pack;

public class Jumsus {
	private String bunho;
	private String irum;
	private int kor;
	private int eng;
	
	public Jumsus(String bunho,String irum,int kor, int eng) {
		this.bunho=bunho;
		this.irum=irum;
		this.kor=kor;
		this.eng=eng;
	}
	
	public String getBunho() {
		return bunho;
	}
	public String getIrum() {
		return irum;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
}

