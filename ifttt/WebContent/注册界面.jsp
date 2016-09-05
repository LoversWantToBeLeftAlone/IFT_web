<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>注册界面</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
<style type="text/css">
body,td,th {
	font-weight: bold;
}
body {
	background-color: #D6D6D6;
	background-repeat: repeat;
}
</style>
</head>

<body style="background:url('') repeat;">
<div align="center">
<table width="546" height="350" border="2">
<div align="center">
  <caption>
    注册
  </caption>
  <tr>
    <td align="left"><form id="form2" name="form2" method="post" action="账号信息错误.jsp">
      <input type="reset" name="button2" id="button2" value="取消" />
    </form></td>
  </tr>
  <tr>
    <td align="center" valign="middle" bgcolor="#FFFFFF"><form id="form1" name="form1" method="post" action="register">
      <p>
        <label for="name">姓名：</label>
        <input type="text" name="name" id="name" />
        </p>
      <p>
        <label for="性别">性别：</label>
        <input type="radio" name="radio" id="男" value="男" />
        <label for="男">男</label>
        <input type="radio" name="radio" id="女" value="女" />
        <label for="女">女</label>
        </p>
      <p>
        <label for="身份证">身份证：</label>
        <input type="text" name="idnumber" id="idnumber" />
        </p>
      <p>
        <label for="居住地">居住地：</label>
        <input type="text" name="address" id="address" />
        </p>
      <p>
        <label for="密码">密码： </label>
        <input type="text" name="pwd" id="pwd" />
        </p>
      <p>
        <label for="重复密码">重复密码：</label>
        <input type="text" name="pwd1" id="pwd1" />
        </p>
      <p>
        <label for="金额">金额</label>
        ：
        <input type="text" name="money" id="money" />
        </p>
      <p>
        <input type="submit" name="button" id="button" value="提交" />
      </p>
 
      <p>&nbsp;</p>
      </form></td>
  </tr>
</table>
</body>
</html>