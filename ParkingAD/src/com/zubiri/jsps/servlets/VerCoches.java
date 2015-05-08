package com.zubiri.jsps.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.Coche;
import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Servlet implementation class VerCoches
 */
public class VerCoches extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public VerCoches() {
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
		/*ParkingVehiculos parking = new ParkingVehiculos();
		//parkin.añadirCoche();
		parking.verCoches();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>"+ parking.formattedParking() +"</p>");
		out.println("</body>");
		out.println("</html>");
		*/

		try{
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			
			//int numRuedas = Integer.parseInt(request.getParameter("nr").trim());
			//String marca = request.getParameter("marc");	
			//String matricula = request.getParameter("matri");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking", "root", "zubiri");
			System.out.println("Connecting to parking...");
			Statement sentencia = conexion.createStatement();
			System.out.println("sentencia creada");
		
			/*sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS parking3"
					+"(matricula varchar(7) primary key,"
					+"marca varchar(25),"
					+"ruedas integer unsigned)");
			
			sentencia.executeUpdate("INSERT INTO parking3 (matricula, marca, ruedas) VALUES ('"
					+request.getParameter("matri")+"','"
					+request.getParameter("marc")+"',"
					+Integer.parseInt(request.getParameter("nr"))+
					")");
			*/
			
		ResultSet coche = sentencia.executeQuery("SELECT * FROM parking3;"); 
		coche.next();
		
		
		out.println("<html>");
		out.println("<head><title>Respuesta</title>");
		out.println("<body>");
		out.println("<h1>coches en el parking</h1>");
		while(coche.next()){
			out.println("<p> matricula: " +  coche.getString("matricula") +"  marca: "+ coche.getString("marca")+" numero de ruedas: " + coche.getInt("ruedas")+"</p>");
		}
		out.println("</body></html>");
		
		conexion.close();
		}catch(Exception e){
			
		}
		
		
	}

}
