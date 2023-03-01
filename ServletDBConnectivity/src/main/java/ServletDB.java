

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
import java.sql.SQLException;

/**
 * Servlet implementation class ServletDB
 */
public class ServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		out.println("FirstName"+firstname);
		 try { 
			  Class.forName("com.mysql.jdbc.Driver");
	       Connection con = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/loginservlet", "root", "root");
	       out.println("connected");
	        		PreparedStatement ps = con.prepareStatement
	                        ("insert into LoginServletTable values(?,?,?,?)");
	 
	            ps.setString(1, firstname);
	            ps.setString(2, lastname);
	            ps.setString(3, username);
	            ps.setString(4, password);
	            int i = ps.executeUpdate();
	            out.println ("Total"+i+"records inserted");
	        }catch (Exception e) {
	            // process sql exception
	            //printSQLException(e);
	        	e.printStackTrace();
	        }
	}

}
