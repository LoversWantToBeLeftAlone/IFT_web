<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background:url('picture/bgc.png') repeat;">
<table width="669" height="269" border="2">
  <caption>
    查看资料
  </caption>
  <tr>
    <td width="371" height="213"><form id="form1" name="form1" method="post" action="">
      <p>
        <label for="1">姓名：</label>
        <input type="text" name="1" id="1" />
      </p>
      <p>
        <label for="2">性别：</label>
        <input type="text" name="2" id="2" />
      </p>
      <p>
        <label for="3">居住地：</label>
        <input type="text" name="3" id="3" />
      </p>
      <p>
        <label for="4">剩余金额：</label>
        <input type="text" name="4" id="4" />
      </p>
      <p>
        <label for="5">等级：</label>
        <input type="text" name="5" id="5" />
      </p>
      <p>
        <label for="6">积分：</label>
        <input type="text" name="6" id="6" />
      </p>
    </form></td>
    <td width="280"><p><a href="用户首页.jsp">确定</a></p>
    <p><a href="用户首页.jsp">返回</a></p></td>
  </tr>
</table>
</body>
</html>