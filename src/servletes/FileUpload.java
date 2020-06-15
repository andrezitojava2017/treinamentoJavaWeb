package servletes;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/fileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// usar variavel fileUpload pra salvar no banco de dados
			String fileUpload = request.getParameter("fileUpload");
			
			System.out.println("Valor recuperado: " + fileUpload);
			
			
		
			response.getWriter().write("Upload realizado com sucesso");
			
		} catch (Exception e) {
			response.getWriter().write("Erro fatal ao realizar upload");
		}

	}

}
