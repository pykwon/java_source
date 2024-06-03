package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) return;
		
		ArrayList<Jumsus> jlist = (ArrayList<Jumsus>)session.getAttribute("list");
		if(jlist == null) return;
		
		session.removeAttribute("list");//해당 고객의 세션 삭제
		response.sendRedirect("myjumsu.html");  // myjumsu로 돌아가~
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String bunho = request.getParameter("bunho");
		String irum = request.getParameter("irum");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		
		//System.out.println(bunho+" " + irum + " "+ kor+ " " + eng);
		HttpSession session = request.getSession(true); 
		
		ArrayList<Jumsus> jlist = (ArrayList<Jumsus>)session.getAttribute("list");
		
		if(jlist == null) jlist = new ArrayList<Jumsus>();
		
		for(int i = 0; i<jlist.size(); i++) {
			Jumsus jumsu = (Jumsus)jlist.get(i);
			
			if(bunho.equals(jumsu.getBunho())) { // 번호 중복 체크
				out.println("중복되었습니다");
				response.sendRedirect("myjumsu.html"); // myjumsu로 돌아가
				return;
			}
		}
		
		jlist.add(new Jumsus(bunho, irum, kor, eng));
		session.setAttribute("list", jlist);
		
		out.println("<html><body>");
		out.println("<br> 학생들 성적표");
		out.println("<br><table>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		
		int count = 0;
		for(int i =0; i<jlist.size(); i++) {
			Jumsus jumsu =(Jumsus)jlist.get(i);
			
			out.println("<tr><td>" + jumsu.getBunho() + "</td>");
			out.println("<td>" + jumsu.getIrum() + "</td>");
			out.println("<td>" + jumsu.getKor() + "</td>");
			out.println("<td>" + jumsu.getEng() + "</td>");
			out.println("<td>" + (jumsu.getKor()+jumsu.getEng()) + "</td></tr>");
			
			count++;
		}
		
		
	out.println("</table>");
	out.println("<br>인원수:" + count);
	out.println("<br>[<a href='myjumsu.html'>새로 입력</a>] ");
	out.println("[<a href='Report'>세션 삭제</a>]<br>");
	out.println("</body></html>");
	out.close();
}

}
