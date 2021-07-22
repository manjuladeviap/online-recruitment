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
width:800px;
margin-bottom:50px;
margin-left:20px;
}
tr,td,th{
padding:10px;
border: 1.5px solid black; 
text-align:center;
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
    <a href="comp_det.jsp" class="w3-bar-item w3-button w3-hover-white" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspCompany Details</a> 
    <a href="cand_det.jsp" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Candidate Details</a> 
    <a href="scoresheet.jsp" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Score sheet</a> 
    <a href="job_rec.html" class="w3-bar-item w3-button w3-hover-white" style="background-color:white;color:black ;width:100%";>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Job Record</a> 
    <a href="intern_rec.html" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Intern Record</a>
    <a href="job_rec.html" class="w3-bar-item w3-button w3-hover-white" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Recruited Record</a> 
    <a href="index.html" class="w3-bar-item w3-button w3-hover-white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Log Out</a> 
  </div>
</nav>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:50px" id="showcase">
    <h1 class="w3-jumbo"><b style="font-size:35px">Job Record</b></h1>
      </p>
  </div>
<%@page import="java.util.Date,java.time.LocalDate,java.time.format.DateTimeFormatter, javax.servlet.*,java.io.*,javax.sql.*,java.sql.*" %>
<table>
<tr>
<th>Name</th>
<th>Date of attending test</th>
<th>Logical Score</th>
<th>Reasoning Score</th>
<th>Programming Score</th>
<th>Result</th>
</tr>
<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate");
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Samyu@041");  
	Statement st=con.createStatement();
	response.setContentType("text/html");
	ResultSet rs=null;
	Date d=new Date();
	String from=request.getParameter("from");
	DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.parse(from, format1);
	String to=request.getParameter("to");
	LocalDate date1 = LocalDate.parse(to, format1);
	rs=st.executeQuery("Select * from j_score");
	int count=0;
	while(rs.next())
	{
		String dob= rs.getString("date_of_attend");
		LocalDate date2 = LocalDate.parse(dob, format1);
        if(date2.isAfter(date) && date2.isBefore(date1))
        {
        	count=count+1;
        	int a=Integer.parseInt(rs.getString("logical"));
        	int b=Integer.parseInt(rs.getString("reason"));
        	int c=Integer.parseInt(rs.getString("prgm"));
        	int tot=a+b+c;
		
%>
		  <tr>
		  <td><%=rs.getString("uname") %></td>
		  <td><%=rs.getString("date_of_attend") %></td>
		  <td><%=rs.getString("logical") %></td>
		  <td><%=rs.getString("reason") %></td>
		  <td><%=rs.getString("prgm") %></td>
		  <td><%=rs.getString("result")%></td>
		  </tr>
<%
        }
      }
%>
	<h1 class="w3-xxxlarge w3-text-red"><b style="font-size:30px">Total candidates attended:<%=count %></b></h1><br>
<%
}
catch (Exception e) {
      e.printStackTrace();
      }
%>


</table>
</body>
</html>