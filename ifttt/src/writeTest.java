import java.sql.*;

public class writeTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "");
		System.out.println("Database connected!");
		PreparedStatement pstmtModify = connection.prepareStatement("update customer "
				+ "set cname=?,"
				+ "set csex=?,"
				+ "set cidNumber=?,"
				+ "set cpasswords=?,"
				+ "set caddress=?, "
				+ "set cmoney=?  "
				+ "where cname=?");
		pstmtModify.setString(1,"Ç¿¸ç");
		pstmtModify.setString(2,"Å®");
		pstmtModify.setString(3,"22222");
		pstmtModify.setString(4,"sdsds");
		pstmtModify.setString(5,"dsdsds");
		pstmtModify.setLong(6,0);
		pstmtModify.setString(7," ");
		pstmtModify.executeBatch();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select *from customer");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(7));
		}
	}
}
