package br.upis.sessao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Restrito
 */
@WebServlet("/restrito")
public class Restrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getSession(false) != null) {
    		
    		PrintWriter out = response.getWriter();
    		
    		Usuario ref = (Usuario)request.getSession(false).getAttribute("aut");
    		
    		out.println("<html>");
    		out.println("<head>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("Olá: " + ref.getNome() + "<br/>");
    		out.println("Você acessou um área restrita em: " + new Date() + "<br/>");
    		out.println("<a href=\"invalidar\"> Logout </a>");
    		out.println("</body>");
    		out.println("</html>");
    	
    	} else {
			
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("Você está sendo monitorado bem de pertinho devido a tentativa indevida de acesso às áreas restritas do sistema.");
			out.println("<a href=\"Credenciais.html\"> Quer tentar se logar de novo? </a>");
			out.println("</body>");
			out.println("</html>");
			
		}
    }
}
