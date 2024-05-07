package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DbTest2Ex {
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

	public DbTest2Ex() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		try {
			String url = "jdbc:mariadb://192.168.0.22:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e);
			return;
		}

		try {
			// 키보드로 부서번호를 입력받아 해당 부서에 근무하는 직원자료 출력
			// 부서번호 : 10
			// 사번 이름 부서 직급 연봉
			Scanner sc = new Scanner(System.in);
			System.out.print("부서번호 입력(10, 20, 30, 40) : ");
			int num = sc.nextInt();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(
					"SELECT jikwon_no as 사번, jikwon_name as 이름, buser_name as 부서, jikwon_jik as 직급, jikwon_pay as 연봉 FROM jikwon\r\n"
							+ "INNER JOIN buser ON jikwon.buser_num = buser.buser_no\r\n WHERE buser_num = " + num);

			System.out.println("사번 이름 부서 직급 연봉");
			while (rs.next()) {
				int jikwon_no = rs.getInt("사번");
				String jikwon_name = rs.getString("이름");
				String buser_name = rs.getString("부서");
				String jikwon_jik = rs.getString("직급");
				int jikwon_pay = rs.getInt("연봉");
				System.out.println(
						jikwon_no + " " + jikwon_name + " " + buser_name + " " + jikwon_jik + " " + jikwon_pay);
			}

			String sql = "select count(*) as 건수 from jikwon where buser_num = " + num;
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getString("건수"));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		new DbTest2Ex();
	}
}
