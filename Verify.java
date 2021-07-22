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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify() {
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
		    String ad_name=request.getParameter("uname");
		    String ad_pass=request.getParameter("psw");
		    ResultSet rs=st.executeQuery("select * from admin");
		      while(rs.next())
		      {
		    	  String user_name = rs.getString("ad_name");
		    	  String mob = rs.getString("ad_phn");
		          String passwrd = rs.getString("ad_pas"); 
		          if((ad_name.equals(user_name)) && (ad_pass.equals(passwrd)))
		          {
		              flag = true;
		              ServletContext sc = getServletContext();
		              sc.getRequestDispatcher("/comp_det.jsp").forward(request, response);
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
