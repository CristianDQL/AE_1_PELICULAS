package packageServidor;

import java.io.IOException;
import java.net.*;
import java.util.*;





public class Servidor {
	
	public static final int PUERTO = 2018;
	
	/*
	 * private static List<Peliculas> peliculas = new ArrayList<>();
	
	private static void addPeliculas() {
		peliculas.add(new Peliculas(001, "Origen", "Christopher Nolan", 10));
		peliculas.add(new Peliculas(002, "El código DaVinci", "Ron Howard", 9));
		peliculas.add(new Peliculas(003, "Harry Potter y el prisionero de Azkaban", "Alfonso Cuarón", 8));
		peliculas.add(new Peliculas(004, "La llegada", "Denis Villeneuve", 7));
		peliculas.add(new Peliculas(005, "Star Wars: Episodio IV - Una nueva esperanza", "George Lucas", 7));
		
	}
	
	public static List<Peliculas> obtenerPeliculas(){
		return peliculas;
	}
	
	 */
	
	
	
	public static void main(String[] args) {
		
		//addPeliculas();
		
		try(ServerSocket servidor = new ServerSocket()){
			

			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);
			
			System.out.println("S: esperando petición en" + PUERTO);
			
			while(true) {
				Socket socketAlCliente = servidor.accept();
				
				new HiloServidor(socketAlCliente);
			}
			
			
		} catch (IOException e) {
			System.err.println("Servidor: error de I/O");
			e.printStackTrace();
		} catch(Exception e){
			System.err.println("Servidor: error");
			e.printStackTrace();
		}
		
	}
	
	

}
