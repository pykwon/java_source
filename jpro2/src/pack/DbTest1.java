package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// MariaDB(원격 DB 서버) 연동 프로그래밍
public class DbTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public DbTest1() { 
		// 1. Driver file loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// 
			// 
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		// 2. DB server와 연결
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		// 3. 연결된 DB server에 SQL 실행
		try {
			// sangdata 테이블 자료 읽기
			stmt = conn.createStatement();
			
			//rs = stmt.executeQuery("select * from sangdata");
			rs = stmt.executeQuery("select code,sang,su,dan from sangdata");
			//System.out.println(rs.next());  // cursor (레코드 포인터) 이동
			//System.out.println(rs.getString("sang"));
			
			while(rs.next()) {
				String code = rs.getString("code");
				String sangname = rs.getString("sang");
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + 
						" " + su + " " + dan );
			}
			
			System.out.println("------");
			rs.close();  // ResultSet을 닫고, 아래에서 다시 열기
			
			rs = stmt.executeQuery("select code as 코드,sang as 상품명,su,dan from sangdata");
			while(rs.next()) {
				String code = rs.getString("코드");
				String sangname = rs.getString(2);  // 컬럼은 순서가 1부터 부여됨
				int su = rs.getInt(3);
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + 
						" " + su + " " + dan );
			}
			
			//String sql = "select count(*) as 건수 from sangdata";
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			//System.out.println("건수 : " + rs.getString("건수"));
			//System.out.println("건수 : " + rs.getString("count(*)"));
			System.out.println("건수 : " + rs.getString(1));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		new DbTest1();
	}
}
