package dao;

import java.sql.*;
import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
		try {

			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM login_info WHERE USER_NAME = '" + userDetails.getUserName()
					+ "' AND PASSWORD = '" + userDetails.getPassword() + "'");
			while (rs.next()) {
				validStatus = true;
			}
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			System.out.println("Erro contato com banco de dados");
			e.printStackTrace();
		}
		return validStatus;
	}

}
