tricula = '"+request.getParameter("matriculaE")+"';"); 
		coche.next();
		
		*/
		out.println("<html>");
		out.println("<head><title>Respuesta</title>");
		out.println("<body>");
		out.println("<h1>almacenamiento del parking</h1>");
		//out.println("<p>se ha eliminado el coche con la matricula : " + coche.getString("matriculaE")  + "</p>");
		out.println("<p>se ha eliminado el coche con la matricula : " + matricula  + "</p>");
		out.println("</body></html>");
		
		
		
		
			conexion.close();
		}catch(Exception e){
			
		}
	}

}
