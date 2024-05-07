package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest2CRUD {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private Properties prop = new Properties();
	
	public DbTest2CRUD() { // secure coding의 하나로 연결정보 별도 저장 후 읽기
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\dbtest2.properties"));
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("passwd"));
			
			stmt = conn.createStatement();
			
			String sql = "";
			
			// 자료 추가
			// auto commit이 기본
			//sql = "insert into sangdata values(5,'새우깡',55,3000)";
			//stmt.executeUpdate(sql);  // insert, update, delete
			
			/*
			// auto commit을 수동으로 전환해 작업 : Transaction 처리가 필요
			conn.setAutoCommit(false);  // 수동
			sql = "insert into sangdata values(6,'감자깡',7,3000)";
			stmt.executeUpdate(sql);    // Transaction 시작
			sql = "insert into sangdata values(7,'gokuma깡',17,2000)";
			stmt.executeUpdate(sql);
			//conn.rollback();  // Transaction 끝 - 클라이언트에서 입력한 자료 취소
			conn.commit();  // Transaction 끝 - 클라이언트에서 입력한 자료 원격 DB에 저장
			conn.setAutoCommit(true);   // 자동으로 전환
			*/
			
			// 자료 수정
			//sql = "update sangdata set sang='데일리 콤부차',su=12,dan=8000 where code=5";
			//stmt.executeUpdate(sql); 
			
			// 자료 삭제
			sql = "delete from sangdata where code >= 5";
			//stmt.executeUpdate(sql);
			// insert, update, delete는 수행 후 처리 수 만큼 행의 갯수를 반환
			int result = stmt.executeUpdate(sql);
			System.out.println("result : " + result);
			if(result == 0) System.out.println("삭제 실패 !!!");
			
			// 모든 자료 읽기
			sql = "select * from sangdata order by code desc";
			rs = stmt.executeQuery(sql);  // select
			int cou = 0;
			while(rs.next()) {
				System.out.println(rs.getString("code") + " " + 
						rs.getString("sang") + " " +
						rs.getString("su") + " " +
						rs.getString("dan"));
				cou++;
			}
			
			System.out.println("전체 자료 수 : " + cou);
			
			// 부분 자료 읽기
			sql = "select * from sangdata where code=1";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getString("code") + " " + 
						rs.getString("sang") + " " +
						rs.getString("su") + " " +
						rs.getString("dan"));
			}else {
				System.out.println("해당 자료는 없어요");
			}
			
		} catch (Exception e) {
			System.out.println("err : " + e);
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
		new DbTest2CRUD();
	}

}
