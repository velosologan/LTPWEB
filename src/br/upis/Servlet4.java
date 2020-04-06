package br.upis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/quarto.jpg")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("application/octet-stream");
        
    	ServletOutputStream out = response.getOutputStream();
    	    	   	   	
    	File my_file = new File("C:\\Users\\DELL\\git\\LTPWEB\\WebContent\\img\\balao.jpg");
        
    	FileInputStream in = new FileInputStream(my_file);
        
    	byte[] buffer = new byte[4096];
        
    	int length;
        
    	while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        
    	in.close();
        
    	out.flush();
    }
}
