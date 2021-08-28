package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB������ ���� �ε�, ����, �ݱ�
 */
public class DBUtil {
	public static void main(String[] args) {
	    try {
		    Connection con = getConnection();
		    System.out.println("���� �Ϸ� = " + con);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    }
	
	private static Properties proFile = new Properties();
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * �ε�
	 */
	static {
		try {
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			//proFile.load(new FileInputStream("resources/sql.properties"));
			proFile.load(new FileInputStream("resources/cart_sql.properties"));
			proFile.load(new FileInputStream("resources/coupon_sql.properties"));
			proFile.load(new FileInputStream("resources/customer_sql.properties"));
			proFile.load(new FileInputStream("resources/liquor_sql.properties"));
			proFile.load(new FileInputStream("resources/order_sql.properties"));
			proFile.load(new FileInputStream("resources/review_sql.properties"));
		
			Class.forName(proFile.getProperty("driverName")); // ����Ŭ ����̹��� ã�´�.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"), proFile.getProperty("userPass"));
	}

	/**
	 * �ݱ�(select�� ���)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)	rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �ݱ�(DML, DDL�� ���)
	 */
	public static void dbClose(Connection con, Statement st) {

		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
