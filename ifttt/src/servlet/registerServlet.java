package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int register(String name) throws ClassNotFoundException, SQLException {
		int k = 1;
		connectToMySql sql = new connectToMySql();
		sql.readFromMySql();
		for (int i = 0; i < sql.consumerList.size(); i++) {
			System.out.println(i + " ---------------");
			System.out.println(name + ":" + sql.consumerList.get(i).getName());
			if (sql.consumerList.get(i).getName().equals(name))
				k = 0;// 代表账号以及存在，不能再注册
		}
		return k;// k=1表示可以注册
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String idnumber = request.getParameter("idnumber");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String pwd1 = request.getParameter("pwd1");
		String money = request.getParameter("money");
		int money1 = Integer.parseInt(money);
		String tip = null;
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("username", account);
		httpsession.setAttribute("passwords", pwd);
		httpsession.setAttribute("idnumber", idnumber);
		httpsession.setAttribute("sex", sex);
		httpsession.setAttribute("address", address);
		httpsession.setAttribute("money", money);
		httpsession.setAttribute("pwd1", pwd1);
		httpsession.setAttribute("tips", tip);
	    Customer c = new Customer(account, sex, idnumber, pwd, address,money1);
		int flag = 0;
		if (!pwd.equals(pwd1)) {
			System.out.println("前后密码不一致！");
			 PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('Inconsistent passwords');history.back();</script>");
		} else if(pwd.equals(pwd1)) {
			// Customer c = new Customer(account, sex, idnumber, pwd, address,
			// money1);
			try {
				flag = register(account);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch(flag){
		case(0):{
			 PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('Account already exists ');history.back();</script>");
		};break;
		case(1):{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Driver loaded");
			Connection connection = null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sshopping", "root", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Database connected!");
			PreparedStatement pstmtInsert = null;
			try {
				pstmtInsert = connection.prepareStatement(
						"insert into customer(cname,csex,cidNumber,cpasswords,caddress,cmoney) values(?,?,?,?,?,?)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			pstmtInsert.setString(1,c.getName() );
			pstmtInsert.setString(2, c.getSex());
			pstmtInsert.setString(3, c.getIdnumber());
			pstmtInsert.setString(4, c.getPasswords());
			pstmtInsert.setString(5,c.getAddr());
			pstmtInsert.setString(6,c.getMoney());
			pstmtInsert.executeUpdate();
			System.out.println("用户添加成功！");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			PrintWriter   out   =   response.getWriter(); 
	        out.println("<script>alert('Registered success! ');history.back();</script>");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("登录界面.jsp");
//			dispatcher.forward(request, response);
		};break;
		default:break;
		}
	}
}
