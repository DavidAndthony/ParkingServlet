package com.zubiri.jsps.servlets;
import java.io.BufferedReader;
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
	 }

}
