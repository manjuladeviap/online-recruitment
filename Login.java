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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		    String c_name=request.getParameter("cname");
		    String c_num=request.getParameter("phnum");
		    String c_mailid=request.getParameter("mailid");
		    String c_mem=request.getParameter("num");
		    String c_req=request.getParameter("req");
		    String c_add=request.getParameter("text");
		    int rs=st.executeUpdate("insert into comp_reg(c_name,c_phn,c_mail,c_mem,c_req,c_add)values('"+c_name+"','"+c_num+"','"+c_mailid+"','"+c_mem+"','"+c_req+"','"+c_add+"')");
		    System.out.print("<h1>Insert successfull</h1>");
		    ServletContext sc = getServletContext();
	          sc.getRequestDispatcher("/app_success.html").forward(request, response);
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
