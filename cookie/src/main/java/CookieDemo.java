	
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.Cookie;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import java.io.IOException;
	import java.io.PrintWriter;
	
	/**
	 * Servlet implementation class CookieDemo
	 */
	public class CookieDemo extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CookieDemo() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
		IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			   Cookie cookie = null;
			      Cookie[] cookies = null;
			      cookies = request.getCookies();
			 Cookie firstName = new Cookie("sname", request.getParameter("sname"));
		      Cookie lastName = new Cookie("sroll", request.getParameter("sroll"));
	
		      // Set expiry date after 24 Hrs for both the cookies.
		      firstName.setMaxAge(60*60*24);
		      lastName.setMaxAge(60*60*24);
	
		      // Add both the cookies in the response header.
		      response.addCookie( firstName );
		      response.addCookie( lastName );
	
		      // Set response content type
		      response.setContentType("text/html");
		 
		      PrintWriter out = response.getWriter();
		      //String title = "Setting Cookies Example";
		      out.println("<html>");
		      out.println("<body>");
		      out.println(request.getParameter("sname"));
		      out.println(request.getParameter("sroll"));
		      if( cookies!= null ) {
		          out.println("<h2> Found Cookies Name and Value</h2>");
	
		          for (int i = 0; i < cookies.length; i++) {
		             cookie = cookies[i];
		             out.print("Name : " + cookie.getName( ) + ",  ");
		             out.print("Value: " + cookie.getValue( ) + " <br/>");
		          }
		       } else {
		          out.println("<h2>No cookies founds</h2>");
		       }
		      out.println("</body>");
		      out.println("</html>");
		}
	
	}
