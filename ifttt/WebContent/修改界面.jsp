<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body style="background:url('picture/bgc.png') repeat;">
<table width="649" height="264" border="2">
  <tr>
    <td width="124" height="256"><form id="form1" name="form1" method="post" action="">
      <p>
        <label for="姓名">姓名：</label>
        <input type="text" name="姓名" id="姓名" />
      </p>
      <p>
        <label for="性别">性别：</label>
        <input type="text" name="性别" id="性别" />
      </p>
      <p>
        <label for="身份证">身份证：</label>
        <input type="text" name="身份证" id="身份证" />
      </p>
      <p>
        <label for="居住地">居住地：</label>
        <input type="text" name="居住地" id="居住地" />
       </p>
      <p>
        <label for="原密码">原密码：</label>
        <input type="text" name="原密码" id="原密码" />
      </p>
      <p>
        <label for="新密码">新密码：</label>
        <input type="text" name="新密码" id="新密码" />
      </p>
    </form></td>
    <td width="125"><p><a href="用户首页.jsp">提交</a></p>
    <p><a href="用户首页.jsp">取消</a></p></td>
  </tr>
</table>
</body>
</html>