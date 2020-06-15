package servletes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import usuario.UsuarioModel;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/pages/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Autenticar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(Boolean.parseBoolean(request.getParameter("deslogar"))) {
			HttpSession fecharSessao = request.getSession();
			fecharSessao.invalidate();
			response.sendRedirect("../index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("user");
		String senha= request.getParameter("senha");
		
		try {
			if(usuario.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123")) {
				UsuarioModel model = new UsuarioModel();
				model.setNome(usuario);
				model.setSenha(senha);
				
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession sessao = req.getSession();
				sessao.setAttribute("usuario", model);
				
				RequestDispatcher dispt = request.getRequestDispatcher("acessoSistema.jsp");
				dispt.forward(request, response);
			} else {
				RequestDispatcher dispt = request.getRequestDispatcher("/logar.jsp");
				dispt.forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Erro na servlet Autenticar\n" + e);
		}
	}

}
