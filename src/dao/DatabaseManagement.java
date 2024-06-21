package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseManagement {
	static Connection con = null;

	public static Connection getConnection() throws SQLException {
	    try {
	        if (con == null || con.isClosed()) {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "Shiv@1309");
	        }
	    } catch (ClassNotFoundException e) {
	        JOptionPane.showMessageDialog(null, "MySQL JDBC driver not found");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error connecting to the database");
	        e.printStackTrace();
	    }
	    return con;
	}


	public ResultSet check(String user, String pin) throws SQLException {
		String str = "SELECT * FROM Customers WHERE CardNumber = '" + user + "' AND Pin = '" + pin + "'";
		Statement stm = null;
		ResultSet rst = null;
		try {
			stm = getConnection().createStatement();
			rst = stm.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rst;
	}

	public void deposit(int amount, int id) throws SQLException {
		Statement stm = null;
		Statement stm2 = null;
		try {
			String str = "UPDATE Customers SET Balance = Balance + " + amount + " WHERE ID = " + id;
			stm = getConnection().createStatement();
			stm.executeUpdate(str);
			int balance = balCheck(id);
			str = "INSERT INTO Passbook (ID, Amount, state, Balance) VALUES(" + id + ", " + amount + ", 'Deposit', " + balance
					+ ")";
			stm2 = getConnection().createStatement();
			stm2.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Money Deposited Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public int withdraw(int amount, int id) throws SQLException {
		int balance = balCheck(id);
		if (balance >= amount) {
			Statement stm = null;
			Statement stm2 = null;
			try {
				String str = "UPDATE Customers SET Balance = Balance - " + amount + " WHERE ID = " + id;
				stm = getConnection().createStatement();
				stm.executeUpdate(str);
				balance -= amount;
				str = "INSERT INTO Passbook (ID, Amount, state, Balance) VALUES(" + id + ", " + amount + ", 'Withdrawl', "
						+ balance + ")";
				stm2 = getConnection().createStatement();
				stm2.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Cash Withdrawl Successfully");
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return 0;
	}

	public void pinchange(String pin, int id) throws SQLException {
		Statement stm = null;
		try {
			String str = "UPDATE Customers SET Pin = '" + pin + "' WHERE ID = " + id;
			stm = getConnection().createStatement();
			stm.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int balCheck(int id) throws SQLException {
		Statement stm = null;
		ResultSet rst = null;
		try {
			String str = "SELECT Balance FROM Customers WHERE ID = " + id;
			stm = getConnection().createStatement();
			rst = stm.executeQuery(str);
			rst.next();
			return rst.getInt("Balance");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}

	public ResultSet stmt(int id) throws SQLException {
		Statement stm = null;
		ResultSet rst = null;
		try {
			String str = "SELECT * FROM Passbook WHERE ID = " + id + " ORDER BY TransID DESC";
			stm = getConnection().createStatement();
			rst = stm.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}

	public void adding(String card, String pin, String name, String balance) throws SQLException {
		Statement stm = null;
		try {
			String str = "INSERT INTO Customers (CardNumber, Pin, UserName, Balance) VALUES ('" + card + "', '" + pin + "', '"
					+ name + "', " + balance + ")";
			stm = getConnection().createStatement();
			stm.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "User Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	
}
