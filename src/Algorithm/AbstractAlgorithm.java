package Algorithm;

import java.util.ArrayList;

import Models.Proceso;

public abstract class AbstractAlgorithm {
	
	//ESTADO
	/**
	 * Lista de que tontendr� todos los procesos que necesitamos
	 */
	protected ArrayList<Proceso> listaProcesos;
	/**
	 * Lista que nos valdr� para ir metiendo los procesos que estar�n<br>
	 * a la espera de ejecutarse porque estaba otro ejecut�ndose
	 */
	protected ArrayList<Proceso> colaProcesos;
	
	/**
	 * Constructor
	 * @param miLista lista de procesos a calcular
	 */
	public AbstractAlgorithm(ArrayList<Proceso> miLista) {
		listaProcesos = miLista;
		colaProcesos = new ArrayList<Proceso>();
		
	}
	
	//RESTO COMPORTAMIENTOS
	/**
	 * Comportamiento que busca el proceso que le toca entrar,<br>
	 * lo mete en nuestra cola de procesos por si no puede ejecutar en ese momento
	 * @param ciclo
	 */
	protected void buscarProceso(int ciclo) {
		Proceso miProceso = null;
		
		
		for(int i=0;i<listaProcesos.size();i++) {
			miProceso= listaProcesos.get(i);
			
			if(miProceso.getTiempoLlegada()==ciclo) {
				colaProcesos.add(miProceso);
			}
		}
	}
	/**
	 * M�todo para calcular las rafas totales pera hacer el bucle while 
	 * @return numeroRafagas numero de raf�gas totales de todos los procesos
	 */
	protected int calcularRafagas() {
		int numeroRafagas= 0;
		
		for (int i = 0; i < listaProcesos.size(); i++) {
			numeroRafagas += listaProcesos.get(i).getRafaga();
		}
		
		return numeroRafagas;
	}
	/**
	 * M�todo para calcular los indices de penalizaci�n y <br> 
	 * las medias totales de penalizaci�n 
	 * @param miLista lista de procesos para calcular
	 */
	protected void calcularIndicePen(ArrayList<Proceso> miLista) {
		double resultado =0;
		Proceso miProceso;
		double tiempoLlegada;
		double tiempoSalida;
		double rafaga;
		double resultadoProceso;
		
		for (int i=0;i<listaProcesos.size();i++) {
			
			miProceso = listaProcesos.get(i);
			tiempoLlegada = miProceso.getTiempoLlegada();
			tiempoSalida = miProceso.getTiempoSalida()+1;
			rafaga = miProceso.getRafagaInicial();
			
			resultadoProceso= (tiempoSalida-tiempoLlegada)/rafaga;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El indice de penalizaci�n del proceso "+ miProceso.getLetra() +" es " 
					+resultadoProceso);
			
			resultado += resultadoProceso; 	
					
			}
		
		resultado = resultado/(listaProcesos.size());
		System.out.println("La media de penalizaci�n es "+resultado);
	}
}
