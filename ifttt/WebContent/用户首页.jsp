

<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>用户主页</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
</head>

<body style="background: url('picture/bgc.png') repeat;">

	<%-- 	<%=ID%>--%>

	<table width="732" height="459" border="2" summary="没错，只是首页，没有任何其他的功能">
		<caption>用户首页</caption>
		<tr>
			<td height="28" colspan="2"><div align="right">
					<a href="#">首页 任务管理 新建任务 </a>
				</div></td>
		</tr>
		<tr>
			<td width="211"><form id="form1" name="form1" method="get"
					action="">
					<p>
						<label for="姓名"><img src="picture/快乐狗.jpg" width="202"
							height="168" />姓名</label> <label><input type="text" name="姓名"
							id="姓名" value=<%=session.getAttribute("username")%>><label></label>
					</p>
					<p>
						<label for="等级">等级</label> <input type="text" name="等级" id="等级"
							value=<%=session.getAttribute("level")%>>
					</p>
					<p>
						<label for="积分">积分</label> <input type="text" name="积分" id="积分"
							value=<%=session.getAttribute("jifeng")%> >
					</p>
					<p>
						<a href="查看资料界面.jsp" target="_blank">查看资料 </a><a href="修改界面.jsp"
							target="_blank">修改资料</a>
					</p>
					<p>
						<input type="submit" name="button3" id="button3" value="私信" />
					</p>
					<p>
						<input type="submit" name="充值" id="充值" value="充值" />
					</p>
					<p>
						<input type="submit" name="消费记录" id="消费记录" value="消费记录" />
					</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</form></td>
			<td width="571">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><form id="form2" name="form2" method="post" action="">
					<div align="right">
						<input type="submit" name="系统消息" id="系统消息" value="系统消息" />
					</div>
				</form></td>
		</tr>
	</table>
</body>
</html>
