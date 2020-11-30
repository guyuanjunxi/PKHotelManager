<%@ page import="com.mysql.jdbc.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.mysql.jdbc.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 15631
  Date: 2020/11/26
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经理表中的数据</title>
    <link href="Style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://cdb-fmhwq8ww.cd.tencentcdb.com:10074/hotel?useUnicode"  //地址
            + "=true&characterEncoding=utf-8&useSSL=false";
    Connection connection  = (Connection) DriverManager.getConnection(url,"root","b980227l");
    Statement statement = (Statement) connection.createStatement();  //连接实例
%>
<h1>数据表manager的信息</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>sfzh</th>
        <th>phone</th>
    </tr>
    <%
        String sql1 = "SELECT * FROM manager";
        ResultSet rs1 = statement.executeQuery(sql1);
        while(rs1.next()) {
            String id = rs1.getString("id");
            String name = rs1.getString("name");
            String password = rs1.getString("password");
            String sfzh = rs1.getString("sfzh");
            String phone = rs1.getString("phone");
    %>
    <tr>
        <td><%= id%></td>
        <td><%= name%></td>
        <td><%= password%></td>
        <td><%= sfzh%></td>
        <td><%= phone%></td>
    </tr>
    <%
        }
        rs1.close();
    %>
</table>
</body>
</html>
