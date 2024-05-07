package pack;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.*;

public class DbTest6Ex1 extends JFrame implements ActionListener {
	JTextField code = new JTextField("", 5);
	JTextField name = new JTextField("", 10);
	JTextField cnt = new JTextField("", 5);
	JTextField price = new JTextField("", 5);
	JButton plus = new JButton("추가");
	JTextArea result = new JTextArea();
	String sql = "";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DbTest6Ex1() {
		super("상품추가 연습문제");

		accDb();
		layInit();

		setBounds(200, 200, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("코드 : "));
		panel1.add(code);
		panel1.add(new JLabel("품명 : "));
		panel1.add(name);
		panel1.add(new JLabel("수량 : "));
		panel1.add(cnt);
		panel1.add(new JLabel("단가 : "));
		panel1.add(price);
		panel1.add(plus);
		add("North", panel1);

		result.setEditable(false);
		JScrollPane pane = new JScrollPane(result);
		add(pane);

		plus.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			String co = code.getText();
			String na = name.getText();
			String cn = cnt.getText();
			String pr = price.getText();

			sql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, co);
			pstmt.setString(2, na);
			pstmt.setString(3, cn);
			pstmt.setString(4, pr);
			pstmt.executeUpdate();

			display();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "코드가 중복되었거나 입력되지 않았습니다.");
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			display();
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
	}


	private void display() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			DecimalFormat df = new DecimalFormat("#,##0");
			int count = 0;
			result.setText("코드  \t 상품명  \t 수량  \t 단가  \t 금액  \n");
			while (rs.next()) {
				result.append(rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + 
						"\t" + rs.getString("dan") + "\t" + df.format(rs.getInt("su") * rs.getInt("dan")) + "\n");
				count++;
			}
			result.append("건수 : " + count);
		} catch (Exception e) {
			System.out.println("display() error : " + e);
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new DbTest6Ex1();
	}
}
