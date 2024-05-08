package lambda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyLambda5Db {
	
	public MyLambda5Db() {
		// Consumer 인터페이스는 accept()를 갖고 있다.
		// 주로 Collection API의 forEach에서 주로 사용
		abc();
		
		System.out.println();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Driver loading fail : " + e);
			return;
		}
		
		queryTable("select * from sangdata", rs -> {
			System.out.println("처리2");
			try {
				while(rs.next()) {
					System.out.println(rs.getString("code") + " " + 
							rs.getString("sang") + " " +
							rs.getString("su") + " " +
							rs.getString("dan"));
				}
			} catch (Exception e) {
				System.out.println("err : " + e);
			}
		});
	}
	
	private void abc() {
		Consumer<Integer> printInt = i -> System.out.println(i);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		numbers.forEach(printInt);
	}
	
	private void queryTable(String sql, Consumer<ResultSet> consumer) {
		// try 문에 매개변수를 줄 수 있다.  try with resources 문법에 준함 
		try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			System.out.println("처리1");
			consumer.accept(rs);
			System.out.println("처리3");
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("queryTable err : " + e);
		}
	}
	
	public static void main(String[] args) {
		new MyLambda5Db();
	}

}








