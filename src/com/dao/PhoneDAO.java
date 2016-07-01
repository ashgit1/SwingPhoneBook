package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.vo.Phone;

public class PhoneDAO {

	public static final PhoneDAO phoneDAO = new PhoneDAO();

	public PhoneDAO() {
	}

	public static void Save(Connection Conn, Phone ph) {

		try {
			Statement stmt = Conn.createStatement();

			String query = "INSERT INTO PHONE VALUES ('" + ph.getNo() + "','"
					+ ph.getOwner() + "'," + ph.getAmt() + ",'" + ph.getDate()
					+ "','" + ph.getAge() + "','" + ph.getNrc() + "','"
					+ ph.getJob() + "','" + ph.getAddr() + "')";
			int result = stmt.executeUpdate(query);

			if (result == 1) {
				JOptionPane.showMessageDialog(null,
						" \n Contact Saved Successfully  \n");
			}
		} catch (SQLException sqlx) {
			JOptionPane.showMessageDialog(null,
					" \n SQLException \n " + sqlx.getMessage() + "\n");
		}
	}

	public static void Delete(Connection Conn, Phone ph) {
		String phNo = ph.getNo();
		try {
			ph = new Phone();
			Statement stmt = Conn.createStatement();
			String query = "DELETE FROM PHONE WHERE phNo = '" + phNo + "' ";
			int result = stmt.executeUpdate(query);
			if(result!=0){
				JOptionPane.showMessageDialog(null, "\n  Contact Deleted Successfully \n");
			}
			stmt.close();
		} catch (SQLException sqlx) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n "
					+ sqlx.getMessage() + "\n");
		}
	}

	public static void Update(Connection Conn, Phone ph) {
		String phNo = ph.getNo();
		try {
			Statement stmt = Conn.createStatement();
			String query = "UPDATE PHONE SET " + " phNo ='" + ph.getNo()
					+ "', " + " ownerName ='" + ph.getOwner() + "', "
					+ " phAmt =" + ph.getAmt() + ", " + " dt ='" + ph.getDate()
					+ "', " + " ownerAge ='" + ph.getAge() + "', "
					+ " ownerNRC ='" + ph.getNrc() + "', " + " ownerJob ='"
					+ ph.getJob() + "', " + " ownerAddr ='" + ph.getAddr()
					+ "'" + " WHERE phNo = '" + phNo + "'";
			int result = stmt.executeUpdate(query);
			if(result!=0){
				JOptionPane.showMessageDialog(null, "\n  Contact Updated Successfully \n");
			}
			stmt.close();
		} catch (SQLException sqlx) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n "
					+ sqlx.getMessage() + "\n");
		}
	}

	public static Phone GetPhone(Connection Conn, Phone ph) {
		String phNo = ph.getNo();
		try {
			Statement stmt = Conn.createStatement();
			String query = "SELECT * FROM PHONE WHERE phNo='" + phNo + "' ";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ph = new Phone();
				ph.setNo(rs.getString(1));
				ph.setOwner(rs.getString(2));
				ph.setAmt(rs.getString(3));
				ph.setDate(rs.getString(4));
				ph.setAge(rs.getString(5));
				ph.setNrc(rs.getString(6));
				ph.setJob(rs.getString(7));
				ph.setAddr(rs.getString(8));
			}
		} catch (SQLException sqlx) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n "
					+ sqlx.getMessage() + "\n");
		}
		return ph;
	}

	/**
	 * @return the phoneDAO
	 */
	public static PhoneDAO getPhoneDAO() {
		return phoneDAO;
	}
}