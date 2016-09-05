package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean dengyu(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	protected int login(String name, String pwd) throws ClassNotFoundException, SQLException {
		int k = 0;
		connectToMySql sql = new connectToMySql();
		sql.readFromMySql();
		for (int i = 0; i < sql.consumerList.size(); i++) {
			System.out.println(i + " ---------------");
			System.out.println(name + ":" + pwd + ":" + sql.consumerList.get(i).getName() + ":"
					+ sql.consumerList.get(i).getName());
			if (sql.consumerList.get(i).getName().equals(name) && sql.consumerList.get(i).getPasswords().equals(pwd))
				k = 1;// 允许登录
			if (sql.consumerList.get(i).getName().equals(name) && !sql.consumerList.get(i).getPasswords().equals(pwd))
				k = 2;// 密码不正确
			if (!sql.consumerList.get(i).getName().equals(name) && sql.consumerList.get(i).getPasswords().equals(pwd))
				k = 3;// 用户名不正确
		}
		return k;// k=0,需要先注册
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("username");
		String pwd = request.getParameter("password");
		connectToMySql sql = new connectToMySql();
		String level = null;
		String jifeng = null;
		try {
			jifeng = Integer.toString(sql.getLevel(account, pwd) * 150);
			level = Integer.toString(sql.getLevel(account, pwd));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("username", account);
		httpsession.setAttribute("password", pwd);
		httpsession.setAttribute("level", level);
		httpsession.setAttribute("jifeng", jifeng);
		int flag = 0;
		try {
			flag = login(account, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (flag) {
		case (0): {// 注册
			 PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('there is no this user ');history.back();</script>");
		}
			;
			break;
		case (1): {// 登录
			RequestDispatcher dispatcher = request.getRequestDispatcher("用户首页.jsp");
			dispatcher.forward(request, response);
			PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('login success ');history.back();</script>");
		}
			;
			break;
		case (2): {// 密码不正确
			 PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('error passwords！ ');history.back();</script>");
		}
			;
			break;
		case (3): {// 用户名不正确
			 PrintWriter   out   =   response.getWriter(); 
	         out.println("<script>alert('error account');history.back();</script>");
		}
			;
			break;
		default:
			break;
		}
		/*
		 * try { sql.readFromMySql(); System.out.println("链表长度：" +
		 * sql.consumerList.size()); System.out.println("登录成功！" +
		 * sql.consumerList.get(4).getName());
		 * 
		 * for (int i = 0; i < sql.consumerList.size(); i++) {
		 * System.out.println("第" + i + "个顾客:" +
		 * sql.consumerList.get(i).getName()); System.out.println(account+":  "
		 * +pwd+":"+sql.consumerList.get(i).getPasswords()); if
		 * (account.equals(sql.consumerList.get(i).getName()) &&
		 * pwd.equals(sql.consumerList.get(i).getPasswords())) {
		 * System.out.println(sql.consumerList.get(i).getName() + ": " +
		 * account); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("用户首页.jsp"); dispatcher.forward(request,
		 * response); } } } catch (ClassNotFoundException | SQLException e) { //
		 * TODO Auto-generated catch block System.out.println("数据库连接失败！");
		 * e.printStackTrace(); }
		 */
	}
}
