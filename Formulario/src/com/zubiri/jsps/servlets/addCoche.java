package com.zubiri.jsps.servlets;
import java.io.BufferedReader;
import java.sql.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.Coche;
import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;


/**
 * Servlet implementation class addCoche
 */
//@WebServlet("/addCoche.jr")
public class addCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCoche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        }*/
		
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
		
		
		
		
		/*
		
		
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
	 }
	  
	 
}
