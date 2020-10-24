package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Models.Proceso;

public class Sjf extends AbstractAlgorithm{
	/**
	 * Constructor 
	 * @param miLista lista de procesos
	 */
	public Sjf(ArrayList<Proceso> miLista) {
		super(miLista);
		
	}
	/**
	 * Método que calcula y ejecuta el algoritmo SJF
	*/
	public void run() {
		Proceso miProceso;
		int ciclo =0;
		int rafaga;
		
		//mientras que los ciclos no sean los mismos que las rafagas finales 
		while(ciclo<super.calcularRafagas()) {

			for(int i=0;i<listaProcesos.size();i++) {
				//Si no hay ningun proceso en la cola añadimos el primero
				if(colaProcesos.isEmpty()) {
					colaProcesos.add(listaProcesos.get(i));
				}
				//pillamos de la cola de procesos el que menos ráfaga tenga 
				miProceso= Collections.min(colaProcesos,Comparator.comparing(
						procesoM -> procesoM.getRafaga()));
				rafaga = miProceso.getRafaga();
				
				for(int j=0;j<rafaga;j++) {
					
					miProceso.setRafaga(miProceso.getRafaga()-1);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Ciclo "+ ciclo +"; " + miProceso.toString());
					miProceso.setTiempoSalida(ciclo);
					ciclo++;
					super.buscarProceso(ciclo);
					
				}
				colaProcesos.remove(miProceso);
			}
			
			ciclo++;
		}
		super.calcularIndicePen(listaProcesos);	
	}
}
