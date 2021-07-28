package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import dbutil.DBUtil;
import pojo.Exame;

public class ExamesDAO {

	public static List<Exame> getAllExame() {
		List<Exame> exameList = new ArrayList<Exame>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM exames ORDER BY ex_pac,ex_Nome ASC");
			while (rs.next()) {
				Exame exame = new Exame(rs.getInt("ex_Id"),rs.getString("ex_Pac"), rs.getString("ex_Nome"), rs.getDate("ex_Data"),
						rs.getString("ex_ObsRes"));
				exameList.add(exame);
			}
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exameList;
	}

	public static boolean testaExameNomeDuplicado(Exame exame) {
		boolean test = false;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT ex_id FROM exames WHERE ex_pac = ?");
			ps.setString(1, exame.getExamePac());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	public static boolean testaExameNomeDuplicadoEdicao(Exame exame) {
		boolean test = false;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT ex_id FROM exames WHERE ex_pac = ? AND ex_id != ?");
			ps.setString(1, exame.getExamePac());
			ps.setInt(2, exame.getExameId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	public static int addExame(Exame exame) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO exames VALUES(ex_seq.NEXTVAL,?,?,?,?)");
			ps.setString(1, exame.getExamePac());
			ps.setString(2, exame.getExameNome());
			ps.setDate(3, exame.getExameData());
			ps.setString(4, exame.getExameObsRes());
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Exame getExameById(Integer exameId) {
		Exame exame = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM exames WHERE ex_Id =?");
			ps.setInt(1, exameId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				exame = new Exame(rs.getInt("ex_Id"), rs.getString("ex_Pac"), rs.getString("ex_Nome"), rs.getDate("ex_Data"),
						rs.getString("ex_ObsRes"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exame;
	}

	public static int atualizarExame(Exame exame) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE exames SET ex_Pac=?,ex_Nome=?,ex_Data=?,ex_ObsRes=? WHERE ex_Id=?");
			ps.setString(1, exame.getExamePac());
			ps.setString(2, exame.getExameNome());
			ps.setDate(3, exame.getExameData());
			ps.setString(4, exame.getExameObsRes());
			ps.setInt(5, exame.getExameId());
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteExame(String examePac) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM exames WHERE ex_Pac= ?");
			ps.setString(1, examePac);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}