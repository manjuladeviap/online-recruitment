package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Intern_log
 */
@WebServlet("/Intern_log")
public class Intern_log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Intern_log() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			boolean flag=false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Samyu@041");
			Statement st=con.createStatement();
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		    String c_name=request.getParameter("uname");
		    String c_phn=request.getParameter("phn");
		    ResultSet rs=st.executeQuery("select * from cand_intern_reg");
		      while(rs.next())
		      {
		    	  String user_name = rs.getString("cand_name");
		          String phn = rs.getString("cand_phn"); 
		          if((c_name.equals(user_name)) && (c_phn.equals(phn)))
		          {
		              flag = true;
		              Cookie ck= new Cookie ("username",c_name);
		              response.addCookie(ck);
		              ServletContext sc = getServletContext();
		              sc.getRequestDispatcher("/i_reason.html").forward(request, response);
		          } 
		      }
		      if(!flag)
	          {
	            out.println("Please Check Username and Password ");
	          }
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
