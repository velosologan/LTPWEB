package br.upis;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nono")
public class Servlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Servlet9() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher rd = request.getRequestDispatcher("Clock.jsp");
		rd.include(request, response);
	}
}
