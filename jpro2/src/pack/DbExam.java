package pack;

import java.sql.*;
import java.util.Scanner;

public class DbExam {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public DbExam() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		
			String url = "jdbc:mariadb://192.168.0.22:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		    
			Scanner sc = new Scanner(System.in);
			System.out.print("부서명:");
			String buname = sc.next();
			
			String sql = "select jikwon_no,jikwon_name,jikwon_jik,jikwon_gen from jikwon " +
						 "inner join buser on buser_no=buser_num " +
					     "where buser_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buname);
			rs = pstmt.executeQuery();

			System.out.println("사번 이름 부서 직급 연봉");
			int countM = 0, countF = 0;
			while (rs.next()) {
				System.out.println(
					rs.getString("jikwon_no") + " " + 
					rs.getString("jikwon_name") + " " + 
					rs.getString("jikwon_jik") + " " + 
					rs.getString("jikwon_gen"));
				
				if(rs.getString("jikwon_gen").equals("남"))
					countM++;
				else
					countF++;
			}
			System.out.println("인원수는 남직원:" + countM + "명, 여직원:" + countF + "명");
			
			sql = "select jikwon_gen, avg(jikwon_pay) from jikwon " + 
					"inner join buser on buser_no=buser_num where buser_name=? " + 
					"group by jikwon_gen";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buname);
			rs = pstmt.executeQuery();
			int payM = 0, payF = 0;
			while (rs.next()) {
				if(rs.getString(1).equals("남")) 
					payM = rs.getInt(2);
				else if(rs.getString(1).equals("여"))
					payF = rs.getInt(2);
			}
			System.out.println("연봉 평균은 남직원:" + payM + ", 여직원:" + payF);
			
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public static void main(String[] args) {
		new DbExam();
	}
}
