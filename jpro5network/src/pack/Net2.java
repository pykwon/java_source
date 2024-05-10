package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 제3삼자가 제공하는 라이브러리(jsoup.jar)를 사용해 웹 스크래밍
// HTML 문서 데이터 구문 분서, 추출 및 조작용 오픈 소스

public class Net2 {
	public static void main(String[] args) {
		// 위키백과 사이트에서 검색 결과 읽기
		//https://ko.wikipedia.org/wiki/백설공주
		try {
			// System.out.println(URLEncoder.encode("백설공주","UTF-8"));

			String url = "https://ko.wikipedia.org/wiki/" + URLEncoder.encode("대한민국","UTF-8");
			// Document : 웹페이지 문서
			Document doc = Jsoup.connect(url).get();
			String text = doc.text();
			//System.out.println(text);
			
			printKoreanText(text);  // 한글만 추출
		} catch (Exception e) {
			System.out.println("err : " + e.getMessage());
		}
	}
	
	private static void printKoreanText(String text) {
		// 정규 표현식 사용
		// 한글과 공백만 얻기
		Pattern pattern = Pattern.compile("[가-힣\\s]+");
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			String line = matcher.group().trim();
			if(!line.isEmpty()) {  // 빈 줄은 제외
				System.out.println(line);
			}
		}
	}
}



