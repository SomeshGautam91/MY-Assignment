

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
			
			ServletContext sc =null;
			System.out.println("hhh");
			PrintWriter pw=response.getWriter();
			
			Cookie [] cookies=request.getCookies();
			
			if(cookies!=null)
			{
				for(Cookie cookie:cookies)
				{
					if(cookie.getName().equals("cProduct"))
					{
					    sc=request.getServletContext();
						sc.getRequestDispatcher("/"+cookie.getValue()+".html").forward(request, response);
						return;
					}
				}
			}
			else
			{
				sc=request.getServletContext();
				sc.getRequestDispatcher("/FrontView.html").forward(request,response);;
			}
		
		
		
	}

}
