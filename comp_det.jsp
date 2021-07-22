<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company details</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
table{
box-sizing: border-box;
border-collapse: collapse;
border: 1.5px solid black; 
border-space:30px;
width:500px;
margin-bottom:50px;
margin-left:20px;
}
tr,td{
padding:10px;
margin-left:15px;
}
</style>
</head>
<body>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Online Recuirement<br>System</b></h3>
  </div>
  <div class="w3-bar-block">
    <a href="comp_det.jsp" class="w3-button w3-hover-white" style="background-color:white;color:black ;width:100%";>Company Details</a> 
    <a href="cand_det.jsp" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Candidate Details</a> 
    <a href="scoresheet.jsp" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Score sheet</a> 
    <a href="job_rec.html" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Job Record</a> 
    <a href="intern_rec.html" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Intern Record</a>
    <a href="job_rec.html" class="w3-bar-item w3-button w3-hover-white" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Recruited Record</a> 
    <a href="index.html" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Log Out</a> 
  </div>
</nav>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:50px" id="showcase">
    <h1 class="w3-jumbo"><b style="font-size:35px">Company details</b></h1>
    <h1 class="w3-xxxlarge w3-text-red"><b style="font-size:30px">Page</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
      </p>
  </div>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>

<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate");
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Samyu@041");  
	Statement st=con.createStatement();
	ResultSet rs=null;
	rs=st.executeQuery("Select * from comp_reg");
	while(rs.next())
	{
%>
		  <table>
		  <tr>
		  <td></td>
		  <td></td>
		  <td></td>
		  </tr>
		  <tr>
		  <td>Name</td>
		  <td>:</td>
		  <td><%=rs.getString("c_name") %></td>
		  </tr>
		  <tr>
		  <td>Phone number</td>
		  <td>:</td>
		  <td><%=rs.getString("c_phn") %></td>
		  </tr>
		  <tr>
		  <td>Email id</td>
		  <td>:</td>
		  <td><%=rs.getString("c_mail") %></td>
		  </tr>
		  <tr>
		  <td>Deadline</td>
		  <td>:</td>
		  <td><%=rs.getString("c_deadline") %></td>
		  </tr>
		  <tr>
		  <td>Members needed</td>
		  <td>:</td>
		  <td><%=rs.getString("c_mem") %></td>
		  </tr>
		  <tr>
		  <td>Requirment</td>
		  <td>:</td>
		  <td><%=rs.getString("c_req") %></td>
		  </tr>
		  <tr>
		  <td>Address</td>
		  <td>:</td>
		  <td><%=rs.getString("c_add") %></td>
		  </tr>
		  <tr>
		  <td></td>
		  <td></td>
		  <td></td>
		  </tr>
		  </table>
<%
      }
}
catch (Exception e) {
      e.printStackTrace();
      }
%>
</body>
</html>