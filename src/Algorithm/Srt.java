package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Models.Proceso;

public class Srt extends AbstractAlgorithm{
	/**
	 * Constructor
	 * @param miLista lista de los procesos que hay que ejecutar
	 */
	public Srt(ArrayList<Proceso> miLista) {
		super(miLista);
		
	}

	//RESTO COMPORTAMIENTOS
	/**
	 * Método que calcula y ejecuta el algoritmo SRT
	*/
	public void run() {
		Proceso miProceso;
		int ciclo =0;
		
		for(int i=0;i<listaProcesos.size();i++) {
			if(colaProcesos.isEmpty()) {
				colaProcesos.add(listaProcesos.get(i));
			}
			do {
				//cogemos el proceso que menos rafaga tenga en la cola de procesos
				miProceso= Collections.min(colaProcesos,Comparator.comparing(
						procesoM -> procesoM.getRafaga()));
				
				
				miProceso.setRafaga(miProceso.getRafaga()-1);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Ciclo "+ ciclo +"; " + miProceso.toString());
				ciclo++;
				
				super.buscarProceso(ciclo);
				
				if(miProceso.getRafaga()==0) {
					miProceso.setTiempoSalida(ciclo);
					colaProcesos.remove(miProceso);	
				}
			}while(miProceso.getRafaga()>0);
		}
		
		super.calcularIndicePen(listaProcesos);
	}
}
