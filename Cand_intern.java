package sample;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * Servlet implementation class Cand_intern
 */
@WebServlet("/Cand_intern")
@MultipartConfig(maxFileSize = 16177215)
public class Cand_intern extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cand_intern() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        javax.servlet.http.Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Samyu@041");
			Statement st=con.createStatement();
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		    String c_name=request.getParameter("c_name");
		    String c_num=request.getParameter("phn_num");
		    String c_mailid=request.getParameter("email");
		    String c_dob=request.getParameter("dob");
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = formatter.parse(c_dob);
		    Instant instant = date.toInstant();
		    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		    LocalDate givenDate = zone.toLocalDate();
		    Period period = Period.between(givenDate, LocalDate.now());
		    int c_age=period.getYears();
		    String c_gen=request.getParameter("gen");
		    String c_degree=request.getParameter("degree");
		    String c_clg=request.getParameter("clg_name");
		    String c_cgpa  =request.getParameter("cgpa");
		    String c_arrear =request.getParameter("arrear");
		    String c_tech  =request.getParameter("prgm");
		    String c_pro=request.getParameter("pro");
		    String c_add=request.getParameter("address");
		    //Part part=(Part) request.getPart("fileid");
		    //String fn=extractFileName(part);
		    //String sp="C:\\Users\\91894\\st_project\\Mini_project\\WebContent\\images\\"+File.separator+fn;
		    //File filesaver=new File(sp);
		    //part.write(sp+File.separator);
		    int rs=st.executeUpdate("insert into cand_intern_reg(cand_name,cand_phn,cand_mail,cand_dob,cand_age,cand_gen,cand_deg,cand_clg,cand_cgpa,cand_arrear,cand_tech,cand_pro,cand_add,cand_proof)values('"+c_name+"','"+c_num+"','"+c_mailid+"','"+c_dob+"','"+c_age+"','"+c_gen+"','"+c_degree+"','"+c_clg+"','"+c_cgpa+"','"+c_arrear+"','"+c_tech+"','"+c_pro+"','"+c_add+"','"+inputStream+"')");
		    Cookie ck=new Cookie("mail",c_mailid);
		    response.addCookie(ck);
		    request.getRequestDispatcher("Sendmail").forward(request,response);
		    con.close();
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			ServletContext sc = getServletContext();
	        sc.getRequestDispatcher("/reg_failed.html").forward(request, response);
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
