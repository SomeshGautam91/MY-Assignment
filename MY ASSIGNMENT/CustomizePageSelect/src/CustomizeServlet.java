

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		
		String productToPersonalize=request.getParameter("product");
		
		Cookie c= new Cookie("cProduct",productToPersonalize);
		
		c.setMaxAge(60);
		
		response.addCookie(c);
		
		response.sendRedirect("PS");
	}

}
