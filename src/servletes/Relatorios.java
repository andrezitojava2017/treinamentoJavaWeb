package servletes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import conexao.Conexao;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * Servlet implementation class Relatorios
 */
@WebServlet("/pages/relatorios")
public class Relatorios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Relatorios() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream outs = response.getOutputStream();
		
		File caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/Relatorios/Relatorio_Prestadores.jasper"));
		byte[] bytes;
		
		String competencia = request.getParameter("competencia");
		HashMap param = new HashMap();
		param.put("competencia", competencia);
		 try {
			Connection con = new Conexao().getconection();
			 bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), param, con);
			 response.setContentType("application/pdf");
			 response.setHeader("Content-Disposition", "attachment; filename=Relatorio.pdf");
			 //response.setContentLengthLong(bytes.length);
			 outs.write(bytes,0,bytes.length);
			 outs.flush();
			 outs.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
