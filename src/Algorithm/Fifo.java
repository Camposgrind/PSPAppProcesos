package Algorithm;

import java.util.ArrayList;

import Models.Proceso;

public class Fifo extends AbstractAlgorithm{
	/**
	 * Constructor 
	 * @param miLista lista de procesos para trabajar
	 */
	public Fifo(ArrayList<Proceso> miLista) {
		
		super(miLista);
	}
	/**
	 * Método que calcula y ejecuta el algoritmo FIFO
	 */
	public void run() {
		Proceso miProceso;
		int ciclo =0;
		int rafaga;
		
		//Recorremos la lista de procesos 
		for(int i=0;i<listaProcesos.size();i++) {

			miProceso = listaProcesos.get(i);
			//Si el tiempo de llegada del proceso es menor o igual que el ciclo en el que está 
			if(ciclo >= miProceso.getTiempoLlegada()) {
				rafaga = miProceso.getRafaga();
				
				//Recorremos la ráfaga y la imprimimos por pantalla
				for(int j=1;j<=rafaga;j++) {
					
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
					
				}
				miProceso.setRafaga(rafaga);
			}
			//Si el tiempo de llegada del proceso es mayor que el ciclo en el que está
			else {
				System.out.println("Nigún proceso en cola");
				miProceso.setTiempoSalida(ciclo);
				ciclo++;
			}
		}
		System.out.println("Procesos terminados");
		ciclo =0;
		System.out.println("Calculando indice de penalización ");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.calcularIndicePen(listaProcesos);
	}

}
