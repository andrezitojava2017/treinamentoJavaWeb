package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import usuario.UsuarioModel;

/**
 * Servlet Filter implementation class FilterAutenticacao
 */
@WebFilter(urlPatterns= {"/pages/*"})
public class FilterAutenticacao implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAutenticacao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		UsuarioModel user = (UsuarioModel) sessao.getAttribute("usuario");
		
		if(user == null && !req.getServletPath().equalsIgnoreCase("/pages/Autenticar")) {

			System.out.println("interceptado, fazendo dispatcher");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/logar.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		System.out.println("interceptado");
		System.out.println(request.getRemoteAddr());
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
