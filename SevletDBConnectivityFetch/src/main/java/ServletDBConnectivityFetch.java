

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ServletDBConnectivityFetch
 */
public class ServletDBConnectivityFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDBConnectivityFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
		String username_view=request.getParameter("username");
		String password_view=request.getParameter("password");
		   out.println("<br>");
		out.println("UserName Entered :"+username_view+"\n");
		   out.println("<br>");
		out.println("Password Entered :"+password_view+"\n");
		   out.println("<br>");
		 try { 
			  Class.forName("com.mysql.jdbc.Driver");
	       Connection con = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/loginservlet", "root", "root");
	       out.println("Connection with MySQL is established");
	       out.println("<br>");
	        		Statement stmt = con.createStatement();
	 ResultSet rs=stmt.executeQuery("Select * from LoginServletTable");
	 
	 while (rs.next())
	 {
	           // out.println(rs.getString("username"));
	           // out.println(rs.getString("password"));
	            String username_DB=rs.getString("username");
	            String password_DB=rs.getString("password");
	          if( (username_view.equals(username_DB))&&(password_view.equals(password_DB)))
	           {
	        	  out.println("<!DOCTYPE html>");
	        	  out.println("<html>");
	        	  out.println("<head>");
	        	  out.println(" <style>");
	        	  out.println("body {background-color: powderblue;}");
	        	  out.println("h1   {color: blue;}");
	        	  out.println("p    {color: red;}");
	        	  out.println("</style>");
	        	  out.println("</head>");
	        	 out.println("<body>");
	            out.println("Welcome"+username_DB); 
	            out.println("</body>");
	            out.println("</html>");break;
	           }
	           else
	           {
	            
	            out.println("Try Again");
	           }
	           
	 }
	 
         //out.println("Welcome"+username_DB);
       
	            
	        }catch(Exception e) 
		 {
	            // process sql exception
	            //printSQLException(e);
	        	e.printStackTrace();
	        }
	}

}
