package com.zubiri.jsps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buscar
 */
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			
			//int numRuedas = Integer.parseInt(request.getParameter("nr").trim());
			//String marca = request.getParameter("marc");	
		//	String matricula = request.getParameter("matri");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking", "root", "zubiri");
			System.out.println("Connecting to parking...");
			Statement sentencia = conexion.createStatement();
			System.out.println("sentencia creada");
		
			
			
			
		ResultSet coche = sentencia.executeQuery("SELECT * FROM parking3 WHERE matricula = '"+request.getParameter("matriculab")+"';"); 
		coche.next();
		
		
		
		
		out.println("<html>");
		out.println("<head><title>Respuesta</title>");
		out.println("<body>");
		out.println("<h1>almacenamiento del parking</h1>");
		out.println("<p>si se encuentra el coche con la matricula : " + coche.getString("matricula")  + "</p>");
		out.println("</body></html>");
		
		
		
		
			conexion.close();
		}catch(Exception e){
			
		}
		
		
	}

}
