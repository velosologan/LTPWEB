package br.upis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oitavo")
public class Servlet8 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private int contador = 0;
    
	@Override
	public void init() throws ServletException {
		System.out.println("(INIT)Contador: " + contador);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Contador: ").append(""+ ++contador);
	}
	
	@Override
	public void destroy() {
		System.out.println("(DESTROY) Contador: " + contador);
	}	
}
