package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class DbTest6Ex3 extends JFrame implements ActionListener {
	JTextField txtNo = new JTextField("", 5);
	JTextField txtName = new JTextField("", 10);
	JButton btLogIn = new JButton("로그인");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DbTest6Ex3() {
		super("Employee Management");

		initLayout();
		accDb();

		setBounds(200, 200, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initLayout() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("직원번호"));
		panel1.add(txtNo);
		panel1.add(new JLabel("직원이름"));
		panel1.add(txtName);
		panel1.add(btLogIn);
		add("North", panel1);

		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtResult);
		add("Center", pane);

		btLogIn.addActionListener(this);

	}

	// 드라이버 로딩
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
	}

	// DB랑 연결하기
	private void connectDB() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("connectDB err : " + e);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			connectDB();

			String sql = "select jikwon_name from jikwon where jikwon_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtNo.getText());

			// 입력자 오류 검사
			try {
				// 직원번호 숫자 여부
				int a = Integer.parseInt(txtNo.getText());
				// 1~30 외 숫자 에러 처리
				if (a < 1 || a > 30) {
					throw new Exception();
				}
			} catch (Exception e2) {
				txtResult.setText(null);
				JOptionPane.showMessageDialog(this, "직원번호는 1~30 사이 정수만 입력 가능");
			}

			rs = pstmt.executeQuery();
			rs.next();

			// 직원번호와 직원이름 일치하는지 - if else
			boolean b = rs.getString("jikwon_name").equals(txtName.getText());
			if (b) {
				// 직원 전체 출력
				txtResult.setText("사번\t이름\t연봉\t직급\t등급\n");
				String sql2 = "select * from jikwon";
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				String temp = "";
				while (rs.next()) {
					temp = rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
							+ rs.getString("jikwon_pay") + "\t" + rs.getString("jikwon_jik") + "\t"
							+ rs.getString("jikwon_rating") + "\n";
					txtResult.append(temp);
				}

				// 직급별 평균 연봉 출력
				temp = "\n\t----직급별 평균 연봉 (만원)-----\n\n";
				txtResult.append(temp);
				sql = "select jikwon_jik, round(avg(jikwon_pay)) from jikwon group by jikwon_jik";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					temp = rs.getString("jikwon_jik") + " : " + rs.getString("round(avg(jikwon_pay))") + "\t";
					txtResult.append(temp);
				}
			} else {
				txtResult.setText(null);
				JOptionPane.showMessageDialog(this, "로그인 정보 불일치");

			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e2);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e3) {
			}
		}
	}

	public static void main(String[] args) {
		new DbTest6Ex3();
	}
}
