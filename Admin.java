package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Samyu@041");
			Statement st=con.createStatement();
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		    String ad_name=request.getParameter("uname");
		    String ad_num=request.getParameter("phn");
		    String ad_mailid=request.getParameter("mailid");
		    String ad_pass=request.getParameter("psw");
		    int rs=st.executeUpdate("insert into admin(ad_name,ad_phn,ad_mail,ad_pas)values('"+ad_name+"','"+ad_num+"','"+ad_mailid+"','"+ad_pass+"')");
		    System.out.print("<h1>Insert successfull</h1>");
		    ServletContext sc = getServletContext();
	          sc.getRequestDispatcher("/login.html").forward(request, response);
		    con.close();
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			ServletContext sc = getServletContext();
	        //sc.getRequestDispatcher("/app_failed.html").forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
