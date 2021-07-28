package dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
			System.out.println("Conectou");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro Conexao");
		}
		return conn;

	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Desconectou");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
