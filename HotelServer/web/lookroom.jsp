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
    <title>客房表中的数据</title>
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
<h1>数据表room的信息</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>size</th>
        <th>bednum</th>
        <th>price</th>
        <th>kongtiao</th>
        <th>tv</th>
        <th>weiyu</th>
        <th>cfj</th>
        <th>dianhua</th>
    </tr>
    <%
        String sql1 = "SELECT * FROM room";
        ResultSet rs1 = statement.executeQuery(sql1);
        while(rs1.next()) {
            String id = rs1.getString("id");
            String name = rs1.getString("name");
            String size = rs1.getString("size");
            String bednum = rs1.getString("bednum");
            String price = rs1.getString("price");
            String kongtiao = rs1.getString("kongtiao");
            String tv = rs1.getString("tv");
            String weiyu = rs1.getString("weiyu");
            String cfj = rs1.getString("cfj");
            String dianhua = rs1.getString("dianhua");
    %>
    <tr>
        <td><%= id%></td>
        <td><%= name%></td>
        <td><%= size%></td>
        <td><%= bednum%></td>
        <td><%= price%></td>
        <td><%= kongtiao%></td>
        <td><%= tv%></td>
        <td><%= weiyu%></td>
        <td><%= cfj%></td>
        <td><%= dianhua%></td>
    </tr>
    <%
        }
        rs1.close();
    %>
</table>
</body>
</html>
