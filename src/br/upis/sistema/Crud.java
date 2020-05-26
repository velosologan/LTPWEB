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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer pos = Integer.parseInt(request.getParameter("posicao"));
		
		request.setAttribute("usr", list.get(pos));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			Usuario user = extrairDadosFormulario(request);
			
			
			if( request.getParameter("posicao") != null) {

				Integer posicao = Integer.parseInt(request.getParameter("posicao"));
				
				atualizarUsuario(posicao, user);
			
			} else {
				
				inserirUsuario(user);			
			}			

			request.setAttribute("listUsuarios", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Resultado.jsp");

			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("msg", e.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher("Erro.jsp");

			dispatcher.forward(request, response);

		}
	}

	private void atualizarUsuario(Integer posicao, Usuario user) {
		list.set(posicao, user);		
	}

	private void inserirUsuario(Usuario user) {
		
		if(existeUsuario(user)) {
			throw new RuntimeException("E-mail já cadastrado");
		}
		
		list.add(user);
	}

	// busca linear
	private boolean existeUsuario(Usuario user) {

		for (int i = 0; i < list.size(); i++) {

			Usuario u = list.get(i);

			if (u.getEmail().equals(user.getEmail())) {
				return true;
			}
		}

		return false;
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
