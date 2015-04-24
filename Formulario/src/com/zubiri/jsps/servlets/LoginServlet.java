package com.zubiri.jsps.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginWeb.jr")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		
		
		//Scanner sc = new Scanner(System.in);
		ParkingVehiculos parking = new ParkingVehiculos();
		//parkin.añadirCoche();
		parking.verCoches();
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>"+ parking.formattedParking() +"</p>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
