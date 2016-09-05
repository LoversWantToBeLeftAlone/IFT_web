package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class connectToMySql{
  public ArrayList<Customer> consumerList = new ArrayList<Customer>();

	public  void readFromMySql() throws SQLException, ClassNotFoundException {// 读数据库存到链表中
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sshopping", "root", "");
		System.out.println("Database connected!");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from customer");
		while (resultSet.next()) {
			String name = resultSet.getString(1);
			String sex = resultSet.getString(2);
			String idnumber = resultSet.getString(3);
			String passwords = resultSet.getString(4);
			String address = resultSet.getString(5);
			int money = resultSet.getInt(6);
			Customer c = new Customer(name, sex, idnumber, passwords, address, money);
			consumerList.add(c);
		}
		connection.close();
	}
	public  int getListSize(){
		return this.consumerList.size();
	}
	public int getLevel(String name,String pwd) throws ClassNotFoundException, SQLException{
		readFromMySql();
		int level=0;
		for(int i=0;i<consumerList.size();i++){
			if(consumerList.get(i).getName().equals(name)&& consumerList.get(i).getPasswords().equals(pwd)){
				level=consumerList.get(i).getLevel();
			}
		}
		return level;
		
	}
	public  void writeMySql(Customer c) throws SQLException, ClassNotFoundException {// 往数据库写数据
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sshopping", "root", "");
		System.out.println("Database connected!");
		this.consumerList.add(c);
		PreparedStatement pstmtInsert = connection.prepareStatement(
				"insert into customer(cname,csex," + "cidNumber,cpasswords,caddress,cmoney) values(?,?,?,?,?,?)");
		pstmtInsert.setString(1, c.getName());
		pstmtInsert.setString(2, c.getSex());
		pstmtInsert.setString(3, c.getIdnumber());
		pstmtInsert.setString(4, c.getPasswords());
		pstmtInsert.setString(5, c.getAddr());
		pstmtInsert.setString(6, c.getMoney());
		pstmtInsert.executeUpdate();
		System.out.println("用户添加成功！");
	}

	public void delete(Customer c) throws SQLException, ClassNotFoundException {// 删除数据库里的一条数据
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sshopping", "root", "");
		System.out.println("Database connected!");
		if (consumerList.contains(c)) {
			consumerList.remove(c);
			PreparedStatement pstmtDelete = connection.prepareStatement("delete from customer where cname=?");
			pstmtDelete.setString(1, c.getName());
			pstmtDelete.executeUpdate();
		}
		if (!consumerList.contains(c))
			System.out.println("用户不存在！");
	}

	/*
	 * 修改函数存在一点问题，英影响不大。登录注册界面不用修改函数
	 */
	public void modify(Customer c, int index,ArrayList<Customer> consumerList) throws SQLException, ClassNotFoundException {// 修改数据库里的一条数据
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "");
		System.out.println("Database connected!");
		Customer c1 = new Customer();
		c1 = consumerList.get(index);
		PreparedStatement pstmtModify = connection.prepareStatement("update customer" + "set cname=?" + "set csex=?"
				+ "set cidNumber=?" + "set cpasswords=?" + "set caddress=?" + "set cmoney=?" + "  where cname=?");
		pstmtModify.setString(1, c.getName());
		pstmtModify.setString(2, c.getSex());
		pstmtModify.setString(3, c.getIdnumber());
		pstmtModify.setString(4, c.getPasswords());
		pstmtModify.setString(5, c.getAddr());
		pstmtModify.setString(6, c.getMoney());
		pstmtModify.setString(7, c1.getName());
		pstmtModify.executeBatch();
	}

	public  Customer getCustomer(String name) {
		Customer c = new Customer();
		for (int i = 0; i < consumerList.size(); i++) {
			if (consumerList.get(i).getName().equals(name)) {
				c.setCustomer(consumerList.get(i).getName(), consumerList.get(i).getLevel(),
						consumerList.get(i).getMoney());
			}
		}
		return c;
	}
	public  boolean search(String name,String pwd) throws ClassNotFoundException, SQLException {//通过姓名和密码查找数据库里的相应数据
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "");
		System.out.println("Database connected!");
		Statement statement = connection.createStatement();
		String passwords=null;
		ResultSet resultSet = statement.executeQuery("select * from customer where cname=name,cpasswords=pwd");
		while(resultSet.next())
			 passwords = resultSet.getString(4);
		if(pwd.equals(passwords))
			return true;
		else
			return false;
	}
	/*
	public Customer getCustomer(int index){
		Customer c=new Customer();
		c=new Customer(consumerList.get(index).getName(),consumerList.get(index).getPasswords(),
				consumerList.get(index).getIdnumber(),
				consumerList.get(index).getSex(),consumerList.get(index).getAddr(),
				consumerList.get(index).getMoney());
		return c;
	}
	*/
	public String getName(){
		return "sss";
	}

	@SuppressWarnings({ })
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connectToMySql database = new connectToMySql();
		database.consumerList.clear();
		database.readFromMySql();
		for (int i = 0; i <database.consumerList.size(); i++) {
			Customer c1 = database.consumerList.get(i);
			System.out.print(c1.getName() + "\t\t");
			System.out.print(c1.getPasswords() + "\t\t");
			System.out.print(c1.getAddr() + "\t\t");
			System.out.print(c1.getLevel() + "\t\t");
			System.out.println(c1.getMoney() + "\t\t");
		}
		System.out.println("链表长度为："+database.getListSize());
		String name="zpenGl";
		String pwd="nuoxia14";
		int level=database.getLevel(name, pwd);
		System.out.println(level);
		
		Customer c = new Customer("华翔", "男", "533522xxxxxxx1", "damei", "北京挖媒", 110000);
		database.writeMySql(c);
		for (int i = 0; i < database.consumerList.size(); i++) {
			Customer c1 = database.consumerList.get(i);
			System.out.print(c1.getName() + "\t\t");
			System.out.print(c1.getSex() + "\t\t");
			System.out.print(c1.getAddr() + "\t\t");
			System.out.print(c1.getLevel() + "\t\t");
			System.out.println(c1.getMoney() + "\t\t");
		}
		database.consumerList.clear();
		Customer c1 = new Customer();
		c1 = database.getCustomer("大美");
		System.out.print(c1.getName() + "\t\t");
		System.out.print(c1.getSex() + "\t\t");
		System.out.print(c1.getAddr() + "\t\t");
		System.out.print(c1.getLevel() + "\t\t");
		System.out.println(c1.getMoney() + "\t\t");
		
	}
}
