package Main;

import java.util.ArrayList;

import Algorithm.Fifo;
import Algorithm.Rr;
import Algorithm.Sjf;
import Algorithm.Srt;
import Models.Proceso;

public class Main {

	public static void main(String[] args) {
		Proceso miProceso;	
		ArrayList<Proceso> miListaProcesos= new ArrayList<Proceso>();
		
		//Fifo algoritmoFifo; 
		//Sjf algoritmoSjf;
		//Srt algoritmoSrt;
		Rr algoritmoRr;
		
		miProceso= new Proceso("A",0,5);
		miListaProcesos.add(miProceso);
		miProceso= new Proceso("B",2,4);
		miListaProcesos.add(miProceso);
		miProceso= new Proceso("C",3,3);
		miListaProcesos.add(miProceso);
		miProceso= new Proceso("D",5,2);
		miListaProcesos.add(miProceso);
		miProceso= new Proceso("E",6,3);
		miListaProcesos.add(miProceso);
		
		//algoritmoFifo = new Fifo(miListaProcesos);
		//algoritmoSrt = new Srt(miListaProcesos);
		//algoritmoSjf  = new Sjf(miListaProcesos);
		algoritmoRr = new Rr(miListaProcesos,2);
		
		//algoritmoSrt.run();
		algoritmoRr.run();
		//algoritmoFifo.run();
		//algoritmoSjf.run();

	}

}
