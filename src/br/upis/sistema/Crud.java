package br.upis.sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upis.sistema.state.Data;

@WebServlet("/crud")
public class Crud extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> list;
       
    public Crud() {
       list = new ArrayList<Usuario>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("em construção...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = extrairDadosFormulario(request);
		
		list.add(user);
		
		request.setAttribute("listUsuarios", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Resultado.jsp");
		
		dispatcher.forward(request, response);		
	}

	private Usuario extrairDadosFormulario(HttpServletRequest request) {
		String nome = request.getParameter("nomeUsuario");

		int dia = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[2]);
		int mes = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[1]);
		int ano = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[0]);
		
		Data dataNascimento = new Data(dia, mes, ano);
		
		String email = request.getParameter("emailUsuario");
		String senha = request.getParameter("senhaUsuario");
		
		return new Usuario(nome, email, senha, dataNascimento);
	}

}
