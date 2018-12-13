
package util;

import fabrica.Fabrica;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class ChamarRelatorio {
    public void imprimeRelatorio(String caminhoRelatorio, HashMap param, String nomeRelatorio) {
        System.out.println("dentro");
        Connection con = Fabrica.getFabrica().getConnection();

        HashMap parametros = param;

        try {
            System.out.println("here");
            FacesContext facesContext = FacesContext.getCurrentInstance();
 
            facesContext.responseComplete();

            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();        
            JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/WEB-INF/relatorios/" + caminhoRelatorio), parametros, con);
                       
//        JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\Colaborador\\Documents\\workspaceJasperStudio\\MyReports\\Blank_A4_1.jasper", parametros, con);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();            
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);        

            byte[] bytes = baos.toByteArray();

            if (bytes != null && bytes.length > 0) {

                HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

                response.setContentType("application/pdf");

//              response.setHeader("Content-disposition", "inline; filename=\"relatorioPorData.pdf\"");
                response.setHeader("Content-disposition", "attachment; filename=\"" + nomeRelatorio + ".pdf\"");

                response.setContentLength(bytes.length);

                ServletOutputStream outputStream = response.getOutputStream();

                outputStream.write(bytes, 0, bytes.length);

                outputStream.flush();

                outputStream.close();

                baos.close();
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}



//package util;
//
//import java.io.ByteArrayOutputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.HashMap;
//
//import javax.faces.context.FacesContext;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.jasperreports.engine.JRResultSetDataSource;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//
//public class ChamarRelatorio {
//	
//	public static void relatorio(String consulta, 
//			String nomeArquivoJrxml, 
//			String nomePdfGerado,
//			HashMap parametros) {
//		
//		try {
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//
//			facesContext.responseComplete();
//
//			ServletContext context = (ServletContext) facesContext.getExternalContext().getContext();
//
//			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste11", "postgres", "tom2904960");
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(consulta);
//			JRResultSetDataSource ds = new JRResultSetDataSource(rs);
//			JasperReport js = JasperCompileManager
//					.compileReport(context.getRealPath("/WEB-INF/relatorios/"+nomeArquivoJrxml+".jrxml"));
//
//			JasperPrint jp = JasperFillManager.fillReport(js, parametros, ds);
//			
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			JasperExportManager.exportReportToPdfStream(jp, baos);
//
//			byte[] bytes = baos.toByteArray();
//
//			if (bytes != null && bytes.length > 0) {
//				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//				response.setContentType("application/pdf");
//				// response.setHeader("Content-disposition", "inline;
//				// filename=\"relatorioPorData.pdf\"");
//				response.setHeader("Content-disposition", "attachment; filename=\""+nomePdfGerado+".pdf\"");
//				response.setContentLength(bytes.length);
//				ServletOutputStream outputStream = response.getOutputStream();
//				outputStream.write(bytes, 0, bytes.length);
//				outputStream.flush();
//				outputStream.close();
//				baos.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void relatorioConexao( 
//			String nomeArquivoJrxml, 
//			String nomePdfGerado,
//			HashMap parametros) {
//		
//		try {
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//
//			facesContext.responseComplete();
//
//			ServletContext context = (ServletContext) facesContext.getExternalContext().getContext();
//
//			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste11", "postgres", "tom2904960");
//			//Statement st = conn.createStatement();
//			//ResultSet rs = st.executeQuery(consulta);
//			//JRResultSetDataSource ds = new JRResultSetDataSource(rs);
//			JasperReport js = JasperCompileManager
//					.compileReport(context.getRealPath("/WEB-INF/relatorios/"+nomeArquivoJrxml+".jrxml"));
//
//			JasperPrint jp = JasperFillManager.fillReport(js, parametros, conn);
//			
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			JasperExportManager.exportReportToPdfStream(jp, baos);
//
//			byte[] bytes = baos.toByteArray();
//
//			if (bytes != null && bytes.length > 0) {
//				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//				response.setContentType("application/pdf");
//				// response.setHeader("Content-disposition", "inline;
//				// filename=\"relatorioPorData.pdf\"");
//				response.setHeader("Content-disposition", "attachment; filename=\""+nomePdfGerado+".pdf\"");
//				response.setContentLength(bytes.length);
//				ServletOutputStream outputStream = response.getOutputStream();
//				outputStream.write(bytes, 0, bytes.length);
//				outputStream.flush();
//				outputStream.close();
//				baos.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
