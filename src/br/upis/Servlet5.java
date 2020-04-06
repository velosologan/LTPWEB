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
@WebServlet("/cinco")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("image/jpeg");
    	
    	ServletOutputStream out = response.getOutputStream();
    	
    	InputStream in = getServletContext().getResourceAsStream("./img/balao.jpg");
    	   	
    	byte[] buffer = new byte[4096];
        
    	int length;
        
    	while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        
    	in.close();
        
    	out.flush();
    }
}
