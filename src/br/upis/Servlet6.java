package br.upis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet6
 */
@WebServlet("/sexto")
public class Servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
	
    	PrintWriter out = response.getWriter();
    	    	
    	out.println("<html>");
    	out.println("<head>");
    	out.println("</head>");
    	out.println("<body>");
    	out.print("<img src = \"./img/balao.jpg\">");
    	out.println("</body>");
    	out.println("</html>");
    }
}
