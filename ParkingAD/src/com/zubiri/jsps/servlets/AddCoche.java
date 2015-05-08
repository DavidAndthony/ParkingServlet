package com.zubiri.jsps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zubiri.parking.Coche;
import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class AddCoche
 */
public class AddCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddCoche() {
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
	
		
		
	
		//ParkingVehiculos.addVehiculo(tipoVehiculo, numRuedas, combustible, marca, auto, consumo, matricula, color, codBarras, numPinones, tipoBici);

		try{
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			
			int numRuedas = Integer.parseInt(request.getParameter("nr").trim());
			String marca = request.getParameter("marc");	
			String matricula = request.getParameter("matri");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking", "root", "zubiri");
			System.out.println("Connecting to parking...");
			Statement sentencia = conexion.createStatement();
			System.out.println("sentencia creada");
		
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS parking3"
					+"(matricula varchar(7) primary key,"
					+"marca varchar(25),"
					+"ruedas integer unsigned)");
			
			sentencia.executeUpdate("INSERT INTO parking3 (matricula, marca, ruedas) VALUES ('"
					+request.getParameter("matri")+"','"
					+request.getParameter("marc")+"',"
					+Integer.parseInt(request.getParameter("nr"))+
					")");
			
			
		ResultSet coche = sentencia.executeQuery("SELECT * FROM parking3 WHERE matricula = '"+request.getParameter("matri")+"';"); 
		coche.next();
		
		
		
		
		out.println("<html>");
		out.println("<head><title>Respuesta</title>");
		out.println("<body>");
		out.println("<h1>coche añadido</h1>");
		out.println("<p>el coche con la matricula : " + coche.getString("matricula")  + " ha sido creado</p>");
		out.println("</body></html>");
		
		
		
		
			conexion.close();
		}catch(Exception e){
			
		}
		
		
		
		
	}

}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	
		ParkingVehiculos parking = new ParkingVehiculos();
		Coche coche = new Coche();
		
		String matri = request.getParameter("matri");
		String marc = request.getParameter("marc");
		String nr = request.getParameter("nr");
	
		//Scanner sc = new Scanner(System.in);
		
		Vehiculo.setMatricula(matri);
		Vehiculo.setMarca(marc);
//		Vehiculo.setMotor(mot);
		Vehiculo.setNumRuedas(Integer.parseInt(nr));
	//	coche.setAutomatico(automa);
	//	coche.setConsumo100km(consumo);
		
		parking.addCoche(coche);
	    parking.añadirCoche();
	
		//Scanner sc = new Scanner(System.in);
		//ParkingVehiculos parking = new ParkingVehiculos(sc);
		
	}
	 static public void añadirCoche(){
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("coches.txt", true);
	            pw = new PrintWriter(fichero);

	                pw.println(Vehiculo.getMatricula()+","+Vehiculo.getMarca()+","+Vehiculo.getNumRuedas());
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
		
		String matri = request.getParameter("matri");
		String marc = request.getParameter("marc");
		String nr = request.getParameter("nr");
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
	
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "zubiri");
	
			Statement st = conexion.createStatement();
	
		
	
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
	
			System.out.println( "Si no se hubiera producido, se habría disparado SQLException");
	
			st.execute("insert into choches values ("+ matri+ ","+ marc+","+nr+");");
	
			//rs.close();
			//conexion.close();
			//st.close();
			
		}
		catch(Exception e){
			System.out.println("hay un problema");
		}
		
		
		
		
		
		
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/parking","root", "zubiri");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		} */

