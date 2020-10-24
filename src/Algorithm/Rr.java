package Algorithm;

import java.util.ArrayList;

import Models.Proceso;

public class Rr extends AbstractAlgorithm{
	//ESTADO
	protected int q;

	/**
	 * Constructor 
	 * @param miLista lista de procesos en la que vamos a trabajar 
	 * @param miQ el número del quantum que le vamos a pasar al algoritmo
	 */
	public Rr(ArrayList<Proceso> miLista, int miQ) {
		super(miLista);
		q= miQ;
		
	}
	
	/**
	 * Método que calcula y ejecuta el algoritmo Round Robin
	*/
	public void run() {
		Proceso miProceso;
		int ciclo =0;
		int rafaga;
		int rafagasMax = super.calcularRafagas();
		
		//mientras el numero de rafagas totales sea mayor que el ciclo
		while(ciclo<rafagasMax) {
	
			for(int i=0;i<listaProcesos.size();i++) {
				if(colaProcesos.isEmpty()) {
					colaProcesos.add(listaProcesos.get(i));
				}
				
				miProceso=colaProcesos.get(0);
				rafaga= miProceso.getRafaga();
				
				if(rafaga<q) {
					//Recorremos el bucle hasta la rafaga del proceso
					for(int j=0;j<=miProceso.getRafaga()-1;j++) {
						
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
				}
				else {
					//Si la ráfaga es mayor que el quantum, recorremos hasta el quantum
					for(int j=0;j<q;j++) {
						
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
						//Buscamos el proceso que hay que meter en la cola 
						//después de cada ciclo
						super.buscarProceso(ciclo);
					}
				}
				rafaga= miProceso.getRafaga();
				//quitamos el proceso de la lista 
				colaProcesos.remove(miProceso);
				//y lo añadimos al final si el proceso no ha terminado todavía 
				if(rafaga>0) {
					colaProcesos.add(miProceso);				}
			}
		}
		
		super.calcularIndicePen(listaProcesos);
	}
}
