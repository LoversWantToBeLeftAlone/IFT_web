<%@ page contentType="text/html; charset=GBK" language="java"
	import="java.sql.*" errorPage=""%>
	<%@page import="Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>��ӭ������ϵͳ</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
</head>
<body style="background: url('') repeat;">
<div align="center">
<table width="1428" height="870" border="2">
		<tr>
			<td height="81"><form id="form2" name="form2" action="">
					<label for="name">
						<div align="center">
							<strong>��ӭ����IFTTTϵͳ</strong>
						</div>
					</label>
					<p>
						<font size="4"> 
						<a href="ע�����.jsp">ע��</a>
						</font> <label></label>
					</p>
				</form></td>
		</tr>

		<tr>
			<td width="1401" height="90" align="center"><form action="loginServlet"
					method="post" name="form1">
					<p>
						<label> <input name="username" type="text" id="username"></label>
					</p>
					<p>
						<input name="password" type="text" id="password" />
					</p>
					<p> <input
							type="submit" value="��¼" />
			  </p>
				</form></td>
		
  </tr>
		<tr>
			<td height="172"><img src="picture/������.png" width="525"
				height="161" /></td>
		</tr>
</table>
</body>
</html>
