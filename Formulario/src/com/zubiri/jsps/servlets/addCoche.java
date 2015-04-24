package com.zubiri.jsps.servlets;

import java.io.IOException;
import java.util.Scanner;

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

}
